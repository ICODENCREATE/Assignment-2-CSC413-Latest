package com.company;

import java.sql.SQLException;
import java.util.List;


public interface CustomerDAO<T>{
    CustomerDTO getCustomerById(int customerID) throws SQLException;

    int addCustomer(CustomerDTO customer) throws SQLException;

    int updateCustomer(CustomerDTO customer) throws SQLException;

    int deleteCustomer(int customerID) throws SQLException;

    int saveCustomer(CustomerDTO customer) throws SQLException;
}