import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zlatimir Ivanov on 20.12.2020 г..
 */

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        int degrees = 0;
        String command = sc.nextLine();
        String regex = "Rotate\\((\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group(1));
        } else {
            System.out.println("Invalid input!");
        }

        String line = sc.nextLine();
        int maxLength = line.length();
        while (!line.equals("END")) {
            list.add(line);
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
            line = sc.nextLine();
        }
        int rows = list.size();
        int cols = maxLength;

        String[][] matrix = fillMatrix(list, rows, cols);

        String[][] output = matrix;

        int rotation = degrees % 360;
        switch (rotation) {
            case 0:
                break;
            case 90:
                output = rotate90(matrix);
                break;
            case 180:
                output = rotate90(rotate90(matrix));
                break;
            case 270:
                output = rotate90(rotate90(rotate90(matrix)));
                break;

        }
        //System.out.println(String.join(", ", matrix[0]));
        for (int i = 0; i < output.length; i++) {
            System.out.println(String.join("", output[i]));
        }
    }

    private static String[][] rotate90(String[][] input) {
        int n = input.length;
        int m = input[0].length;
        String[][] output = new String[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output[j][n - 1 - i] = input[i][j];
            }
        }
        return output;
    }

    private static String[][] fillMatrix(ArrayList<String> list, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j > list.get(i).length() - 1) {
                    matrix[i][j] = " ";
                } else {
                    matrix[i][j] = list.get(i).charAt(j) + "";
                }
            }
        }

        return matrix;
    }
}
