package com.pevent.entity;

import com.pevent.repository.VenueRepository;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venues")
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private Integer capacity;

    @Column(nullable = false)
    private String city;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @OneToMany(mappedBy = "venue")
    private List<VenueReview> venueReviews = new ArrayList<>();

    public Venue() {}

    public Venue(String name, String address, Integer capacity, String city, BigDecimal price) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.city = city;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<VenueReview> getVenueReviews() {
        return venueReviews;
    }

    public void setVenueReviews(List<VenueReview> venueReviews) {
        this.venueReviews = venueReviews;
    }

    public void addVenueReview(VenueReview venueReview) {
        venueReviews.add(venueReview);
        venueReview.setVenue(this);
    }
}
