package JavaFundMidExam101219Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 30.10.2020 г..
 */

public class SchoolLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputLine = sc.nextLine().split("&");
        List<String> books = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            books.add(inputLine[i]);
        }

        String input = sc.nextLine();
        while (!input.equals("Done")) {
            String[] commandLine = input.split("\\s\\|\\s");
            switch (commandLine[0]) {
                case "Add Book":
                    if (!books.contains(commandLine[1])) {
                        books.add(0, commandLine[1]);
                    }
                    break;
                case "Take Book":
                    if (books.contains(commandLine[1])) {
                        books.remove(commandLine[1]);
                    }
                    break;
                case "Insert Book":
                    books.add(commandLine[1]);
                    break;
                case "Swap Books":
                    if (books.contains(commandLine[1]) && books.contains(commandLine[2])) {
                        //String temp = commandLine[1];
                        int index1 = books.indexOf(commandLine[1]);
                        int index2 = books.indexOf(commandLine[2]);
                        books.set(index1, commandLine[2]);
                        books.set(index2, commandLine[1]);
                    }
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commandLine[1]);
                    if (index >= 0 && index < books.size()) {
                        System.out.println(books.get(index));
                    }
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < books.size() - 1; i++) {
            System.out.print(books.get(i) + ", ");
        }
        System.out.println(books.get(books.size()-1));
    }
}
