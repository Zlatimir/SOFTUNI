import javafx.scene.input.KeyCombination;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by Zlatimir Ivanov on 20.3.2021 г..
 */

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Class<Reflection> clazz = Reflection.class;

        Method[] methods = clazz.getDeclaredMethods();

        Map<String, Method> getters = new TreeMap<>();
        Map<String, Method> setters = new TreeMap<>();


        


        for (Method m : methods) {
            if (m.getName().startsWith("get")) {
                getters.put(m.getName(), m);
            } else if (m.getName().startsWith("set")) {
                setters.put(m.getName(), m);
            }
        }

        Arrays.stream(clazz.getDeclaredFields()).filter(f -> !Modifier.isPrivate(f.getModifiers())).
                sorted(Comparator.comparing(Field::getName)).forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        getters.entrySet().stream().filter(g -> !Modifier.isPublic(g.getValue().getModifiers())).
                forEach(g -> System.out.printf("%s have to be public!%n", g.getKey()));

        setters.entrySet().stream().filter(s -> !Modifier.isPrivate(s.getValue().getModifiers()))
                .forEach(s -> System.out.printf("%s have to be private!%n", s.getKey()));


    }
}
