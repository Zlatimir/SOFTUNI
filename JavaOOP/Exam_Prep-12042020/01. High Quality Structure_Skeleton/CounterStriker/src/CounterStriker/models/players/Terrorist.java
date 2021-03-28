package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

/**
 * Created by Zlatimir Ivanov on 27.3.2021 г..
 */

public class Terrorist extends PlayerImpl {

    public Terrorist(String username, int health, int armor, Gun gun) {
        super(username, health, armor, gun);
    }
}
