//Adharsh Thiagarajan

package com.company;

import java.util.List;
import java.util.ArrayList;

public class Customer extends CustomerDTO implements Comparable<Customer> {
    private List<Account> accounts;
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthday;
    private String username;
    private String createdAt;

    public Customer(int id, String username, String email, String phone) {
    }

    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String birthday, String username) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        if (accounts == null){
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    @Override
    public int compareTo(Customer o) {
        return this.createdAt.compareTo(o.createdAt);
    }
}

