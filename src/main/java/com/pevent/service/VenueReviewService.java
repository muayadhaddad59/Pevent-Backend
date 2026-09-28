package com.pevent.service;

import com.pevent.dto.CreateVenueReviewRequest;
import com.pevent.entity.Venue;
import com.pevent.entity.VenueReview;
import com.pevent.repository.VenueRepository;
import com.pevent.repository.VenueReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueReviewService {
    private final VenueReviewRepository venueReviewRepository;
    private final VenueRepository venueRepository;

    public VenueReviewService(VenueReviewRepository venueReviewRepository, VenueRepository venueRepository) {
        this.venueReviewRepository = venueReviewRepository;
        this.venueRepository = venueRepository;
    }

    public List<VenueReview> findAll() {
        return venueReviewRepository.findAll();
    }

    public VenueReview findById(Long id) {
        return venueReviewRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Venue review not found: " + id));
    }

    public VenueReview save(CreateVenueReviewRequest request) {
        Venue tempVenue = venueRepository.findById(request.venueId())
                .orElseThrow(()-> new RuntimeException("Venue not found: " + request.venueId()));

        VenueReview venueReview = new VenueReview(
                request.comment(),
                request.rating()
        );

        venueReview.setVenue(tempVenue);

        return venueReviewRepository.save(venueReview);
    }

    public void deleteById(Long id){
        venueReviewRepository.deleteById(id);
    }
}
