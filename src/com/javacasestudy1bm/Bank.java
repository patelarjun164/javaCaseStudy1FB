package com.javacasestudy1bm;

public class Bank {
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

    public void displayAllAccount(){
        for (int i = 0; i < 5; i++) {
            System.out.println("\nAccount Number: "+ bankAccounts[i].getAccountNo());
            System.out.println("Account Holder Name: "+ bankAccounts[i].getAccountHolderName());
            System.out.println("Account Type: "+ bankAccounts[i].getAccountType());
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

}
