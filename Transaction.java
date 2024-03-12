//Adharsh Thiagarjan


package com.company;

public class Transaction implements Comparable<Transaction>{
    private String transactionID;
    private String accountID;
    private double amount;
    private String createdAt;

    private com.company.Account account;
    private com.company.Customer customer;

    public Transaction(String transactionID, String accountID, double amount) {
        this.transactionID = transactionID;
        this.accountID = accountID;
        this.amount = amount;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccount(com.company.Account account){
        this.account = account;
    }

    public void setCustomer(com.company.Customer customer){
        this.customer = customer;
    }

    public com.company.Account getAccount(){
        return account;
    }

    public com.company.Customer getCustomer(){
        return customer;
    }

    @Override
    public int compareTo(Transaction o) {
        return this.createdAt.compareTo(o.createdAt);
    }

    public void add(Transaction transactions) {
    }
}
