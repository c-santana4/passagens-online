package com.fatecbs.PassagensOnline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fatecbs.PassagensOnline.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}