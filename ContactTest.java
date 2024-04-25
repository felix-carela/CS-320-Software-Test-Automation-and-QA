package com.contactmanager;

import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {

	// Test creating a valid Contact instance
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull("Contact should not be null", contact);
        assertEquals("Incorrect ID", "1234567890", contact.getContactID());
        assertEquals("Incorrect first name", "John", contact.getFirstName());
        assertEquals("Incorrect last name", "Doe", contact.getLastName());
        assertEquals("Incorrect phone number", "1234567890", contact.getPhone());
        assertEquals("Incorrect address", "123 Main St", contact.getAddress());
    }
    
    // Test ID
    // Test Contact constructor with invalid ID
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactID() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }
    
    // Test Contact constructor with long ID
    @Test(expected = IllegalArgumentException.class)
    public void testLongContactID() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
    }
    // Test Contact constructor with maximum length ID
    @Test
    public void testMaxLengthContactID() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	assertEquals("Max length ID should be accepted", "1234567890", contact.getContactID());
    }
    
    // Test first name
    // Test Contact constructor with a null first name
    @Test(expected = IllegalArgumentException.class)
    public void testNullFirstName() {
        new Contact("1234567890", null, "Doe", "1234567890", "123 Main St");
    }

    // Test Contact constructor with a long first name
    @Test(expected = IllegalArgumentException.class)
    public void testLongFirstName() {
        new Contact("1234567890", "JohnathanMax", "Doe", "1234567890", "123 Main St");
    }
    
    // Test setting an invalid first name (null)
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullFirstName() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setFirstName(null);
    }
    
    // Test max length first name
    @Test
    public void testMaxLengthFirstName() {
        Contact contact = new Contact("1234567890", "JohnJohnJo", "Doe", "1234567890", "123 Main St"); // 10 characters
        assertEquals("Expected first name to be 'JohnJohnJo'", "JohnJohnJo", contact.getFirstName());
    }
    
    // Test last name
    // Test Contact constructor with a null last name
    @Test(expected = IllegalArgumentException.class)
    public void testNullLastName() {
    	new Contact("1234567890", "John", null, "1234567890", "123 Main St");
    }
    
    // Test Contact constructor with a long last name
    @Test(expected = IllegalArgumentException.class)
    public void testLongLastName() {
    	new Contact("1234567890", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
    }
    
    
    // Test setting an invalid last name (null)
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullLastName() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setLastName(null);
    }
    
    // Test max length last name
    @Test
    public void testMaxLengthLastName() {
        Contact contact = new Contact("1234567890", "John", "DoeDoeDoeD", "1234567890", "123 Main St"); // 10 characters
        assertEquals("Expected last name to be 'DoeDoeDoeD'", "DoeDoeDoeD", contact.getLastName());
    }
    
    // Test phone number
    // Test setting an invalid phone number
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidPhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("1234"); // Too short
    }
    
    // Test setting an invalid phone number with non-digit characters
    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidPhoneNonDigit() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setPhone("12345abcde");
    }
    
    // Test setting a too-long phone number
    @Test(expected = IllegalArgumentException.class)
    public void testSetTooLongPhone() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setPhone("123456789012");
    }
    
    // Test setting a maximum length phone number
    @Test
    public void testSetMaxLengthPhone() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setPhone("1234567890");
    	assertEquals("Max length phone should be accepted", "1234567890", contact.getPhone());
    }
    
    // Test address
    // Test setting a null address
    @Test(expected = IllegalArgumentException.class)
    public void testSetNullAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress(null);
    }
    
    // Test setting a long address
    @Test(expected = IllegalArgumentException.class)
    public void testSetLongAddress() {
    	Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
    	contact.setAddress("123 Elm Street, Springfield, Anytown, Anystate, 12345");
    }
    
    // Test null address
    @Test(expected = IllegalArgumentException.class)
    public void testNullAddress() {
        new Contact("1234567890", "John", "Doe", "1234567890", null);
    }
    
    // Test max length address
    @Test
    public void testMaxLengthAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123456789012345678901234567890"); // 30 characters
        assertEquals("Expected address to be of 30 characters", "123456789012345678901234567890", contact.getAddress());
    }

    // Test getters
    @Test
    public void testGetters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("Get contact ID failed", "1234567890", contact.getContactID());
        assertEquals("Get first name failed", "John", contact.getFirstName());
        assertEquals("Get last name failed", "Doe", contact.getLastName());
        assertEquals("Get phone number failed", "1234567890", contact.getPhone());
        assertEquals("Get address failed", "123 Main St", contact.getAddress());
    }

    // Test setters
    @Test
    public void testSetters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm Street");
        assertEquals("Set first name failed", "Jane", contact.getFirstName());
        assertEquals("Set last name failed", "Smith", contact.getLastName());
        assertEquals("Set phone number failed", "0987654321", contact.getPhone());
        assertEquals("Set address failed", "456 Elm Street", contact.getAddress());
    }
}
