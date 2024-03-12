package com.company;

import java.util.ArrayList;
import java.util.List;

public class Account implements Comparable<Account> {
    private List<com.company.Transaction> transactions;
    private String accountID;
    private double balance;
    private String createdAt;

    public Account(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transactions){
        if (transactions != null){
            //transactions = new ArrayList<>(); // Cannot infer arguments
            transactions.add(transactions);
        }
    }

    public List<Transaction> getTransactions(){
        return transactions;
    }

    @Override
    public int compareTo(Account o) {
        if (this.balance > o.balance) {
            return -1;
        } else if (this.balance < o.balance) {
            return 1;
        } else {
            return 0;
        }
    }
}