package com.javacasestudy1bm;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance, "saving");
        this.interestRate = 6;
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
        if (amount > 0 && this.getCurrentBalance() - amount >= 1000) { // Minimum balance condition
            setCurrentBalance(this.getCurrentBalance() - amount);
            System.out.println("Withdrawn: " + amount + ", New Balance: " + this.getCurrentBalance());
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
        }
    }

    public void applyInterest() {
        double interest = this.getCurrentBalance() * (interestRate / 100);
        setCurrentBalance(this.getCurrentBalance() + interest);
        System.out.println("Interest Applied: " + interest + ", New Balance: " + this.getCurrentBalance());
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
