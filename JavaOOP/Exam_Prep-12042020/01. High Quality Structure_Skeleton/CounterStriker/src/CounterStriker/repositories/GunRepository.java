package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static CounterStriker.common.ExceptionMessages.*;

/**
 * Created by Zlatimir Ivanov on 27.3.2021 г..
 */

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection getModels() {
        return Collections.unmodifiableCollection(models);
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        Gun gun = models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
        if (gun == null) {
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }
        return gun;
    }
}
