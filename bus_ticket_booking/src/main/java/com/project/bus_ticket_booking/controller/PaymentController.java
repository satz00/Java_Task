package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.Ticket;
import com.project.bus_ticket_booking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PaymentController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/payment")
    public String showPaymentPage(
            @RequestParam Long userId,
            @RequestParam Long busId,
            @RequestParam int seatCount,
            @RequestParam int price,
            Model model) {

        System.out.println("Enterd in the payment function ");
        System.out.println(userId + " " + busId + " " + seatCount + " " + price);
        model.addAttribute("userId", userId);
        model.addAttribute("busId", busId);
        model.addAttribute("seatCount", seatCount);
        model.addAttribute("price", price);

        return "payment";
    }

    @PostMapping("/payment/process")
    public ResponseEntity<?> processPayment(@RequestBody Map<String, Object> paymentData) {
        try {
            System.out.println("Payment process function");
            Long userId = Long.parseLong(paymentData.get("userId").toString());
            Long busId = Long.parseLong(paymentData.get("busId").toString());
            int seatCount = Integer.parseInt(paymentData.get("seatCount").toString());

            boolean paymentSuccess = true;

            if (paymentSuccess) {
                System.out.println("Entered in the if block");
                Ticket ticket = ticketService.bookTicket(userId, busId, seatCount);
                System.out.println("Ticket :"+ ticket);
                return ResponseEntity.ok(Map.of("success", true, "ticketId", ticket.getId()));
            } else {
                return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Payment Failed"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", e.getMessage()));
        }
    }
}
