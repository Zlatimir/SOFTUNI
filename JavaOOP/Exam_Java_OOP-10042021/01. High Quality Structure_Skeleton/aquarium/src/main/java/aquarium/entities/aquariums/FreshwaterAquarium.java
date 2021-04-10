package aquarium.entities.aquariums;

/**
 * Created by Zlatimir Ivanov on 10.4.2021 г..
 */

public class FreshwaterAquarium extends BaseAquarium {
    private int capacity;

    public FreshwaterAquarium(String name) {
        super(name, 50);
    }
}
