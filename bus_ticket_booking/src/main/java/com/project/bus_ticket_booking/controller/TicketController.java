package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.Ticket;
import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.BusRepository;
import com.project.bus_ticket_booking.repo.TicketRepository;
import com.project.bus_ticket_booking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(
            @RequestParam Long userId,
            @RequestParam Long busId,
            @RequestParam int seatCount) {
        try {
            Ticket ticket = ticketService.bookTicket(userId, busId, seatCount);
            return ResponseEntity.ok(ticket.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/ticket/{ticketId}")
    public String showTicket(@PathVariable Long ticketId, Model model) {
        Optional<Ticket> ticketOpt = ticketService.getTicketById(ticketId);
        if (ticketOpt.isEmpty()) {
            throw new RuntimeException("Ticket is not found for Id: " + ticketId);
        }
        Ticket ticket = ticketOpt.get();
        model.addAttribute("ticket", ticket);
        return "ticket";
    }

    @GetMapping("/user/{userId}")
    public String getUserTicket(@PathVariable Long userId, Model model) {
        List<Ticket> tickets = ticketService.getUserTicket(userId);
        for (Ticket ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getId() + " | Date: " + ticket.getBus().getDate());
        }
        model.addAttribute("tickets", tickets);
        return "user-tickets";
    }

    @PostMapping("/cancel/{ticketId}")
    public String cancelTicket(@PathVariable Long ticketId) {
        Optional<Ticket> ticketOpt = ticketService.getTicketById(ticketId);
        if (ticketOpt.isPresent()) {
            Ticket ticket = ticketOpt.get();
            User user = ticket.getUser();
            System.out.println("Ticket Cancel");
            ticketService.cancelTicket(ticketId);
            return "redirect:/user/" + user.getId();
        }
        return "redirect:/error";
    }


}
