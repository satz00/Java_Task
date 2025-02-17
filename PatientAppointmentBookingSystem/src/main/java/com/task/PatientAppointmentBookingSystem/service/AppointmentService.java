package com.task.PatientAppointmentBookingSystem.service;

import com.task.PatientAppointmentBookingSystem.entity.Appointment;
import com.task.PatientAppointmentBookingSystem.entity.Doctor;
import com.task.PatientAppointmentBookingSystem.entity.Patient;
import com.task.PatientAppointmentBookingSystem.repo.AppointmentRepo;
import com.task.PatientAppointmentBookingSystem.repo.DoctorRepo;
import com.task.PatientAppointmentBookingSystem.repo.PatientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private DoctorRepo doctorRepo;

    public void bookAppointment(Patient patient, Long doctorId) {
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not Found"));
        patientRepo.save(patient);
        Appointment appointment = new Appointment(doctor, patient ,LocalDateTime.now());
        appointmentRepo.save(appointment);
    }
}
