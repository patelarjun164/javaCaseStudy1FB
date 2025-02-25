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

        bankAccounts[0] = new SavingAccount(12345100, "Arjun Patel", 150000);
        bankAccounts[1] = new SalaryAccount(12345101, "Rohit Pawar", 12500);
        bankAccounts[2] = new SavingAccount(12345102, "Ritik Mahajan", 15500);
        bankAccounts[3] = new CurrentAccount(12345103, "Harshada", 50000, 10000);
        bankAccounts[4] = new LoanAccount(12345104, "Rishi Awasthi", 15000, 6, 9);
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
        sc.nextLine();
        System.out.println("Enter Account Holder name");
        String accountHolderName = sc.nextLine();
        System.out.println("Enter the type of Account");
        System.out.println("Enter 1 For Saving Account");
        System.out.println("Enter 2 For Current Account");
        System.out.println("Enter 3 For Salary Account");
        System.out.println("Enter 4 For Loan Account");
        int accountTypeNum = sc.nextInt();
        //Opening Saving Account
        if (accountTypeNum == 1) {
            System.out.println("Enter the amount you want to deposit, Min deposit amount is 5000");
            double depositAmount = sc.nextDouble();
            while (depositAmount < 5000) {
                System.out.println("Amount should be more than 5000");
                System.out.println("Enter amount greater than 5000");
                depositAmount = sc.nextDouble();
            }
            bankAccounts[count] = new SavingAccount(tempAccountNum, accountHolderName, 0);
            bankAccounts[count++].deposit(depositAmount);
            System.out.println("Saving Account Created Successfully.");

        }
        //Opening Current Account
        else if (accountTypeNum == 2) {
            //long accountNumber, String accountHolder, double balance, double overdraftLimit
            System.out.println("Enter the amount you want to deposit, Min deposit amount is 5000");
            double depositAmount = sc.nextDouble();
            while (depositAmount < 5000) {
                System.out.println("Amount should be more than 5000");
                System.out.println("Enter amount greater than 5000");
                depositAmount = sc.nextDouble();
            }
            System.out.println("Enter Overdraft Limit For this account");
            double overDraftLimit = sc.nextDouble();
            bankAccounts[count] = new CurrentAccount(tempAccountNum, accountHolderName, 0,overDraftLimit);
            bankAccounts[count++].deposit(depositAmount);
            System.out.println("Current Account Created Successfully.");
        }

        //Opening Salary Account
        else if (accountTypeNum == 3){
            bankAccounts[count++] = new SalaryAccount(tempAccountNum, accountHolderName, 0);
            System.out.println("Salary Account Created Successfully.");
        }

        //Opening Loan Account
        else if (accountTypeNum == 4) {
            System.out.println("Enter Loan Amount: ");
            double loanAmount = sc.nextDouble();

            System.out.println("Enter Interest Rate (in %): ");
            double interestRate = sc.nextDouble();

            System.out.println("Enter Tenure in Months: ");
            int tenureMonths = sc.nextInt();
            bankAccounts[count++] = new LoanAccount(tempAccountNum, accountHolderName, loanAmount, interestRate, tenureMonths);
            System.out.println("Loan Account Created Successfully");
        }
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
                    bankAccounts[i].trr[j].displaySingleTransaction();
                }
            }
        }
    }

    public void totalDepositFromBank() {
        double tempDepositAmount = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < bankAccounts[i].gettCount(); j++) {
                if (bankAccounts[i].trr[j].getTransactionDate().isEqual(LocalDate.now()) && bankAccounts[i].trr[j].getType().equals("deposit")) {
                    tempDepositAmount += bankAccounts[i].trr[j].getAmount();
                }
            }
        }
        System.out.println("Total Deposit From Bank Today is: " + tempDepositAmount + "₹");
    }

    public void totalWithdrawFromBank() {
        double tempWithdrawAmount = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < bankAccounts[i].gettCount(); j++) {
                if (bankAccounts[i].trr[j].getTransactionDate().isEqual(LocalDate.now()) && bankAccounts[i].trr[j].getType().equals("withdraw")) {
                    tempWithdrawAmount += bankAccounts[i].trr[j].getAmount();
                }
            }
        }
        System.out.println("Total Withdraw From Bank Today is: " + tempWithdrawAmount + "₹");
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
        if (tempDecision == 1) {
            for (int i = indexOfAccount; i < count - 1; i++) {
                bankAccounts[i] = bankAccounts[i + 1];
            }
            count--;
            System.out.println("Account deleted Successfully...!");
            return;
        } else {
            System.out.println("Account Deletion Cancel!");
        }
    }

    // Add a method to handle loan account operations
    public void loanAccountOperations() {
        System.out.print("Enter Loan Account Number: ");
        long accNo = sc.nextLong();
        int index = findAccount(accNo);
        if (index == -1 || !(bankAccounts[index] instanceof LoanAccount)) {
            System.out.println("Invalid Loan Account!");
            return;
        }

        System.out.println("\n----- LOAN ACCOUNT OPERATIONS -----");
        System.out.println("1. Pay EMI");
        System.out.println("2. Check Loan Balance");
        System.out.println("3. Apply Late Fees");
        System.out.println("4. Get Remaining Loan Amount");
        System.out.println("5. Get Total Repaid Amount");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> payEMI(index);             // Implement this method
            case 2 -> checkLoanBalance(index);  // Implement this method
            case 3 -> applyLateFee(index);      // Implement this method
            case 4 -> getRemainingLoanAmount(index);  // Implement this method
            case 5 -> getTotalRepaidAmount(index);   // Implement this method
            default -> System.out.println("Invalid choice!");
        }
    }

    // Method to pay EMI for a loan account
    private void payEMI(int index) {
        System.out.print("Enter EMI Payment Amount: ");
        double amount = sc.nextDouble();
        if (bankAccounts[index] instanceof LoanAccount loanAccount) {
            loanAccount.payEMI(amount);
        } else {
            System.out.println("Selected Account is NOT a Loan Account, Enter valid Account Number!");
        }
    }

    // Method to check the remaining loan balance
    private void checkLoanBalance(int index) {
        if (bankAccounts[index] instanceof LoanAccount loanAccount) {
            System.out.println("Remaining Loan Balance: ₹" + loanAccount.getRemainingLoanAmount());
        } else {
            System.out.println("Selected Account is NOT a Loan Account, Enter valid Account Number!");
        }
    }

    // Method to apply late fee on a loan account
    private void applyLateFee(int index) {
        if (bankAccounts[index] instanceof LoanAccount loanAccount) {
            if (!loanAccount.applyLateFee()) {
                System.out.println("No late fee applied, the loan is not overdue.");
            }
        } else {
            System.out.println("Selected Account is NOT a Loan Account, Enter valid Account Number!");
        }
    }

    // Method to get the total repaid amount for a loan
    private void getTotalRepaidAmount(int index) {
        LoanAccount loanAccount = (LoanAccount) bankAccounts[index];
        System.out.println("Total Repaid Amount: ₹" + loanAccount.getAmountRepaid());

    }

    // Method to get the remaining loan amount
    private void getRemainingLoanAmount(int index) {
        LoanAccount loanAccount = (LoanAccount) bankAccounts[index];
        System.out.println("Remaining Loan Amount: ₹" + loanAccount.getRemainingLoanAmount());
    }

    public void savingAccountOperations() {
        //applyinterest
        long accNo = getAccountNumberInput();
        int indexOfAccount = findAccount(accNo);
        if (indexOfAccount == -1) {
            System.out.println("Account not found!");
            return;
        }

        if (bankAccounts[indexOfAccount] instanceof SavingAccount savingAccount) {
            savingAccount.applyInterest();
        } else {
            System.out.println("Entered Account is not Valid!");
        }

    }

}
