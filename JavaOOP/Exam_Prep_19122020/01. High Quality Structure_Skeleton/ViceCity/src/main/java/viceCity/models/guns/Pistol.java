package viceCity.models.guns;

/**
 * Created by Zlatimir Ivanov on 4.4.2021 г..
 */

public class Pistol extends BaseGun {
    private int bulletsLoaded;

    public Pistol(String name) {
        super(name, 10, 90);
        bulletsLoaded = 10;

    }

    @Override
    public int fire() {
        if (this.canFire()) {
            if (this.bulletsLoaded == 0) reload();
        }
        bulletsLoaded --;
        return 1;
    }

    private void reload() {
        if (this.getTotalBullets() > 10) {
            this.setTotalBullets(this.getTotalBullets() - 10);
            this.bulletsLoaded = 10;
        }
    }
}
