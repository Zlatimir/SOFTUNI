import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.7.2020 г..
 */

public class EqualArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] arr2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int sum = 0;
        boolean notEqual = false;
        int diffIndex = 0;
        int maxLength = Math.min(arr1.length, arr2.length);
        if (!(arr1.length == arr2.length)){
            notEqual = true;
            diffIndex = maxLength;
        }
        for (int i = 0; i < maxLength; i++) {
            sum = sum + arr1[i];
            if (!(arr1[i] == arr2[i])){
                notEqual = true;
                diffIndex = i;
                break;
            }
        }
        if (notEqual){
            System.out.printf("Arrays are not identical. Found difference at %d index.", diffIndex);
        } else {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        }
    }
}
