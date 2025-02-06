package com.javacasestudy1bm;

public class CurrentAccount extends BankAccount{
    private double overdraftLimit;

    public CurrentAccount(long accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance, "current");
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setCurrentBalance(this.getCurrentBalance() + amount);
            System.out.println("Deposited: " + amount + ", New Balance: " + this.getCurrentBalance());
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (this.getCurrentBalance() - amount) >= -overdraftLimit) { // Overdraft facility
            setCurrentBalance(this.getCurrentBalance() - amount);
            System.out.println("Withdrawn: " + amount + ", New Balance: " + this.getCurrentBalance());
        } else {
            System.out.println("Exceeds overdraft limit or invalid withdrawal amount");
        }
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
