package appointmentservice;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    // This is where we store all the appointments
    private final Map<String, Appointment> appointments = new HashMap<>();

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        // Check if the appointment ID already exists
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        // Add the appointment to the list
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    // Method to delete an appointment by its ID
    public void deleteAppointment(String appointmentId) {
        // Check if the appointment ID does not exist
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        // Remove the appointment from the list
        appointments.remove(appointmentId);
    }

    // Method to get an appointment by its ID
    public Appointment getAppointment(String appointmentId) {
        // Return the appointment with the given ID
        return appointments.get(appointmentId);
    }
}