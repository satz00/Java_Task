package com.task.PatientAppointmentBookingSystem.repo;

import com.task.PatientAppointmentBookingSystem.entity.Medication;
import com.task.PatientAppointmentBookingSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepo extends JpaRepository<Medication, Long> {
    List<Medication> findByPatient(Patient patient);
}
