package com.task.PatientAppointmentBookingSystem.repo;

import com.task.PatientAppointmentBookingSystem.entity.DoctorTimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorTimeSlotRepository extends JpaRepository<DoctorTimeSlot, Long> {
    List<DoctorTimeSlot> findByDoctorId(Long doctorId);
}
