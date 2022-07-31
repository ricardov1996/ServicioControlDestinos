package com.edutecno.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Pasajero;
import com.edutecno.repository.PasajeroRepository;

@Service
public class PasajeroServiceImp implements PasajeroService {
	
	private static final Logger log = LoggerFactory.getLogger(PasajeroServiceImp.class);

	@Autowired //inyeccion de dependencias
	private PasajeroRepository pasajeroRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Pasajero> findAll() {
		log.info("Ejecutando PasajeroServiceImp findAll()");
		return pasajeroRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Pasajero pasajero) {
		log.info("Ejecutando PasajeroServiceImp save()");
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void update(Pasajero pasajero) {
		log.info("Ejecutando PasajeroServieImp update()");
		pasajeroRepository.save(pasajero);
	}

	@Override
	@Transactional
	public void delete(Pasajero pasajero) {
		log.info("Ejecutando PasajeroServiceImp delete()");
		pasajeroRepository.delete(pasajero);
	}

	@Override
	@Transactional(readOnly = true)
	public Pasajero findById(Long id) {
		log.info("Ejecutando PasajeroServiceImp findById()");
		return pasajeroRepository.findById(id).get();
	}
}
