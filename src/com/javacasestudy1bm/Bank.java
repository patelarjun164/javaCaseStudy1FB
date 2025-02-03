package com.javacasestudy1bm;

import java.util.Scanner;

public class Bank {
    Scanner sc = new Scanner(System.in);
    public static int count = 5;
    private String bankName;
    private String ifscCode;

    private BankAccount[] bankAccounts = new BankAccount[10];

    public Bank(String bankName, String ifscCode) {
        this.bankName = bankName;
        this.ifscCode = ifscCode;

        bankAccounts[0] = new BankAccount(12345100, "Arjun Patel", 150000, "Saving");
        bankAccounts[1] = new BankAccount(12345101, "Rohit Pawar", 12500, "Salary");
        bankAccounts[2] = new BankAccount(12345102, "Ritik Mahajan", 15500, "Saving");
        bankAccounts[3] = new BankAccount(12345103, "Harshada", 50000, "Current");
        bankAccounts[4] = new BankAccount(12345104, "Rishi Awasthi", 42000, "Loan");
    }

    public void displayAllAccount() {
        for (int i = 0; i < 5; i++) {
            System.out.println("\nAccount Number: " + bankAccounts[i].getAccountNo());
            System.out.println("Account Holder Name: " + bankAccounts[i].getAccountHolderName());
            System.out.println("Account Type: " + bankAccounts[i].getAccountType());
        }
    }

    public String getBankName() {
        return bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    private int findAccountWithAccNo(long accNO) {
        for (int i = 0; i < count; i++) {
            if (accNO == bankAccounts[i].getAccountNo()) {
                return i;
            }
        }
        return -1;
    }

    //counter activities
    public void deposit() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.println("Current balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");

        System.out.println("Enter amount you want to deposit");
        double depositAmount = sc.nextDouble();
        bankAccounts[indexOfAccount].withdraw(depositAmount);
        System.out.println("Amount Deposited Successfully");
        System.out.println("Updated Balance is: " + bankAccounts[indexOfAccount].getCurrentBalance());
    }

    public void withdraw() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.println("Current balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");
        if (bankAccounts[indexOfAccount].getCurrentBalance() < 0) {
            System.out.println("Your current Balance is 0, you are not able to withdraw money!");
            return;
        }

        if (bankAccounts[indexOfAccount].getCurrentBalance() < BankAccount.getMinBalance()) {
            System.out.println("Your might charge as your min Balance is less than allowed limit!");
        }

        System.out.println("Enter amount you want to withdraw");
        double withdrawAmount = sc.nextDouble();
        bankAccounts[indexOfAccount].withdraw(withdrawAmount);
        System.out.println("Amount Debited Successfully");
        System.out.println("Updated Balance is: " + bankAccounts[indexOfAccount].getCurrentBalance());
    }

    public void checkCurrentBalance() {

        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.println("Current Balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");
    }

    //Account lifecycle
    public void displayTransactions() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        bankAccounts[indexOfAccount].displayTransactions();
    }

    public void totalWithdrawAmount() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.println("Total Withdraw Amount is: " + bankAccounts[indexOfAccount].calTotalWithdraw() + "₹");
    }

    public void totalDepositAmount() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.println("Total Deposit Amount is: " + bankAccounts[indexOfAccount].calTotalDeposit() + "₹");;
    }

    public void getTransactionsBetweenDates() {
        System.out.println("Enter Starting Date:");

        System.out.println("Enter Starting Date:");
    }
}
