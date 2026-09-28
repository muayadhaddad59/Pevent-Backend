package com.pevent.dto;

public record CreateVendorReviewRequest(Integer rating, String comment, Long vendorId) {
}
