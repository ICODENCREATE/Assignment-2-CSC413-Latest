//Adharsh Thiagarjan

package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import org.modelmapper.ModelMapper;

import static com.company.TransactionDTO.transactionDAO;

public class DTOAndDAODemo {

    static Connection connection;
    private final static CustomerDAOConcrete customerDAO = new CustomerDAOConcrete();
    private final static TransactionDAOConcrete transacDAO = new TransactionDAOConcrete();
    private final static AccountDAOConcrete accountDAO = new AccountDAOConcrete();

    static String sampleCustomerId = "13456";
    static String sampleTransactionId = "92317";
    static String sampleAccountId = "83025";

    public static void main(String[] args) throws SQLException {

        try {
            connection = DatabaseConnection.getConnection();
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        // Fetch a customer with the given ID
        CustomerDTO customer = performCustomerFetch(sampleCustomerId);
        System.out.println("Fetched customer: " + customer);

        // Fetch a transaction with the given ID
        TransactionDTO transaction = performTransactionFetch(sampleTransactionId);
        System.out.println("Fetched transaction: " + transaction);

        // Fetch an account with the given ID
        AccountDTO account = performAccountFetch(sampleAccountId);
        System.out.println("Fetched account: " + account);

        // Disconnect db connection
        try {
            DatabaseConnection.disconnect();
        } catch(SQLException se) {
            System.out.println("Exception trying to close connection. Message: \n" + se.getMessage());
        }
    }

    private static CustomerDTO performCustomerFetch(String customerID) throws SQLException {
        return customerDAO.getCustomerById(Integer.parseInt(customerID));
    }

    private static TransactionDTO performTransactionFetch(String transactionId) {
        return transactionDAO.getTransactionById(transactionId);
    }

    private static AccountDTO performAccountFetch(String accountID) throws SQLException {
        return accountDAO.getAccountById(Integer.parseInt(accountID));
    }
}

