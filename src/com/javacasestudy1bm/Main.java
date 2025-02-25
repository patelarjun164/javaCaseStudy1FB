package com.javacasestudy1bm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank hdfcBank = new Bank("HDFC", "HDFC018FB");

        while (true) {
            System.out.println("\n------ BANKING SYSTEM MENU ------");
            System.out.println("1. Counter Activities");
            System.out.println("2. Account Lifecycle");
            System.out.println("3. Interest Calculation");
            System.out.println("4. End of the Day Summary");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int mainChoice = sc.nextInt();

            switch (mainChoice) {
                case 1 -> counterActivities(sc, hdfcBank);
                case 2 -> accountLifecycle(sc, hdfcBank);
                case 3 -> interestCalculation(sc, hdfcBank);
                case 4 -> endOfDaySummary(sc, hdfcBank);
                case 0 -> {
                    System.out.println("Exiting Banking System...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void counterActivities(Scanner sc, Bank hdfcBank) {
        while (true) {
            System.out.println("\n------ COUNTER ACTIVITIES ------");
            System.out.println("1. Create An Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Delete Bank Account");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> hdfcBank.createAccount();
                case 2 -> hdfcBank.displayAllAccounts();
                case 3 -> hdfcBank.deposit();
                case 4 -> hdfcBank.withdraw();
                case 5 -> hdfcBank.checkCurrentBalance();
                case 6 -> hdfcBank.deleteAccount();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void accountLifecycle(Scanner sc, Bank hdfcBank) {
        while (true) {
            System.out.println("\n------ ACCOUNT LIFECYCLE ------");
            System.out.println("1. View Transactions for Account");
            System.out.println("2. View Withdraw Total for an Account");
            System.out.println("3. View Deposit Total for an Account");
            System.out.println("4. Transactions Between Dates for an Account");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> hdfcBank.displayTransactions();
                case 2 -> hdfcBank.totalWithdrawAmount();
                case 3 -> hdfcBank.totalDepositAmount();
                case 4 -> hdfcBank.getTransactionsBetweenDates();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void interestCalculation(Scanner sc, Bank hdfcBank) {
        while (true) {
            System.out.println("\n------ INTEREST CALCULATION ------");
            System.out.println("1. Loan Account Operations");
            System.out.println("2. Saving Account Operations");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> hdfcBank.loanAccountOperations();
                case 2 -> hdfcBank.savingAccountOperations();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void endOfDaySummary(Scanner sc, Bank hdfcBank) {
        while (true) {
            System.out.println("\n------ END OF THE DAY SUMMARY ------");
            System.out.println("1. Display All Transactions of Today");
            System.out.println("2. Total Deposit Amount From Bank");
            System.out.println("3. Total Withdraw Amount From Bank");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> hdfcBank.displayAllTransactionOfBank();
                case 2 -> hdfcBank.totalDepositFromBank();
                case 3 -> hdfcBank.totalWithdrawFromBank();
                case 0 -> { return; }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}