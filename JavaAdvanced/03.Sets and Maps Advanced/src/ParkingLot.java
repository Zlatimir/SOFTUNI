import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String input = scan.nextLine();

        while (!input.equals("END")){
            String[] data = input.split(", ");
            String direction = data[0];
            String licenceNumber = data[1];
            if (direction.equals("IN")){
                parking.add(licenceNumber);
            } else {
                parking.remove(licenceNumber);
            }

            input = scan.nextLine();
        }

        if (parking.size() == 0){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : parking) {
                System.out.println(s);
            }
        }
    }
}
