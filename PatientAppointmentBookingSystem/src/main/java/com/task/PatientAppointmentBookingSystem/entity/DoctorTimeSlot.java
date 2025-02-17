package com.task.PatientAppointmentBookingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DoctorTimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timeSlot;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Long getId() {
        return id;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorTimeSlot{id=" + id + ", timeSlot='" + timeSlot + "'}";
    }
}
