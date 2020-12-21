import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.12.2020 г..
 */

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().trim().split("\\s+");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int n = 1;

        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(n++);
            }
        }

        String input = sc.nextLine();

        while (!input.equals("Nuke it from orbit")){
            String[] data = input.trim().split("\\s+");
            int row = Integer.parseInt(data[0]);
            int col = Integer.parseInt(data[1]);
            int radius = Integer.parseInt(data[2]);

            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            
            input = sc.nextLine();
        }

        for(List<Integer> integers : matrix){
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static boolean isInRange(int row, int col, ArrayList<ArrayList<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }
}