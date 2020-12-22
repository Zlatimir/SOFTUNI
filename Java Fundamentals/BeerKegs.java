import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */

public class BeerKegs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        float max = 0;
        String modelMax = "";
        for (int i = 0; i < n; i++) {
            String model = sc.nextLine();
            float radius = Float.parseFloat(sc.nextLine());
            int height = Integer.parseInt(sc.nextLine());
            float vol = (float)Math.PI * radius * radius * height;
            if (vol > max){
                max = vol;
                modelMax = model;
            }
        }
        System.out.println(modelMax);
    }
}
