package com.medical.bookingapi.model;

import java.time.LocalDateTime;

public class Appointment {
    private String id;
    private String patientName;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String status; // e.g., "CONFIRMED", "PENDING"

    // Full Constructor
    public Appointment(String id, String patientName, String doctorName, LocalDateTime appointmentTime, String status) {
        this.id = id;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(LocalDateTime appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
