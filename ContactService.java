package com.contactmanager;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Method to add a contact
    public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contactID, new Contact(contactID, firstName, lastName, phone, address));
    }

    // Method to delete a contact
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID);
    }

    // Method to update contact information
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }
    
    // Method to get a contact
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
