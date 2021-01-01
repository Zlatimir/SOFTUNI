package Lab_BankAccount;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class BankAccount {
    private int id;
    private double balance;
    private static double interest = 0.02;
    private static int currentID = 1;

    public BankAccount(){
        this.id = currentID++;
    }

    public static void setInterestRate(double interest){
        BankAccount.interest = interest;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public double getInterest(int years){
        return this.balance * years * BankAccount.interest;
    }

    public int getId(){
        return this.id;
    }
}
