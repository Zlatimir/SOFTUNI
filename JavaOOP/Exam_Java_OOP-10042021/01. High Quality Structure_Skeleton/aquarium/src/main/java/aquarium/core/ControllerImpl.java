package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

/**
 * Created by Zlatimir Ivanov on 10.4.2021 г..
 */

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
            aquariums.add(aquarium);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
            aquariums.add(aquarium);
        } else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Ornament")) {
            decoration = new Ornament();
            decorations.add(decoration);
        } else if (type.equals("Plant")) {
            decoration = new Plant();
            decorations.add(decoration);
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration type = decorations.findByType(decorationType);
        if (type == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        boolean flag = false;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(type);
                flag = true;
                break;
                //Possible problems with invalid aquarium name
            }
        }
        if (flag) {
            decorations.remove(type);
            return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
        }
        return null;
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }

        Fish fish = null;
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        if (!aquarium.getClass().getSimpleName().substring(0, 1).equals(fishType.substring(0, 1))) {
            return WATER_NOT_SUITABLE;
        }
        aquarium.addFish(fish);

        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = null;
        for (Aquarium aquarium1 : aquariums) {
            if (aquarium1.getName().equals(aquariumName)) {
                aquarium = aquarium1;
                break;
            }
        }
        double sum = aquarium.getDecorations().stream().mapToDouble(d -> d.getPrice()).sum();
        double sum1 = aquarium.getFish().stream().mapToDouble(f -> f.getPrice()).sum();
        return String.format(VALUE_AQUARIUM, aquariumName, sum + sum1);
    }

    @Override
    public String report() {
        StringBuilder out = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            out.append(aquarium.getInfo());
            out.append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
