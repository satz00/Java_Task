package com.task.PatientAppointmentBookingSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name is required")
    @Column(nullable = false)
    private String patientName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Medical history is required")
    @Column(nullable = false)
    private String medicalHistory;

    public Long getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getEmail() {
        return email;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
