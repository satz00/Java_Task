package com.task.PatientAppointmentBookingSystem.repo;

import com.task.PatientAppointmentBookingSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByPatientName(String patientName);
}
