package com.medical.bookingapi.service;

import com.medical.bookingapi.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service // Tells Spring Boot that this class handles business logic and can be injected
public class BookingService {

    // Thread-safe in-memory storage simulating a database table
    private final Map<String, Appointment> appointmentDatabase = new ConcurrentHashMap<>();

    /**
     * Registers a new appointment in the system and automatically generates a secure ID.
     */
    public Appointment createAppointment(Appointment appointment) {
        // Generate a cryptographically secure random unique ID for the appointment
        String uniqueId = UUID.randomUUID().toString();
        appointment.setId(uniqueId);

        // Default new bookings to CONFIRMED status
        if (appointment.getStatus() == null || appointment.getStatus().isEmpty()) {
            appointment.setStatus("CONFIRMED");
        }

        appointmentDatabase.put(uniqueId, appointment);
        return appointment;
    }

    /**
     * Retrieves all recorded medical appointments in the system.
     */
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointmentDatabase.values());
    }

    /**
     * Searches for a specific appointment by its unique identifier.
     */
    public Appointment getAppointmentById(String id) {
        return appointmentDatabase.get(id);
    }
}
