package viceCity.core.interfaces;

import viceCity.Main;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

/**
 * Created by Zlatimir Ivanov on 6.4.2021 г..
 */

public class ControllerImpl implements Controller {
    private MainPlayer mainPlayer;
    private GangNeighbourhood gangNeighbourhood;
    private List<Player> civilPlayers;
    private Deque<Gun> guns;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.gangNeighbourhood = new GangNeighbourhood();
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
    }

    @Override
    public String addPlayer(String name) {
        civilPlayers.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }
        if (gun != null){
            guns.offer(gun);
            return String.format(GUN_ADDED, name, type);
        }
        return GUN_TYPE_INVALID;
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.poll();
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (name.equals("Vercetti")) {
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), mainPlayer.getName());
        }
        if (!civilPlayers.contains(name)) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
    }

    @Override
    public String fight() {
        gangNeighbourhood.action(mainPlayer, civilPlayers);
        if (mainPlayer.getLifePoints() == 100 &&
                civilPlayers.stream().mapToInt(Player::getLifePoints).sum() == civilPlayers.size() * 50) {
            return FIGHT_HOT_HAPPENED;
        }
        long deadPlayers = civilPlayers.stream().filter(p -> p.getLifePoints() == 0).count();
        StringBuilder out = new StringBuilder(FIGHT_HAPPENED).append(System.lineSeparator());
        out.append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints())).append(System.lineSeparator());
        out.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadPlayers)).append(System.lineSeparator());
        out.append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadPlayers));
        return out.toString().trim();
    }
}
