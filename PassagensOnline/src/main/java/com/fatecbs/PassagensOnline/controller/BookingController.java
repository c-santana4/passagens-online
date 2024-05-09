package com.fatecbs.PassagensOnline.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecbs.PassagensOnline.bean.Booking;
import com.fatecbs.PassagensOnline.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping
	public ResponseEntity<Booking> post(@RequestBody Booking booking){
		service.create(booking);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(booking.getId())
						.toUri();
		
		return ResponseEntity.created(location).body(booking);
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
		
		Booking booking = service.find(id);
		
		if (booking != null) {
			return ResponseEntity.ok(booking);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping
	public ResponseEntity<Booking> put(@RequestBody Booking booking){
		if (service.update(booking)) {
			return ResponseEntity.ok(booking);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Booking> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}


}
