package com.pevent.service;

import com.pevent.dto.CreateVendorReviewRequest;
import com.pevent.entity.Vendor;
import com.pevent.entity.VendorReview;
import com.pevent.repository.VendorRepository;
import com.pevent.repository.VendorReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorReviewService {

    private final VendorReviewRepository vendorReviewRepository;
    private final VendorRepository vendorRepository;

    public VendorReviewService(
            VendorReviewRepository vendorReviewRepository,
            VendorRepository vendorRepository
    ) {
        this.vendorReviewRepository = vendorReviewRepository;
        this.vendorRepository = vendorRepository;
    }

    public List<VendorReview> findAll() {
        return vendorReviewRepository.findAll();
    }

    public VendorReview findById(Long id) {
        return vendorReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found: " + id));
    }

    public VendorReview save(CreateVendorReviewRequest reviewRequest) {
        Vendor vendor = vendorRepository.findById(reviewRequest.vendorId())
                .orElseThrow(() ->
                        new RuntimeException("Vendor not found: " + reviewRequest.vendorId())
                );

        VendorReview review = new VendorReview(
                reviewRequest.rating(),
                reviewRequest.comment()
        );

        review.setVendor(vendor);

        return vendorReviewRepository.save(review);
    }

    public void deleteById(Long id) {
        vendorReviewRepository.deleteById(id);
    }
}