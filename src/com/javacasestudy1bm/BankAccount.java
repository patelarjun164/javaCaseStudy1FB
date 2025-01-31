package com.javacasestudy1bm;

public class BankAccount {
    private long accountNo;
    private String accountHolderName;
    private double currentBalance;
    private String accountType;

    public BankAccount(long accountNo, String accountHolderName, double currentBalance, String accountType) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.currentBalance = currentBalance;
        this.accountType = accountType;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
