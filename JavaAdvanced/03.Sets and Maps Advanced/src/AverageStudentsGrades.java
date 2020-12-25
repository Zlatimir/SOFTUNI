import java.util.*;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
            }
            students.get(name).add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double sum = 0.;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double avg = sum / entry.getValue().size();
            System.out.printf("%s -> ", entry.getKey());
            entry.getValue().stream().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avg);
        }
    }
}
