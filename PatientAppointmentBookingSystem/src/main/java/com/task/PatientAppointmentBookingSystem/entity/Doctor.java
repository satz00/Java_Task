package com.task.PatientAppointmentBookingSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorName;

    private String specialization;
    private Boolean available;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DoctorTimeSlot> timeSlots;

    public Long getId() {
        return id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Boolean getAvailable() {
        return available;
    }

    public List<DoctorTimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setTimeSlots(List<DoctorTimeSlot> timeSlots) {
        this.timeSlots = timeSlots;
    }
}


