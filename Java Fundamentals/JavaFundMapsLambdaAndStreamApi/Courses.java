package JavaFundMapsLambdaAndStreamApi;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 13.11.2020 г..
 */

public class Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("end")){
            String[] data = input.split(" : ");
            String course = data[0];
            String student = data[1];

            courses.putIfAbsent(course, new ArrayList<>());
            courses.get(course).add(student);

            input = sc.nextLine();
        }
        courses.entrySet().stream().sorted((f, s) -> s.getValue().size() - f.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue().stream().sorted((f, s) -> f.compareTo(s))
                            .forEach(s -> System.out.println("-- " + s));
                });
    }
}
