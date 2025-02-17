package com.task.PatientAppointmentBookingSystem.controller;

import com.task.PatientAppointmentBookingSystem.entity.Appointment;
import com.task.PatientAppointmentBookingSystem.entity.Doctor;
import com.task.PatientAppointmentBookingSystem.entity.Patient;
import com.task.PatientAppointmentBookingSystem.repo.AppointmentRepo;
import com.task.PatientAppointmentBookingSystem.repo.DoctorRepo;
import com.task.PatientAppointmentBookingSystem.repo.PatientRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Tag(name = "Appointments", description = "API for booking and managing appointments")
@Controller
@RequiredArgsConstructor
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientRepo patientRepo;

    @Operation(summary = "Show the appointment booking form")
    @GetMapping("/book/{doctorId}")
    public String showBookingForm(@PathVariable Long doctorId,
                                  @RequestParam("timeSlot") String timeSlot,
                                  Model model) {

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = new Patient();

        model.addAttribute("doctor", doctor);
        model.addAttribute("timeSlot", timeSlot);
        model.addAttribute("patient", patient);

        return "patient_form";
    }

    @Operation(summary = "Confirm and save an appointment")
    @PostMapping("/confirm/{doctorId}")
    public String confirmAppointment(@PathVariable Long doctorId,
                                     @RequestParam("timeSlot") String timeSlot,
                                     @Valid @ModelAttribute Patient patient,
                                     BindingResult result) {
        if (result.hasErrors()) {
            return "patient_form";
        }
        Doctor doctor = doctorRepo.findById(doctorId).orElseThrow(() -> new RuntimeException("Doctor not found"));
        patientRepo.save(patient);

        String starTime = timeSlot.split("-")[0].trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);
        LocalTime localTime = LocalTime.parse(starTime, formatter);
        LocalDateTime appointmentTime = LocalDate.now().atTime(localTime);
        appointmentRepo.save(new Appointment(doctor, patient, appointmentTime));
        return "redirect:/";
    }

    @Operation(summary = "Showing all appointment")
    @GetMapping("/appointments")
    public String showAppointments(Model model) {
        List<Appointment> appointments = appointmentRepo.findAll();
        model.addAttribute("appointments", appointments);
        return "appointment";
    }

}
