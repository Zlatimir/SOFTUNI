import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, double[]> students = new TreeMap<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scan.nextLine();
            String[] stringGrade = scan.nextLine().split("\\s+");
            students.putIfAbsent(name, new double[stringGrade.length]);
            for (int j = 0; j < stringGrade.length; j++) {
                students.get(name)[j] = Double.parseDouble(stringGrade[j]);
            }
        }

        students.forEach((k, v) -> {
            double sum = 0;
            for (int i = 0; i < v.length; i++) {
                sum += v[i];
            }
            double avg = sum / v.length;
            System.out.println(k + " is graduated with " + avg);
        });
    }
}
