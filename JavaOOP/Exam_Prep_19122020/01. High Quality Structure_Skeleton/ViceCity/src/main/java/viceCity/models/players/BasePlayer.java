package viceCity.models.players;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static viceCity.common.ExceptionMessages.*;

/**
 * Created by Zlatimir Ivanov on 4.4.2021 г..
 */

public abstract class BasePlayer implements Player {
    private String name;
    private int lifePoints;
    private List<Gun> gunRepository;

    protected BasePlayer(String name, int lifePoints) {
        this.setName(name);
        this.lifePoints = lifePoints;
        this.gunRepository = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLAYER_NULL_USERNAME);
        }
        this.name = name;
    }

    private void setLifePoints(int lifePoints) {
        if (lifePoints < 0) {
            throw new IllegalArgumentException(PLAYER_LIFE_POINTS_LESS_THAN_ZERO);
        }
        this.lifePoints = lifePoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public boolean isAlive() {
        return this.lifePoints > 0;
    }

    @Override
    public List getGunRepository() {
        return gunRepository;
    }

    @Override
    public void takeLifePoints(int points) {
        setLifePoints(Math.max(0, this.lifePoints - points));
    }
}
