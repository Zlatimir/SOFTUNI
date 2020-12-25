import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, ArrayList<String>>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scan.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        map.entrySet().stream().forEach(cont -> {
            System.out.println(cont.getKey() + ":");
            cont.getValue().entrySet().stream().forEach(coun -> {
                System.out.println("  " + coun.getKey() + " -> " + String.join(", ", coun.getValue()));
            });
        });
    }
}
