package com.task.PatientAppointmentBookingSystem.controller;

import com.task.PatientAppointmentBookingSystem.entity.Medication;
import com.task.PatientAppointmentBookingSystem.entity.Patient;
import com.task.PatientAppointmentBookingSystem.repo.PatientRepo;
import com.task.PatientAppointmentBookingSystem.service.MedicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Medications", description = "API for managing patient medications")
@Controller
@RequestMapping("/medications")
public class MedicationController {
    @Autowired
    private MedicationService medicationService;

    @Autowired
    private PatientRepo patientRepository;

    @Operation(summary = "View all medications for a patient", description = "Fetches all medications prescribed to a specific patient by patient ID.")
    @GetMapping("/{patientId}")
    public String viewMedications(@PathVariable Long patientId, Model model) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        List<Medication> medications = medicationService.getMedicationsByPatient(patient);
        model.addAttribute("medications", medications);
        model.addAttribute("patient", patient);
        return "medication_list";
    }

    @Operation(summary = "Show add medication form", description = "Displays a form to add a new medication for a specific patient.")
    @GetMapping("/add/{patientId}")
    public String addMedicationForm(@PathVariable Long patientId, Model model) {
        model.addAttribute("medication", new Medication());
        model.addAttribute("patientId", patientId);
        return "medication_form";
    }

    @Operation(summary = "Save a medication", description = "Saves a new medication for a given patient.")
    @PostMapping("/save/{patientId}")
    public String saveMedication(@PathVariable Long patientId, @ModelAttribute Medication medication) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new RuntimeException("Patient not found"));
        medication.setPatient(patient);
        medicationService.saveMedication(medication);
        return "redirect:/medications/" + patientId;
    }

    @Operation(summary = "Delete a medication", description = "Deletes a medication by its ID for a given patient.")
    @GetMapping("/delete/{id}/{patientId}")
    public String deleteMedication(@PathVariable Long id, @PathVariable Long patientId) {
        medicationService.deleteMedication(id);
        return "redirect:/medications/" + patientId;
    }
}
