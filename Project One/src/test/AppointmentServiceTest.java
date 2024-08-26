package test;

import appointmentservice.AppointmentService;
import appointmentservice.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService appointmentService;
    private Appointment validAppointment;

    // This method runs before each test
    @BeforeEach
    public void setUp() {
        appointmentService = new AppointmentService();
        // Create a date 10 seconds in the future
        Date futureDate = new Date(System.currentTimeMillis() + 10000);
        // Create a new appointment with valid details
        validAppointment = new Appointment("12345", futureDate, "Valid description");
    }

    // Test adding a valid appointment
    @Test
    public void testAddAppointment() {
        // Add the appointment to the service
        appointmentService.addAppointment(validAppointment);
        // Check if the appointment was added correctly
        assertEquals(validAppointment, appointmentService.getAppointment("12345"));
    }

    // Test adding a duplicate appointment
    @Test
    public void testAddDuplicateAppointment() {
        // Add the appointment to the service
        appointmentService.addAppointment(validAppointment);
        // Try to add the same appointment again and expect an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(validAppointment);
        });
    }

    // Test deleting an appointment
    @Test
    public void testDeleteAppointment() {
        // Add the appointment to the service
        appointmentService.addAppointment(validAppointment);
        // Delete the appointment
        appointmentService.deleteAppointment("12345");
        // Check if the appointment was deleted correctly
        assertNull(appointmentService.getAppointment("12345"));
    }

    // Test deleting an appointment that does not exist
    @Test
    public void testDeleteNonExistentAppointment() {
        // Try to delete an appointment that was never added and expect an exception
        assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.deleteAppointment("67890");
        });
    }
}