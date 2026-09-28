package com.pevent.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateWeddingRequest(
        @NotBlank
        String title,

        @NotNull
        LocalDate weddingDate,

        @NotNull
        Integer guestCount,

        @NotNull
        BigDecimal budget,

        @NotNull
        Long venueId
) {
}
