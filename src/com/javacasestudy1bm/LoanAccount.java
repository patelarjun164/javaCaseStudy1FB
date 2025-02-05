package com.javacasestudy1bm;

public class LoanAccount extends BankAccount{
    private double interestRate;
    private int tenureMonths;
    private double emiPayment;
    private int transactionCount;

    public LoanAccount(long accountNo, String accountHolderName, double loanAmount, double interestRate, int tenureMonths) {
        super(accountNo, accountHolderName, -loanAmount, "Loan");  // Negative balance for loan
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.emiPayment = calculateEMI();
        this.transactionCount = 0;
    }

    // Calculate EMI using standard formula
    private double calculateEMI() {
        double monthlyInterestRate = (interestRate / 100) / 12;
        return Math.abs(getCurrentBalance()) * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths))
                / (Math.pow(1 + monthlyInterestRate, tenureMonths) - 1);
    }

    // Calculate interest for the loan
    public void calculateInterest() {
        double interest = Math.abs(getCurrentBalance()) * (interestRate / 100);
        setCurrentBalance(getCurrentBalance() - interest);
        System.out.println("Interest Charged: ₹" + interest + ". Updated Loan Balance: ₹" + getCurrentBalance());
    }

    // Pay EMI method
    public boolean payEMI(double amount) {
        if (amount < emiPayment) {
            System.out.println("Error: Minimum EMI payment required: ₹" + emiPayment);
            return false;
        }

        setCurrentBalance(getCurrentBalance() + amount);
        transactionCount++;
        System.out.println("Payment of ₹" + amount + " received. Remaining Loan Balance: ₹" + getCurrentBalance());

        if (getCurrentBalance() >= 0) {
            System.out.println("Congratulations! Your loan is fully repaid.");
        }
        return true;
    }

    // Apply late fees if the EMI payment is overdue
    public boolean applyLateFee() {
        if (isLoanOverdue()) {
            double lateFee = Math.abs(getCurrentBalance()) * 0.02; // 2% late fee
            setCurrentBalance(getCurrentBalance() - lateFee);
            System.out.println("Late fee of ₹" + lateFee + " applied. New Loan Balance: ₹" + getCurrentBalance());
            return true;
        }
        return false;
    }

    // Check if loan payment is overdue (for late fees)
    private boolean isLoanOverdue() {
        return transactionCount < tenureMonths; // If payments are behind schedule
    }

    // Get remaining loan amount
    public double getRemainingLoanAmount() {
        return Math.abs(getCurrentBalance());
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from Loan Accounts.");
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        if (getCurrentBalance() >= 0) {
            System.out.println("Loan fully repaid.");
        }
    }
}
