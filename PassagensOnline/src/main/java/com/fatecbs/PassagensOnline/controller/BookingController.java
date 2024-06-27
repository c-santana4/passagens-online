package com.fatecbs.PassagensOnline.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fatecbs.PassagensOnline.model.Booking;
import com.fatecbs.PassagensOnline.service.BookingService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@PostMapping
	@ApiResponses(value = {
		@ApiResponse(responseCode = "201",
			description = "Passagem criada com sucesso"),
		@ApiResponse(responseCode = "400",
			description = "Requisição inválida"),
		@ApiResponse(responseCode = "422",
			description = "Erro de validação dos dados"),
		@ApiResponse(responseCode = "500",
			description = "Erro interno"),
	})  
	public ResponseEntity<Booking> post(@RequestBody Booking booking){
		service.create(booking);
		
		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(booking.getId())
						.toUri();
		
		return ResponseEntity.created(location).body(booking);
	}

	@GetMapping
	@ApiResponses(value = {
   	    @ApiResponse(responseCode = "200",
   	        description = "Retorna a lista de passagens"),
   	    @ApiResponse(responseCode = "404",
   	        description = "Nenhuma passagem encontrada"),
   	    @ApiResponse(responseCode = "500",
   	        description = "Erro interno"),
   	})  
	public ResponseEntity<List<Booking>> getAllBooking() {
		List<Booking> bookings = service.findAll();
		
		if (bookings != null) {
			return ResponseEntity.ok(bookings);
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/{id}")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Retorna a passagenm com o id informado"),
		@ApiResponse(responseCode = "404",
   	        description = "Pasagem não encontrada"),
		@ApiResponse(responseCode = "500",
			description = "Erro interno"),
	})
	public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
		Booking booking = service.findById(id);
		
		if (booking != null) {
			return ResponseEntity.ok(booking);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value = "/{id}")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Atualiza a passagenm com o id informado"),
		@ApiResponse(responseCode = "400",
			description = "Requisição inválida"),
		@ApiResponse(responseCode = "404",
   	        description = "Passagem não encontrada"),
		@ApiResponse(responseCode = "422",
			description = "Erro de validação dos dados"),
		@ApiResponse(responseCode = "500",
			description = "Erro interno"),
	})
	public ResponseEntity<Booking> put(@RequestBody Booking booking, @RequestParam("id") Long id){
		if(booking.getId() != id)
		{
			return ResponseEntity.badRequest().build();
		}
		if (service.update(id, booking)) {
			return ResponseEntity.ok(booking);
		}

		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200",
			description = "Passagem excluída"),
		@ApiResponse(responseCode = "404",
   	        description = "Nenhuma passagem encontrada"),
		@ApiResponse(responseCode = "500",
			description = "Erro interno"),
	})
	public ResponseEntity<Booking> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}


}
