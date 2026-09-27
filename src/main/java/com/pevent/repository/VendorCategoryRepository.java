package com.pevent.repository;

import com.pevent.entity.VendorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorCategoryRepository extends JpaRepository<VendorCategory, Long> {
}
