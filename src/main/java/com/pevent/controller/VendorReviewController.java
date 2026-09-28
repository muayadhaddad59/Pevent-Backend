package com.pevent.controller;

import com.pevent.dto.CreateVendorReviewRequest;
import com.pevent.entity.VendorReview;
import com.pevent.service.VendorReviewService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vendor-reviews")
public class VendorReviewController {
    private final VendorReviewService vendorReviewService;

    public VendorReviewController(VendorReviewService vendorReviewService) {
        this.vendorReviewService = vendorReviewService;
    }

    @GetMapping
    public List<VendorReview> findAll() {
        return vendorReviewService.findAll();
    }

    @GetMapping("/{id}")
    public VendorReview findById(@PathVariable Long id) {
        return vendorReviewService.findById(id);
    }

    @PostMapping
    public VendorReview save(@Valid @RequestBody CreateVendorReviewRequest request) {
        return vendorReviewService.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        vendorReviewService.deleteById(id);
    }
}
