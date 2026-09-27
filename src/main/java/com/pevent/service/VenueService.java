package com.pevent.service;

import com.pevent.entity.Venue;
import com.pevent.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private final VenueRepository venueRepository;

    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> findAll() {
        return venueRepository.findAll();
    }

    public Venue findById(Long id) {
        return venueRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Venue not found: " + id));
    }

    public Venue update(Long id, Venue venue) {
        Venue existingVenue = findById(id);

        existingVenue.setName(venue.getName());
        existingVenue.setAddress(venue.getAddress());
        existingVenue.setCapacity(venue.getCapacity());
        existingVenue.setCity(venue.getCity());
        existingVenue.setPrice(venue.getPrice());

        return venueRepository.save(existingVenue);
    }

    public List<Venue> findByCity(String city){
        return venueRepository.findByCity(city);
    }

    public Venue save(Venue venue){
        return venueRepository.save(venue);
    }

    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }
}
