//Adharsh Thiagarjan


package com.company;
import java.sql.SQLException;

public class TransactionDTO {
    private String transactionId;
    private String accountId;
    private double amount;
    private String createdAT;

    static TransactionDAOConcrete transactionDAO = new TransactionDAOConcrete();

    public TransactionDTO() {
        // Default constructor
    }

    public TransactionDTO(String transactionId, String accountId, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
    }

    // Getter and Setter methods
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public static Transaction getTransactionById(String transactionId) {
        Transaction transaction = null;
        try {
            transaction = (Transaction) transactionDAO.getAllTransactions(transaction);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (transaction != null) {
            System.out.println(transaction.toString());
        }
        System.out.println("\nFetched Transaction with ID: " + transactionId + " Transaction Details:\n" + transaction.toString());
        return transaction;
    }

    public static int performUpdate(TransactionDTO transaction) {
        int updateResult = -1;
        try {
            updateResult = transactionDAO.updateTransaction(transaction);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (updateResult != -1) {
            System.out.println("\nUpdate Successful");
            System.out.println("Transaction Details:\n" + transaction.toString());
        }
        return updateResult;
    }
}
