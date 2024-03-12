//Adharsh Thiagarjan


package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOConcrete implements TransactionDAO {

    private Connection connection;
    private static final String INSERT_QUERY = "INSERT INTO transactions (transaction_id, account_id, amount) VALUES (?, ?, ?)";
    private static final String SELECT_ID_QUERY = "SELECT * FROM transactions WHERE transaction_id = ?";
    private static final String SELECT_ACCOUNT_ID_QUERY = "SELECT * FROM transactions WHERE account_id = ?";
    private static final String SELECT_QUERY = "SELECT * FROM transactions";
    private static final String UPDATE_QUERY = "UPDATE transactions SET account_id = ?, amount = ? WHERE transaction_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM transactions WHERE transaction_id = ?";

    public TransactionDAOConcrete(){
        this.connection = connection;
    }

    @Override
    public TransactionDTO getTransactionById(String transactionID) {
        TransactionDTO transaction = null;
        try (Statement statement = connection.prepareStatement(SELECT_QUERY)){
            ((PreparedStatement) statement).setString(1,transactionID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String accountID = result.getString("account_ID");
                double amount = result.getDouble("amount");
                transaction = new TransactionDTO(transactionID, accountID, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }


    @Override
    public List<TransactionDTO> getTransactionsByAccountID(String accountID) {
        List<TransactionDTO> transactions = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_ID_QUERY)) {
            preparedStatement.setString(1, accountID);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                String transactionId = result.getString("transaction_id");
                double amount = result.getDouble("amount");
                // Other fields retrieval if needed
                TransactionDTO transaction = new TransactionDTO(transactionId, accountID, amount);
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }


    @Override
    public boolean addTransaction(TransactionDTO transaction) {
        return false;
    }

    @Override
    public int updateTransaction(TransactionDTO transaction) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, transaction.getTransactionId());
            statement.setString(2, transaction.getAccountId());
            statement.setDouble(3, transaction.getAmount());
            statement.executeUpdate();
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean deleteTransaction(String transactionID) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, transactionID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
