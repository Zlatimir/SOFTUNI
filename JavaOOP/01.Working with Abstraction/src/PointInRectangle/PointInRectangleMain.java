package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class PointInRectangleMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coordinates = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point upperRight = new Point(coordinates[2], coordinates[3]);
        Rectangle rectangle = new Rectangle(bottomLeft, upperRight);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            coordinates = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            Point point = new Point(coordinates[0], coordinates[1]);

            System.out.println(rectangle.isIn(point));
        }
    }
}
