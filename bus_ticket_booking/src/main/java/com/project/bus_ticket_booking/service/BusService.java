package com.project.bus_ticket_booking.service;

import com.project.bus_ticket_booking.entity.Bus;
import com.project.bus_ticket_booking.repo.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> searchBuses(String from, String to, LocalDate date) {
        return busRepository.findByFromLocationAndToLocationAndDate(from, to, date);
    }

    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus getBusById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    public void deleteBus(Long id) {
        busRepository.deleteById(id);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }
}
