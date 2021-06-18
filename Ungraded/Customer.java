package Ungraded;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Customer {
    private String id;
    private int accountNumber;
    private double balance;

    public Customer(String id, int accountNumber, double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Customer() {
        id="A000";
        accountNumber=00000;
        balance=0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws InvalidInputException {
        if (Character.isAlphabetic(id.charAt(0))&&Character.isDigit(id.charAt(1))&&Character.isDigit(id.charAt(2))
                &&Character.isDigit(id.charAt(3)))
            this.id = id;
        else {
            throw new InvalidInputException("Invalid ID");
        }

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) throws InvalidInputException {
        if (String.valueOf(accountNumber).length()==5)
            this.accountNumber = accountNumber;
        else
            throw new InvalidInputException("Invalid Account Number");
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) throws InvalidInputException {
        if (balance>1000)
            this.balance = balance;
        else
            throw new InvalidInputException("Error: Balance too low");
    }

    public static void main(String[] args) {
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);

        while (true){

            try {
                System.out.println("Input customer ID: ");
                customer.setId(scanner.nextLine());
                System.out.println("Input customer account number: ");
                customer.setAccountNumber(Integer.parseInt(scanner.nextLine()));
                System.out.println("Input customer account balance: ");
                customer.setBalance(scanner.nextDouble());
                break;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
