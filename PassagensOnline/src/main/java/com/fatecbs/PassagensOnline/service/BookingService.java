package com.fatecbs.PassagensOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.fatecbs.PassagensOnline.model.Booking;
import com.fatecbs.PassagensOnline.repository.BookingRepository;

@Service
public class BookingService implements IService<Booking> {
	@Autowired
    private BookingRepository repository;

	// private static List<Booking> bookings = new ArrayList<>();

	@Override
	public Booking create(Booking booking) {
		if (booking.getArrivalDate().isBefore(booking.getDepartureDate())){
			throw new IllegalArgumentException("Data de chegada não pode ser antes da data de partida");
		}

        return repository.save(booking);
    }

	@Override
	public Booking findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
	
	@Override
	public List<Booking> findAll() {
        return repository.findAll();
    }
	
	// @Override
	// public Page<Booking> findAll(Pageable pageable) {
	// 	return repository.findAll(pageable);
	// }
	
	public boolean update(Booking booking) {
        if (repository.existsById(booking.getId())) {
			repository.save(booking);
			return true;
		}
		return false;
	}
	
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
