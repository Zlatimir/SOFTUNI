import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 16.2.2021 г..
 */

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> magicQueue = new ArrayDeque<>();

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            materialsStack.push(num);
        }

        nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            magicQueue.offer(num);
        }

        int doll = 0;//150
        int woodenTrain = 0;//250
        int teddyBear = 0;//300
        int bicycle = 0;//400

        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()){
            int material = materialsStack.peek();
            int magic = magicQueue.peek();

            int multiplication = material * magic;

            if (multiplication == 150){
                doll++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (multiplication == 250){
                woodenTrain++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (multiplication == 300){
                teddyBear++;
                materialsStack.pop();
                magicQueue.poll();
            } else if (multiplication == 400){
                bicycle++;
                materialsStack.pop();
                magicQueue.poll();
            } else {
                if (multiplication < 0){
                    int sum = material + magic;
                    materialsStack.pop();
                    magicQueue.poll();
                    materialsStack.push(sum);
                } else {
                    if (multiplication > 0){
                        magicQueue.poll();
                        materialsStack.pop();
                        materialsStack.push(material + 15);
                    }
                }
            }

            if (material == 0){
                materialsStack.pop();
            }

            if (magic == 0){
                magicQueue.poll();
            }


        }

        boolean sucsess = (doll > 0 && woodenTrain > 0) || (teddyBear > 0 && bicycle > 0);

        if (sucsess){
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(materialsStack.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        if (!magicQueue.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(magicQueue.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        if (bicycle > 0){
            System.out.println("Bicycle: " + bicycle);
        }
        if (doll > 0){
            System.out.println("Doll: " + doll);
        }
        if (teddyBear > 0){
            System.out.println("Teddy bear: " + teddyBear);
        }
        if (woodenTrain > 0){
            System.out.println("Wooden train: " + woodenTrain);
        }
    }
}
