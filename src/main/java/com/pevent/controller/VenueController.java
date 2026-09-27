package com.pevent.controller;

import com.pevent.entity.Venue;
import com.pevent.service.VenueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping
    public List<Venue> getAll() {
        return venueService.findAll();
    }

    @GetMapping("/{id}")
    public Venue getById(@PathVariable Long id){
        return venueService.findById(id);
    }

    @PostMapping
    public Venue save(@RequestBody Venue venue){
        return venueService.save(venue);
    }

    @PutMapping("/{id}")
    public Venue update(@PathVariable Long id, @RequestBody Venue venue) {
        return venueService.update(id, venue);
    }

    @GetMapping("/city/{city}")
    public List<Venue> getByCity(@PathVariable String city) {
        return venueService.findByCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        venueService.deleteById(id);
    }
}
