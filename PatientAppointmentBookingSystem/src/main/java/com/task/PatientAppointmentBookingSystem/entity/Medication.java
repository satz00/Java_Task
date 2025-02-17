package com.task.PatientAppointmentBookingSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dosage;
    private String instructions;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Medication() {}

    public Medication(String name, String dosage, String instructions, Patient patient) {
        this.name = name;
        this.dosage = dosage;
        this.instructions = instructions;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDosage() {
        return dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
