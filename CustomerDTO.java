//Adharsh Thiagarajan

package com.company;

import java.sql.*;



public class CustomerDTO {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthday;
    private String username;

    static CustomerDAOConcrete cd = new CustomerDAOConcrete();

    public CustomerDTO() {
        // Default constructor
    }

    public CustomerDTO(int customerID, String firstName, String lastName, String email, String phoneNumber, String birthday, String username){
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.username = username;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(){
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(){
        this.birthday = birthday;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(){
        this.username = username;
    }

    public static CustomerDTO customerByID(int customerId) {
        CustomerDTO customer = null;
        try {
            customer = cd.getCustomerById(customerId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(customer != null) {
            System.out.println(customer.toString());
        }
        System.out.println("\nFetched Customer with ID: " + customerId + " Customer Details:\n" + customer.toString());
        return customer;
    }

    public static int performUpdate(CustomerDTO customer) {
        int updateResult = -1;
        try {
            updateResult = cd.updateCustomer(customer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(updateResult != -1) {
            System.out.println("\nUpdate Successful");
            System.out.println("Customer Details:\n" + customer.toString());
        }
        return updateResult;
    }
}
