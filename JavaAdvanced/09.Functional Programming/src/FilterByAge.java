import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(", ");
            people.putIfAbsent(data[0], Integer.parseInt(data[1]));
            people.put(data[0], Integer.parseInt(data[1]));
        }

        String condition = sc.nextLine();
        int ageLimit = Integer.parseInt(sc.nextLine());
        String printFormat = sc.nextLine();

        Predicate<Integer> tester = ageTest(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(printFormat);
        printFilteredPeople(people, tester, printer);

    }

    static Predicate<Integer> ageTest(String condition, int age){
        Predicate<Integer> tester = null;
        switch (condition){
            case "older":
                tester = x -> x >= age;
                break;
            case "younger":
                tester = x -> x <= age;
                break;
        }
        return tester;
    }

    static Consumer<Map.Entry<String, Integer>> createPrinter(String format){
        Consumer<Map.Entry<String, Integer>> printer = null;

        switch (format){
            case "name":
                printer = p -> System.out.println(p.getKey());
                break;
            case "age":
                printer = p -> System.out.println(p.getValue());
                break;
            case "name age":
                printer = p -> System.out.println(p.getKey() + " - " + p.getValue());
                break;
        }
        return printer;
    }

    static  void printFilteredPeople(LinkedHashMap<String, Integer> people, Predicate<Integer> tester
            , Consumer<Map.Entry<String, Integer>> printer){
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (tester.test(people.get(entry.getKey()))){
                printer.accept(entry);
            }
        }
    }
}
