package com.project.bus_ticket_booking.service;

import com.project.bus_ticket_booking.entity.Bus;
import com.project.bus_ticket_booking.entity.Ticket;
import com.project.bus_ticket_booking.entity.User;
import com.project.bus_ticket_booking.repo.BusRepository;
import com.project.bus_ticket_booking.repo.TicketRepository;
import com.project.bus_ticket_booking.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private BusRepository busRepo;
    @Autowired
    private UserRepository userRepository;

    public Ticket bookTicket(Long userId, Long busId, int seatCount) {
        System.out.println("Enterd in the bookTicket ");
        Optional<Bus> busOpt = busRepo.findById(busId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (busOpt.isEmpty()) {
            System.out.println("Bus is empty");
            throw new RuntimeException("Bus not found");
        }
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Bus bus = busOpt.get();
        User user = userOpt.get();
        System.out.println("bus : "+ busId+ "user : "+ user);
        if (bus.getAvailableSeats() < seatCount) {
            System.out.println("Not enough seats");
            throw new RuntimeException("Not enough seats available");
        }

        bus.setAvailableSeats(bus.getAvailableSeats() - seatCount);
        busRepo.save(bus);

        System.out.println("Bus is saved seats");
        Ticket ticket = new Ticket();
        ticket.setBus(bus);
        ticket.setUser(user);
        ticket.setSeatCount(seatCount);
        ticket.setPrice(seatCount * 1100);
        System.out.println("Ticket saved");
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getUserTicket(Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    public void cancelTicket(Long ticketId) {
        System.out.println("Ticket id: " + ticketId);
        Optional<Ticket> ticketOp = ticketRepository.findById(ticketId);
        if (ticketOp.isPresent()) {
            Ticket ticket = ticketOp.get();
            Bus bus = ticket.getBus();

            bus.setAvailableSeats(bus.getAvailableSeats() + ticket.getSeatCount());
            busRepo.save(bus);
            System.out.println("Seat counts is added to the bus");
            ticketRepository.deleteById(ticketId);
        }
    }
}
