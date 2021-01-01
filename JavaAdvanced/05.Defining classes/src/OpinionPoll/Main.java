package OpinionPoll;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Person> personSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            Person person = new Person();
            person.setName(data[0]);
            person.setAge(Integer.parseInt(data[1]));
            personSet.add(person);
        }

        personSet.stream().filter(e -> e.getAge()>30)
                .sorted(Comparator.comparing(f -> f.getName()))
                .forEach(e -> System.out.println(e.getName() + " - " + e.getAge()));


    }
}
