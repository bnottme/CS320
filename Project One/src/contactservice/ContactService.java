package contactservice;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
    // A map to store contacts using contact ID as the key
    private Map<String, Contact> contacts;

    // Constructor to initialize the contact map
    public ContactService() {
        contacts = new HashMap<>();
    }

    
    
    // Method to add a new contact
    public void addContact(Contact contact) {
        // Check if contact ID already exists
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        // Add contact to the map
        contacts.put(contact.getContactID(), contact);
    }

    
    
    // Method to delete a contact by ID
    public void deleteContact(String contactID) {
        // Check if contact ID exists
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        // Remove contact from the map
        contacts.remove(contactID);
    }

    
    
    // Method to update contact details
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        // Check if contact ID exists
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        
        
        
        // Get the contact and update details
        Contact contact = contacts.get(contactID);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    
    
    // Method to get a contact by ID
    public Contact getContact(String contactID) {
        // Check if contact ID exists
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        // Return the contact
        return contacts.get(contactID);
    }
}