package com.javacasestudy1bm;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
//import java.time.temporal.ChronoUnit;

public class TransactionHistory {
    private static final Random RANDOM = new Random();
    private static final AtomicInteger last3Digit = new AtomicInteger(100);
    private long referenceId;
    private String type;
    private double amount;
    private LocalDate transactionDate;
    private LocalTime transactionTime;

    public TransactionHistory(long referenceId, String type, double amount, LocalDate transactionDate, LocalTime transactionTime) {
        this.referenceId = generateReferenceId();
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
    }

    private long generateReferenceId() {
        int randomPart = 100000 + RANDOM.nextInt(900000); // Generates a 6-digit random number
        int sequentialPart = last3Digit.getAndIncrement(); // Ensures sequence in last 3 digits

        if (sequentialPart > 999) { // Reset sequence if it exceeds 999
            last3Digit.set(100);
            sequentialPart = last3Digit.getAndIncrement();
        }

        return (long) randomPart * 1000 + sequentialPart; // Generates a unique 9-digit ID
    }


    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(long referenceId) {
        this.referenceId = referenceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void displaySingleTransaction(){
        System.out.println("Reference Id: " + this.getReferenceId());
        System.out.println("Type of Transaction: " + this.getType());
        System.out.println(("Transaction Amount: ") + this.getAmount());
        System.out.println("Transaction Date: " + this.getTransactionDate());
        System.out.println("Transaction Time: " + this.getTransactionTime());
        System.out.println("------***-----");
    }
}
