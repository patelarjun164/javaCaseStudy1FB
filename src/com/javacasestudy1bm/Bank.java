package com.javacasestudy1bm;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Bank {
    Scanner sc = new Scanner(System.in);
    public static int count = 5;
    public static long accountNum = 12345105;
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

    public void displayAllAccounts() {
        for (int i = 0; i < count; i++) {
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

    private int findAccount(long accNo) {
        for (int i = 0; i < count; i++) {
            if (bankAccounts[i].getAccountNo() == accNo) {
                return i;
            }
        }
        return -1;
    }

    private long getAccountNumberInput() {
        System.out.print("Enter Account Number: ");
        return sc.nextLong();
    }

    //counter activities
    public void createAccount() {
        long tempAccountNum = accountNum++;
        System.out.println("Your Account number is " + tempAccountNum);
        System.out.println("Enter Account Holder name");
        String accountHolderName = sc.nextLine();
        System.out.println("Enter the type of Account");
        String accountType = sc.nextLine();
        bankAccounts[count] = new BankAccount(tempAccountNum, accountHolderName, 0, accountType);
        System.out.println("Enter the amount youw want to deposit, Min deposit amount is 5000");
        double depositAmount = sc.nextDouble();
        while (depositAmount < 5000) {
            System.out.println("Amount should be more than 5000");
            System.out.println("Enter amount greater than 5000");
            depositAmount = sc.nextDouble();
        }
        bankAccounts[count].deposit(depositAmount);
        count++;
        System.out.println("Account Created Successfully...!");
    }

    public void deposit() {
        long accNo = getAccountNumberInput();
        int indexOfAccount = findAccount(accNo);
        if (indexOfAccount == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Current balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");

        System.out.println("Enter amount you want to deposit");
        double depositAmount = sc.nextDouble();
        bankAccounts[indexOfAccount].deposit(depositAmount);
    }

    public void withdraw() {
        long accNo = getAccountNumberInput();
        int indexOfAccount = findAccount(accNo);
        if (indexOfAccount == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Current balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");
        System.out.println("Enter amount you want to withdraw");
        double withdrawAmount = sc.nextDouble();
        bankAccounts[indexOfAccount].withdraw(withdrawAmount);
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

        System.out.println("Total Deposit Amount is: " + bankAccounts[indexOfAccount].calTotalDeposit() + "₹");
        ;
    }

    public void getTransactionsBetweenDates() {
        System.out.println("Enter the Account Number");
        long tempAcNo = sc.nextLong();
        int indexOfAccount = findAccountWithAccNo(tempAcNo);

        if (indexOfAccount == -1) {
            System.out.println("Account not exists");
            return;
        }

        System.out.print("Enter Starting date (yyyy-MM-dd): ");

        sc.nextLine();
        String userInput = sc.nextLine();
        LocalDate startDate = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("Enter Ending Date (yyyy-MM-dd): ");
        userInput = sc.nextLine();
        LocalDate endDate = LocalDate.parse(userInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        bankAccounts[indexOfAccount].transBetweenDates(startDate, endDate);
    }

    //EOD summary
    public void displayAllTransactionOfBank() {
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < bankAccounts[i].gettCount(); j++) {
                if (bankAccounts[i].trr[j].getTransactionDate().isEqual(LocalDate.now())) {
                    bankAccounts[i].trr[j].displatSingleTransaction();
                }
            }
        }
    }

    public void totalDepositFromBank() {
        double tempDepositAmount=0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < bankAccounts[i].gettCount(); j++) {
                if (bankAccounts[i].trr[j].getTransactionDate().isEqual(LocalDate.now()) && bankAccounts[i].trr[j].getType().equals("deposit")) {
                    tempDepositAmount += bankAccounts[i].trr[j].getAmount();
                }
            }
        }
        System.out.println("Total Deposit From Bank Today is: "+ tempDepositAmount+"₹");
    }

    public void totalWithdrawFromBank() {
        double tempWithdrawAmount=0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < bankAccounts[i].gettCount(); j++) {
                if (bankAccounts[i].trr[j].getTransactionDate().isEqual(LocalDate.now()) && bankAccounts[i].trr[j].getType().equals("withdraw")) {
                    tempWithdrawAmount += bankAccounts[i].trr[j].getAmount();
                }
            }
        }
        System.out.println("Total Withdraw From Bank Today is: "+ tempWithdrawAmount+"₹");
    }

    public void deleteAccount() {
        long accNo = getAccountNumberInput();
        int indexOfAccount = findAccount(accNo);
        if (indexOfAccount == -1) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("Account Number is " + bankAccounts[indexOfAccount].getAccountNo());
        System.out.println("Current balance is: " + bankAccounts[indexOfAccount].getCurrentBalance() + "₹");
        System.out.println("Press 1 to confirm your action, you can not reverse once account deleted!");
        System.out.println("Press 0 to cancel");
        int tempDecision = sc.nextInt();
        if(tempDecision==1){
            for (int i = indexOfAccount; i < count-1; i++) {
                bankAccounts[i] = bankAccounts[i+1];
            }
            count--;
            System.out.println("Account deleted Successfully...!");
            return;
        }
        else {
            System.out.println("Account Deletion Cancel!");
        }
    }
}
