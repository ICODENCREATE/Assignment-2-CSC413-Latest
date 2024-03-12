//Adharsh Thiagarajan

package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOConcrete implements AccountDAO {

    private static final String SELECT_QUERY = "SELECT * FROM accounts WHERE accountId = ?";
    private static final String INSERT_QUERY = "INSERT INTO accounts (accountId, balance) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE accounts SET balance = ? WHERE accountId = ?";
    private static final String DELETE_QUERY = "DELETE FROM accounts WHERE accountId = ?";

    private final Connection connection;

    public AccountDAOConcrete() {
        this.connection = connection;
    }

    @Override
    public AccountDTO getAccountById(int accountID) throws SQLException {
        AccountDTO account = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, String.valueOf(accountID));
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                double balance = result.getDouble("balance");
                account = new AccountDTO(accountID, balance);
            }
        }

        return account;
    }

    @Override
    public AccountDTO addAccount(AccountDTO account) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, account.getAccountID());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.executeUpdate();
        }
        return account;
    }

    @Override
    public int updateAccount(AccountDTO account) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setDouble(1, account.getBalance());
            preparedStatement.setString(2, account.getAccountID());
            preparedStatement.executeUpdate();
        }
        return account;
    }

    @Override
    public int deleteAccount(int accountID) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setString(1, String.valueOf(accountID));
            preparedStatement.executeUpdate();
        }
        return accountID;
    }

    @Override
    public AccountDTO saveAccount(AccountDTO account) throws SQLException {
        AccountDAO alreadyanAccount = (AccountDAO) getAccountById(Integer.parseInt(account.getAccountID()));

        if (alreadyanAccount == null){
            return addAccount(account);
        }
        else{
            return updateAccount(account);
        }
    }
}
