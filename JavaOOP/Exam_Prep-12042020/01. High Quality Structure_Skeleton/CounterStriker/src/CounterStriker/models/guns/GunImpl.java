package CounterStriker.models.guns;

import static CounterStriker.common.ExceptionMessages.*;

/**
 * Created by Zlatimir Ivanov on 27.3.2021 г..
 */

public abstract class GunImpl implements Gun{
    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 1) {
            throw new NullPointerException(INVALID_GUN_NAME);
        }
        this.name = name;
    }

    private void setBulletsCount(int bulletsCount) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
        this.bulletsCount = bulletsCount;
    }

    protected void decreaseBullets(int amount) {
        this.bulletsCount -= amount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        return 0;
    }
}
