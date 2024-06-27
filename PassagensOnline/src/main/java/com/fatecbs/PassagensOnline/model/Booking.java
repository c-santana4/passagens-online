package com.fatecbs.PassagensOnline.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fatecbs.PassagensOnline.dto.DurationDto;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_booking")
public class Booking {
	private static Long nextId = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(name = "nm_user", nullable = false)
	private String Name;

	@Column(name = "nm_email", nullable = false)
	private String email;

	@Column(name = "nm_source", nullable = false)
	private String source;

	@Column(name = "nm_destination", nullable = false)
	private String destination;

	@Column(name = "vl_amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "dt_departure", nullable = false)
	private LocalDate departureDate;
	@Column(name = "hr_departure", nullable = false)
	private LocalTime departureTime;

	@Column(name = "dt_arrival", nullable = false)
	private LocalDate arrivalDate;
	@Column(name = "hr_arrival", nullable = false)
	private LocalTime arrivalTime;

	@Column(name = "ds_duration", nullable = false)
	private Duration duration;

	public Booking() {}
	
	public Booking(String source, String destination, BigDecimal amount,
			LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, long duration) {
		super();
		this.Id = generateId();
		this.source = source;
		this.destination = destination;
		this.amount = amount;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.duration = new DurationDto(duration).getDuration();
	}
	
	public Booking(Long id) {}
	
	public Long generateId() {
		return nextId++;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = new DurationDto(duration).getDuration();
	}
	public void setDuration(Duration duration) {
		this.duration = duration;
	}
}
