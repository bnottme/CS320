package test;

import appointmentservice.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    // Test creating a valid appointment
    @Test
    public void testValidAppointment() {
        // Create a date 10 seconds in the future
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        // Create a new appointment with valid details
        Appointment appointment = new Appointment("12345", futureDate, "Valid description");
        // Check if the appointment is not null
        assertNotNull(appointment);
        // Check if the appointment ID is correct
        assertEquals("12345", appointment.getAppointmentId());
        // Check if the appointment date is correct
        assertEquals(futureDate, appointment.getAppointmentDate());
        // Check if the description is correct
        assertEquals("Valid description", appointment.getDescription());
    }

    // Test creating an appointment with an invalid ID
    @Test
    public void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        // Check if creating an appointment with a null ID throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Valid description");
        });
        // Check if creating an appointment with an ID that's too long throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Valid description");
        });
    }

    // Test creating an appointment with an invalid date
    @Test
    public void testInvalidAppointmentDate() {
        // Check if creating an appointment with a past date throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", new Date(System.currentTimeMillis() - 10000), "Valid description");
        });
        // Check if creating an appointment with a null date throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Valid description");
        });
    }

    // Test creating an appointment with an invalid description
    @Test
    public void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        // Check if creating an appointment with a null description throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, null);
        });
        // Check if creating an appointment with a description that's too long throws an exception
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", futureDate, "This description is way too long to be considered valid as it exceeds the fifty character limit");
        });
    }
}