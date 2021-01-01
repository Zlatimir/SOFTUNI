package Lab_BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<BankAccount> accountList = new ArrayList<>();
        String input = sc.nextLine();

        while (!input.equals("End")){

            String[] data = input.split("\\s+");
            String command = data[0];
            switch (command){
                case "Create":
                    BankAccount account = new BankAccount();
                    accountList.add(account);
                    System.out.println("Account ID" + account.getId() + " created");
                    break;
                case "Deposit":
                    int id = Integer.parseInt(data[1]);
                    double amount = Double.parseDouble(data[2]);
                    if (id > accountList.size()){
                        System.out.println("Account does not exist");
                    } else {
                        accountList.get(id - 1).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
                    }
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(data[1]);
                    BankAccount.setInterestRate(interest);
                    break;
                case "GetInterest":
                    id = Integer.parseInt(data[1]);
                    int years = Integer.parseInt(data[2]);
                    if (id > accountList.size()){
                        System.out.println("Account does not exist");
                    } else {
                        System.out.printf("%.2f%n", accountList.get(id - 1).getInterest(years));
                    }
                    break;
            }

            input = sc.nextLine();
        }
    }
}
