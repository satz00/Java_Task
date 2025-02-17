package com.task.PatientAppointmentBookingSystem.repo;

import com.task.PatientAppointmentBookingSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {
}
