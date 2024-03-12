//Adharsh Thiagarajan

package com.company;

import java.sql.SQLException;


public class AccountDTO {
    private String accountID;
    private double balance;
    private String createdAt;
    private static AccountDAOConcrete ad = new AccountDAOConcrete();

    public AccountDTO(){

    }

    public AccountDTO(int accountID, double balance) {
        this.accountID = String.valueOf(accountID);
        this.balance = balance;
    }

    public AccountDTO(String accountID, double balance, String createdAt) {
        this.accountID = accountID;
        this.balance = balance;
        this.createdAt = createdAt;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public static AccountDTO accountByID(String accountID) {
    AccountDTO anAccount = null;
    try {
        anAccount = ad.getAccountById(Integer.parseInt(accountID));
    } catch (SQLException se) {
        System.out.println(se.getMessage());
    }
    if (anAccount != null) {
        System.out.println(anAccount.toString());
    }
    return anAccount;
}

    public static int performUpdate(AccountDTO accountDTO) {
        int updateResult = -1;
        try {
            updateResult = ad.updateAccount(accountDTO);
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        if (updateResult != -1) {
            System.out.println("\nUpdate Successful");
        }
        return updateResult;
    }
}