package com.pevent.service;

import com.pevent.dto.CreateWeddingRequest;
import com.pevent.entity.Venue;
import com.pevent.entity.Wedding;
import com.pevent.repository.VenueRepository;
import com.pevent.repository.WeddingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingService {
    private final WeddingRepository weddingRepository;
    private final VenueRepository venueRepository;

    public WeddingService(
            WeddingRepository weddingRepository,
            VenueRepository venueRepository
    ) {
        this.weddingRepository = weddingRepository;
        this.venueRepository = venueRepository;
    }
    public List<Wedding> findAll() {
        return weddingRepository.findAll();
    }

    public Wedding findById(Long id){
        return weddingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wedding not found: " + id));
    }

    public Wedding save(CreateWeddingRequest request) {

        Venue venue = venueRepository.findById(request.venueId())
                .orElseThrow(() ->
                        new RuntimeException("Venue not found: " + request.venueId())
                );

        Wedding wedding = new Wedding(
                request.title(),
                request.weddingDate(),
                request.guestCount(),
                request.budget()
        );

        wedding.setVenue(venue);

        return weddingRepository.save(wedding);
    }

    public void deleteById(Long id) {
        weddingRepository.deleteById(id);
    }
}
