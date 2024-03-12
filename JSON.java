//Adharsh Thiagarajan

package com.company;

//import com.fasterxml.jackson.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.json.stream.*;
import javax.json.JsonReader;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.Json;


public class JSON {
    public static void main(String[] args){
        String jsonCustomerString = "{\"customerID\" : \"321\", \"name\":\"John Doe\", \"email\":\"john@example.com\"}";
        String jsonAccountString = "{\"accountID\":\"123456789\", \"balance\":1000.0, \"createdAt\":\"2024-03-12\"}";
        String jsonTransactionString = "{\"transactionID\":\"987654321\", \"accountID\":\"123456789\", \"amount\":500.0, \"createdAt\":\"2024-03-12\"}";

        ObjectMapper om = new ObjectMapper();

        try{
            Customer x = objectMapper.readValue(jsonCustomerString, Customer.class);
            System.out.println("'" + "Customer name is: " + x.getName() + " and email is: " + x.getEmail() + "'");

            String customerJSONString = objectMapper.writeValueAsString(x);
            System.out.println("JSON string representation of Customer: " + customerJSONString);

            Account acc = objectMapper.readValue(jsonAccountString, Account.class);
            System.out.println("Account object with ID '" + acc.getAccountID() + "' and balance '" + acc.getBalance() + "'");

            String accountJsonString = objectMapper.writeValueAsString(acc);
            System.out.println("JSON string representation of Account: " + accountJsonString);

            Transaction transac = objectMapper.readValue(jsonTransactionString, Transaction.class);
            System.out.println("Transaction object with ID '" + transac.getTransactionID() + "' and amount '" + transac.getAmount() + "'");

            String transactionJsonString = objectMapper.writeValueAsString(transac);
            System.out.println("JSON string representation of Transaction: " + transactionJsonString);

        }
        catch (JsonProccesingException e){ //Cannot resolve symbol 'JSONProccesingException'
            e.printStackTrace(); // Cannot resolve method 'printStackTrace()'
        }

    }
}
