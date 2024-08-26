package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contactservice.Contact;
import contactservice.ContactService;

public class ContactServiceTest {
    private ContactService contactService;

    // Set up the contact service before each test
    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    
    
    // Method to provide test contact information
    private Contact getTestContact() {
        return new Contact("0123456789", "Brett", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
    }

    
    
    
    // Test to add a contact
    @Test
    public void testAddContact() {
        Contact contact = getTestContact();
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("0123456789"));
    }

    
    
    // Test to check adding a duplicate contact
    @Test
    public void testAddDuplicateContact() {
        Contact contact = getTestContact();
        contactService.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact);
        });
    }

    
    
    // Test to delete a contact
    @Test
    public void testDeleteContact() {
        Contact contact = getTestContact();
        contactService.addContact(contact);
        contactService.deleteContact("0123456789");
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("0123456789");
        });
    }

    
    
    
    // Test to check deleting a non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("0123456789");
        });
    }

    
    
    // Test to update a contact
    @Test
    public void testUpdateContact() {
        Contact contact = getTestContact();
        contactService.addContact(contact);
        contactService.updateContact("0123456789", "Ema", "Baboid", "9092922299", "1234 Box Rd");
        Contact updatedContact = contactService.getContact("0123456789");
        assertEquals("Ema", updatedContact.getFirstName());
        assertEquals("Baboid", updatedContact.getLastName());
        assertEquals("9092922299", updatedContact.getPhone());
        assertEquals("1234 Box Rd", updatedContact.getAddress());
    }

    
    
    
    // Test to check updating a non-existent contact
    @Test
    public void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("0123456789", "Ema", "Baboid", "9092922299", "1234 Box Rd");
        });
    }
}