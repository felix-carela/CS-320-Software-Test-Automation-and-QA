package com.contactmanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {

    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    // Test adding a contact
    @Test
    public void testAddContact() {
        service.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull("Contact should be added", service.getContact("1234567890"));
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        service.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.deleteContact("1234567890");
        assertNull("Contact should be deleted", service.getContact("1234567890"));
    }

    // Test updating a contact
    @Test
    public void testUpdateContact() {
        service.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.updateContact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St");
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("First name should be updated to Jane", "Jane", updatedContact.getFirstName());
        assertEquals("Last name should be updated to Doe", "Doe", updatedContact.getLastName());
        assertEquals("Phone should be updated to 0987654321", "0987654321", updatedContact.getPhone());
        assertEquals("Address should be updated to 456 Elm St", "456 Elm St", updatedContact.getAddress());
    }

    // Testing addition of a contact with an existing ID
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        service.addContact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact("1234567890", "Jane", "Doe", "0987654321", "456 Elm St");
    }

    // Testing deletion of a non-existent contact
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonexistentContact() {
        service.deleteContact("nonexistentID");
    }

    // Testing update of a non-existent contact
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonexistentContact() {
        service.updateContact("nonexistentID", "Jane", "Doe", "0987654321", "456 Elm St");
    }
}
