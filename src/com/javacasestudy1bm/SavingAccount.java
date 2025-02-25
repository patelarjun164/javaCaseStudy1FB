package com.javacasestudy1bm;

import java.time.LocalDate;
import java.time.LocalTime;

public class SavingAccount extends BankAccount{
    private double interestRate;

    public SavingAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance, "saving");
        this.interestRate = 6;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            setCurrentBalance(this.getCurrentBalance() + amount);
            trr[this.gettCount()] = new TransactionHistory(123457, "deposit", amount, LocalDate.now(), LocalTime.now());
            this.settCount(this.gettCount()+1);
            System.out.println("Deposited: " + amount + ", New Balance: " + this.getCurrentBalance());
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && this.getCurrentBalance() - amount >= 5000) { // Minimum balance condition
            setCurrentBalance(this.getCurrentBalance() - amount);
            trr[this.gettCount()] = new TransactionHistory(123457, "withdraw", amount, LocalDate.now(), LocalTime.now());
            this.settCount(this.gettCount()+1);
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
