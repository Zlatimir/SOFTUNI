package viceCity.models.players;

import java.util.List;

public interface Player {
    String getName();

    int getLifePoints();

    boolean isAlive();

    List getGunRepository();

    void takeLifePoints(int points);
}
