package com.edutecno.service;

import java.util.List;

import com.edutecno.model.Destino;

public interface DestinoService {
	
	public List<Destino> findAll();
	public void save(Destino destino);
	public void update(Destino destino);
	public void delete(Destino destino);
	public Destino findById(Long id);

}
