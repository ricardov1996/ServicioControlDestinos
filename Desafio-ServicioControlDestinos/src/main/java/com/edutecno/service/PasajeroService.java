package com.edutecno.service;

import java.util.List;

import com.edutecno.model.Pasajero;

public interface PasajeroService {
	
	public List<Pasajero> findAll();
	public void save(Pasajero pasajero);
	public void update(Pasajero pasajero);
	public void delete(Pasajero pasajero);
	public Pasajero findById(Long id);
}
