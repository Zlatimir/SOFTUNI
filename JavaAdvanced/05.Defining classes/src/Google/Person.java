package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> listPokemons;
    private List<Parents> listParents;
    private List<Children> listChildren;

    public Person(String name){
        this.name = name;
        this.company = new Company("", "", 0.0);
        this.car = new Car("", 0);
        this.listPokemons = new ArrayList<>();
        this.listParents = new ArrayList<>();
        this.listChildren = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void addPokemon(Pokemon pokemon) {
        this.listPokemons.add(pokemon);
    }

    public void addParent(Parents parent) {
        this.listParents.add(parent);
    }

    public void addChildren(Children child) {
        this.listChildren.add(child);
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public void getListPokemons() {
        for (Pokemon pokemon : listPokemons) {
            System.out.println(pokemon);
        }
    }

    public void getListParents() {
        for (Parents parent : listParents) {
            System.out.println(parent);
        }
    }

    public void getListChildren() {
        for (Children child : listChildren) {
            System.out.println(child);
        }
    }

    //    @Override
//    public String toString() {
//        return String.format("%s%nCompany:%n%s%nCar:%n%s%nPokemon:%n%s%n"
//                , this.name, this.company, this.car, this.listPokemons)
//    }
}
