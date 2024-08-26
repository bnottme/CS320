package contactservice;

public class Contact {
    // Private fields to store contact details
    private String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    
    
    // Constructor to initialize the contact object with validation
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
    	
        // Validate contact ID
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        
        // Validate first name
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        
        // Validate last name
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        
        // Validate phone number
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        
        

        // Assign values to the fields
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    
    
    

    // Method to access contact info
    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    
    
    
    // Method for first name with validation
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    // Method for last name with validation
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    // Method for phone number with validation
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    // Method for address with validation
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}