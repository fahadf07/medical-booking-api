package com.medical.bookingapi.controller;

import com.medical.bookingapi.model.Appointment;
import com.medical.bookingapi.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring Boot this class handles HTTP REST requests
@RequestMapping("/api/appointments") // Base URL endpoint for all booking actions
public class AppointmentController {

    private final BookingService bookingService;

    // Spring Boot automatically injects our service layer here via constructor injection
    public AppointmentController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Endpoint: POST http://localhost:8080/api/appointments
     * Creates and confirms a new medical appointment.
     */
    @PostMapping
    public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = bookingService.createAppointment(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    /**
     * Endpoint: GET http://localhost:8080/api/appointments
     * Fetches all registered appointments in the system.
     */
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> list = bookingService.getAllAppointments();
        return ResponseEntity.ok(list);
    }

    /**
     * Endpoint: GET http://localhost:8080/api/appointments/{id}
     * Fetches a single specific appointment details by its UUID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable String id) {
        Appointment appointment = bookingService.getAppointmentById(id);
        if (appointment == null) {
            return ResponseEntity.notFound().build(); // Standard HTTP 404 Response
        }
        return ResponseEntity.ok(appointment);
    }
}
