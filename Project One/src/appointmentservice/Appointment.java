package appointmentservice;

import java.util.Date;

public class Appointment {
    // This is the unique ID for the appointment
    private final String appointmentId;
    // This is the date of the appointment
    private Date appointmentDate;
    // This is the description of the appointment
    private String description;

    // Constructor to create a new appointment
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        // Check if the ID is valid (not null and not too long)
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        // Check if the date is valid (not null and not in the past)
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        // Check if the description is valid (not null and not too long)
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }

        // Set the appointment fields
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Get the appointment ID
    public String getAppointmentId() {
        return appointmentId;
    }

    // Get the appointment date
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    // Set a new appointment date
    public void setAppointmentDate(Date appointmentDate) {
        // Check if the new date is valid
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    // Get the appointment description
    public String getDescription() {
        return description;
    }

    // Set a new description
    public void setDescription(String description) {
        // Check if the new description is valid
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }
}
