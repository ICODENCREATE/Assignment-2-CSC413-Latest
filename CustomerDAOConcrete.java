//Adharsh Thiagarajan

package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerDAOConcrete implements CustomerDAO {
    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;

    CustomerDAOConcrete() {
        try {
            connection = DatabaseConnection.getConnection(); // Replace YourDatabaseConnection with the appropriate class/method to get database connection
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
    }

    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerID) throws SQLException {
        pStatement = connection.prepareStatement(DatabaseConnection.getSelect());
        pStatement.setInt(1,customerID);
        result = pStatement.executeQuery();

        Customer updatedEmp = null;
        if (result.next()) {
            Customer x = new Customer(result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));
            updatedEmp = new Customer( result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));
        }

        return updatedEmp;
    }

    @Override
    public int addCustomer(CustomerDTO customer) throws SQLException {

        int result = -1;
        pStatement = connection.prepareStatement(DatabaseConnection.getInsert());
        pStatement.setString(1, customer.getUsername());
        pStatement.setString(2, customer.getEmail());
        result = pStatement.executeUpdate();
        disconnect();

        return result;

    }

    @Override
    public int updateCustomer(CustomerDTO customer) throws SQLException {

        int result = -1;

        pStatement = connection.prepareStatement(DatabaseConnection.getUpdate());
        pStatement.setString(1, customer.getUsername());
        pStatement.setString(2, customer.getEmail());
        pStatement.setString(3, customer.getPhoneNumber());
        pStatement.setInt(4, customer.getCustomerID());
        result = pStatement.executeUpdate();

        return result;
    }

    @Override
    public int deleteCustomer(int customerID) throws SQLException {

        int result = -1;

        pStatement = connection.prepareStatement(DatabaseConnection.getDelete());
        pStatement.setInt(1,customerID.getCustomerID());
        result = pStatement.executeUpdate();

        return result;
    }

    @Override
    public int saveCustomer(CustomerDTO customer) throws SQLException {
        int result = -1;

        pStatement = connection.prepareStatement(DatabaseConnection.getInsert());
        pStatement.setString(1, customer.getUsername());
        pStatement.setString(2, customer.getEmail());
        pStatement.setInt(3, customer.getCustomerID());
        result = pStatement.executeUpdate();

        return result;

    }
}
