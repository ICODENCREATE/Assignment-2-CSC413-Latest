//Adharsh Thiagarajan

package com.company;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void testCustomerConstructorAndGetters(){
        com.company.Customer customer = new com.company.Customer(314, "Adharsh", "Thiagarajan", "adharsh@example.com", "1234567890", "2000-02-12", "AdharshThiagarajan");

        assertEquals(314, customer.getCustomerID());
        assertEquals("Adharsh", customer.getFirstName());
        assertEquals("Thiagarajan", customer.getLastName());
        assertEquals("adharsh@example.com", customer.getEmail());
        assertEquals("1234567890", customer.getPhoneNumber());
        assertEquals("2000-02-12", customer.getBirthday());
        assertEquals("AdharshThiagarajan", customer.getUsername());
    }
    @Test
    public void testSettersAndGetters(){
        com.company.Customer customer = new com.company.Customer(result.getInt("id"), result.getString("username"), result.getString("email"), result.getString("phone"));

        customer.setCustomerID(575);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john@example.com");
        customer.setPhoneNumber("9734800623");
        customer.setBirthday("1995-05-18");
        customer.setUsername("johndoe");

        assertEquals(575, customer.getCustomerID());
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john@example.com", customer.getEmail());
        assertEquals("9734800623", customer.getPhoneNumber());
        assertEquals("1995-05-18", customer.getBirthday());
        assertEquals("johndoe", customer.getUsername());
    }

}
