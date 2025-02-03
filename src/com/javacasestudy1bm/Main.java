package com.javacasestudy1bm;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Bank bm = new Bank("HDFC", "HDFC018FB");
//        bm.displayAllAccount();
        System.out.println(bm.getBankName());
        bm.deposit();
        bm.deposit();
        bm.withdraw();
        bm.withdraw();
//        bm.checkCurrentBalance();
        bm.displayTransactions();
//        bm.totalWithdrawAmount();
//        bm.totalDepositAmount();
//        bm.getTransactionsBetweenDates();
    }

}