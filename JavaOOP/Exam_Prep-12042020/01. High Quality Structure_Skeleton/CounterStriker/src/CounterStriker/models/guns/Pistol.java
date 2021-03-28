package CounterStriker.models.guns;

/**
 * Created by Zlatimir Ivanov on 27.3.2021 г..
 */

public class Pistol extends GunImpl {
    private static final int BULLETS_TO_SHOOT = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_TO_SHOOT) {
            return 0;
        }
        super.decreaseBullets(BULLETS_TO_SHOOT);
        return BULLETS_TO_SHOOT;
    }
}
