package com.fatecbs.PassagensOnline.dto;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;

public class BookingUpdateDto {
    private String name;
	private String email;
	private String source;
	private String destination;
	private BigDecimal amount;
	private LocalDate departureDate;
	private LocalTime departureTime;
	private LocalDate arrivalDate;
	private LocalTime arrivalTime;
	private Duration duration;

    public BookingUpdateDto(String name, String email, String source, String destination, BigDecimal amount, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, Duration duration) {
        this.name = name;
        this.email = email;
        this.source = source;
        this.destination = destination;
        this.amount = amount;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.duration = duration;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public Duration getDuration() {
        return duration;
    }
    
}
