package com.task.PatientAppointmentBookingSystem.repo;

import com.task.PatientAppointmentBookingSystem.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
