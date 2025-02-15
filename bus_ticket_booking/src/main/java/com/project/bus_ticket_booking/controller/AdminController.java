package com.project.bus_ticket_booking.controller;

import com.project.bus_ticket_booking.entity.Bus;
import com.project.bus_ticket_booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/buses")
public class AdminController {

    @Autowired
    private BusService service;

    @PutMapping("/update/{id}")
    public Bus updateBus(@PathVariable Long id, @RequestBody Bus updateBus) {
        Bus bus = service.getBusById(id);
        if (bus != null) {
            bus.setBusName(updateBus.getBusName());
            bus.setFromLocation(updateBus.getFromLocation());
            bus.setToLocation(updateBus.getToLocation());
            bus.setDate(updateBus.getDate());
            bus.setBusType(updateBus.getBusType());
            bus.setAvailableSeats(updateBus.getAvailableSeats());
            return service.addBus(updateBus);
        }
        return null;
    }

    @PostMapping("/add")
    public Bus addBus(@RequestParam Bus bus) {
        return  service.addBus(bus);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBus(@PathVariable Long id) {
        service.deleteBus(id);
        return "Bus deleted successfully!";
    }

    @GetMapping("/all")
    public List<Bus> getAllBuses() {
        return service.getAllBuses();
    }


}
