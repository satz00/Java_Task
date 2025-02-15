package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.Bus;
import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.UserRepository;
import com.project.bus_ticket_booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService service;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/search")
    public String searchBuses(@RequestParam String from,
                              @RequestParam String to,
                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date,
                              @AuthenticationPrincipal org.springframework.security.core.userdetails.UserDetails userDetails,
                              Model model) {
        List<Bus> buses = service.searchBuses(from, to, date);
        User user = userRepo.findByUsername(userDetails.getUsername());

        model.addAttribute("buses", buses);
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("userId", user.getId());

        return "dashboard";
    }

    @PostMapping("/add")
    @ResponseBody
    public Bus addBus(@RequestBody Bus bus) {
        return service.addBus(bus);
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Bus> getAllBuses() {
        return service.getAllBuses();
    }
}
