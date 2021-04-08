package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 4.4.2021 г..
 */

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)) {
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        if (models.contains(model)) {
            models.remove(model);
            return true;
        }
        return false;
    }

    @Override
    public Gun find(String name) {
        for (Gun gun : models) {
            if (gun.getName().equals(name)) {
                return gun;
            }
        }
        return null;
    }
}
