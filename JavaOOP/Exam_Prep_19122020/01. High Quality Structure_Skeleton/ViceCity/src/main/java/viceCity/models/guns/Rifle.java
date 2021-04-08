package viceCity.models.guns;

/**
 * Created by Zlatimir Ivanov on 4.4.2021 г..
 */

public class Rifle extends BaseGun {
    private int bulletsLoaded;

    public Rifle(String name) {
        super(name, 50, 450);
        this.bulletsLoaded = 50;
    }

    @Override
    public int fire() {
        if (this.canFire()) {
            if (this.bulletsLoaded == 0) reload();
        }
        bulletsLoaded -= 5;
        return 5;
    }

    private void reload() {
        if (this.getTotalBullets() > 50) {
            this.setTotalBullets(this.getTotalBullets() - 50);
            this.bulletsLoaded = 50;
        }
    }
}
