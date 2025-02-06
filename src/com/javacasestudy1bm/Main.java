package com.javacasestudy1bm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank hdfcBank = new Bank("HDFC", "HDFC018FB");

        while (true) {
            System.out.println("\n------ BANKING SYSTEM MENU ------");
            System.out.println("1. Create An Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. View Transactions for Account");
            System.out.println("7. View Withdraw Total for an Account");
            System.out.println("8. View Deposit Total for an Account");
            System.out.println("9. Transactions Between Dates for an Account");
            System.out.println("10. Display All Transaction of Today");
            System.out.println("11. Total Deposit Amount From Bank");
            System.out.println("12. Total Withdraw Amount From Bank");
            System.out.println("13. Delete Bank Account");
            System.out.println("14. Loan Account Operations");
            System.out.println("15. Saving Account Operations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> hdfcBank.createAccount();
                case 2 -> hdfcBank.displayAllAccounts();
                case 3 -> hdfcBank.deposit();
                case 4 -> hdfcBank.withdraw();
                case 5 -> hdfcBank.checkCurrentBalance();
                case 6 -> hdfcBank.displayTransactions();
                case 7 -> hdfcBank.totalWithdrawAmount();
                case 8 -> hdfcBank.totalDepositAmount();
                case 9 -> hdfcBank.getTransactionsBetweenDates();
                case 10 -> hdfcBank.displayAllTransactionOfBank();
                case 11 -> hdfcBank.totalDepositFromBank();
                case 12 -> hdfcBank.totalWithdrawFromBank();
                case 13 -> hdfcBank.deleteAccount();
                case 14 -> hdfcBank.loanAccountOperations();
                case 15 -> hdfcBank.savingAccountOperations();
                case 0 -> {
                    System.out.println("Exiting Banking System...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}