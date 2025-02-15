package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.Bus;
import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.BusRepository;
import com.project.bus_ticket_booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TicketViewController {

    @Autowired
    private BusRepository busRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/book")
    public String showBookingPage(@RequestParam Long busId,  Model model) {
        Optional<Bus> bus = busRepo.findById(busId);
        if (bus.isPresent()) {
            model.addAttribute("bus", bus.get());
        } else {
            return "redirect:/dashboard";
        }
        return "book_ticket";
    }
}
