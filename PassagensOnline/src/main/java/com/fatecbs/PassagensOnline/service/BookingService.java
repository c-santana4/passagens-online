package com.fatecbs.PassagensOnline.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fatecbs.PassagensOnline.model.Booking;

@Service
public class BookingService {
	private static List<Booking> bookings = new ArrayList<>();
	
	private void test() {
		Booking booking1 = new Booking("Santos", "Sao Paulo", BigDecimal.ONE, 
				LocalDate.now(), LocalTime.now(), 
				LocalDate.now().plusDays(1), LocalTime.now().plusHours(3));
		
		booking1.setName("Carlos Santana");
		booking1.setEmail("carlos@teste.com");
		
		bookings.add(booking1);
	}
	
	public BookingService() {
		test();
	}
	
	public void create(Booking booking) {
		booking.setId(booking.generateId());
		bookings.add(booking);
	}
	
	public Booking find(Booking booking){
		return bookings
				.stream()
				.filter(b -> b.equals(booking))
				.findFirst().get();
	}
	
	public Booking find(Long id) {
		Booking booking = bookings.stream().filter(b -> b.getId() == id).findFirst().get();
		
		if (booking == null) return new Booking(id);

		return booking;
	}
	
	public List<Booking> findAll() {
		return bookings;
	}
	
	public Boolean update(Booking booking) {
		Booking _booking = this.find(booking);
		if (_booking != null) {
			
			return true;
		}
		return false;
	}
	
	public Boolean delete(Long id) {
		Booking _conta = this.find(id);
		if (_conta != null) {
			bookings.remove(_conta);
			return true;
		}
		return false;
	}
}
