package com.task.PatientAppointmentBookingSystem.controller;

import com.task.PatientAppointmentBookingSystem.entity.Doctor;
import com.task.PatientAppointmentBookingSystem.entity.DoctorTimeSlot;
import com.task.PatientAppointmentBookingSystem.repo.DoctorRepo;
import com.task.PatientAppointmentBookingSystem.repo.DoctorTimeSlotRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name = "Doctors", description = "API for managing doctors and their available slots")
@Controller
@RequiredArgsConstructor
public class DoctorController {

    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private DoctorTimeSlotRepository timeSlotRepo;

    @Operation(summary = "Get all doctors with their available slots")
    @GetMapping("/")
    public String showDashboard(Model model) {
        List<Doctor> doctors = doctorRepo.findAll();
        for (Doctor doctor : doctors) {
            List<DoctorTimeSlot> slots = timeSlotRepo.findByDoctorId(doctor.getId());
            doctor.setTimeSlots(slots);
        }
        model.addAttribute("doctors", doctors);
        return "dashboard";
    }
}
