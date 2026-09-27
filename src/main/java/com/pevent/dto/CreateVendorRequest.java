package com.pevent.dto;

import java.math.BigDecimal;

public record CreateVendorRequest(
        String name,
        String description,
        String city,
        String address,
        BigDecimal startingPrice,
        String phone,
        String website,
        Long categoryId
) { }
