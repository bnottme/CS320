package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import contactservice.Contact;

public class ContactTest {

    // Method to provide test contact information
    private Contact getTestContact() {
        return new Contact("0123456789", "Brett", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
    }
    
    

    // Test to check if contact creation works
    @Test
    public void testContactCreation() {
        Contact contact = getTestContact();
        assertEquals("0123456789", contact.getContactID());
        assertEquals("Brett", contact.getFirstName());
        assertEquals("Nottmeier", contact.getLastName());
        assertEquals("9512554685", contact.getPhone());
        assertEquals("1018 fox ridge, Eastvale, CA", contact.getAddress());
    }

    
    
    // Test to check invalid contact ID
    @Test
    public void testInvalidContactID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Brett", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Brett", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
        });
    }

    
    
    // Test to check invalid first name
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", null, "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "BrettNottmeier", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
        });
    }

    
    
    // Test to check invalid last name
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", null, "9512554685", "1018 fox ridge, Eastvale, CA");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", "NottmeierNottmeier", "9512554685", "1018 fox ridge, Eastvale, CA");
        });
    }

    
    
    // Test to check invalid phone number
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", "Nottmeier", null, "1018 fox ridge, Eastvale, CA");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", "Nottmeier", "951", "1018 fox ridge, Eastvale, CA");
        });
    }

    
    
    // Test to check invalid address
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", "Nottmeier", "9512554685", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0123456789", "Brett", "Nottmeier", "9512554685", "1018 fox ridge, Eastvale, CA, Anytown, USA, 1234567890123456789012345678901");
        });
    }
}