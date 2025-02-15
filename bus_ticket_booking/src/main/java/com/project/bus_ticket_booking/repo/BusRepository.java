package com.project.bus_ticket_booking.repo;

import com.project.bus_ticket_booking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByFromLocationAndToLocationAndDate(String fromLocation, String toLocation, LocalDate date);
}
