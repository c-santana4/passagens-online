package com.fatecbs.PassagensOnline.service;

import java.util.List;

import com.fatecbs.PassagensOnline.model.Booking;

public interface IService<T> {
	T create(T obj);

	T findById(Long id);

	List<T> findAll();

	boolean update(Long id, Booking booking);

	boolean delete(Long id);
}