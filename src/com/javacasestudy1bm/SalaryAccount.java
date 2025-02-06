package com.javacasestudy1bm;

public class SalaryAccount extends BankAccount{
    public SalaryAccount(long accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance, "salary");
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
        if (amount > 0 && this.getCurrentBalance() - amount >= 0) { // No minimum balance restriction
            setCurrentBalance(this.getCurrentBalance() - amount);
            System.out.println("Withdrawn: " + amount + ", New Balance: " + this.getCurrentBalance());
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
        }
    }
}
