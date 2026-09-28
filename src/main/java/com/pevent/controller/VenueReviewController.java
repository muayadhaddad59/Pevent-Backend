package com.pevent.controller;

import com.pevent.dto.CreateVenueReviewRequest;
import com.pevent.entity.VenueReview;
import com.pevent.service.VenueReviewService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue-reviews")
public class VenueReviewController {
    private final VenueReviewService venueReviewService;

    public VenueReviewController(VenueReviewService venueReviewService) {
        this.venueReviewService = venueReviewService;
    }

    @GetMapping
    public List<VenueReview> findAll() {
        return venueReviewService.findAll();
    }


    @GetMapping("/{id}")
    public VenueReview findById(@PathVariable Long id) {
        return venueReviewService.findById(id);
    }

    @PostMapping
    public VenueReview save(@Valid @RequestBody CreateVenueReviewRequest request) {
        return venueReviewService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        venueReviewService.deleteById(id);
    }
}
