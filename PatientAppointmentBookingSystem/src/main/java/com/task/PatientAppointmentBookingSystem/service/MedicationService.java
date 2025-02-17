package com.task.PatientAppointmentBookingSystem.service;

import com.task.PatientAppointmentBookingSystem.entity.Medication;
import com.task.PatientAppointmentBookingSystem.entity.Patient;
import com.task.PatientAppointmentBookingSystem.repo.MedicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepo medicationRepo;

    public List<Medication> getMedicationsByPatient(Patient patient) {
        return medicationRepo.findByPatient(patient);
    }

    public void saveMedication(Medication medication) {
        medicationRepo.save(medication);
    }

    public void deleteMedication(Long id) {
        medicationRepo.deleteById(id);
    }

    public Medication getMedicationById(Long id) {
        return medicationRepo.findById(id).orElse(null);
    }
}
