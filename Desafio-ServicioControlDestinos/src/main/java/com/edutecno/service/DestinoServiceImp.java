package com.edutecno.service;

import java.lang.ProcessHandle.Info;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edutecno.model.Destino;
import com.edutecno.repository.DestinoRepository;

@Service
public class DestinoServiceImp implements DestinoService {
	
	//Logger para dar salida de informacion
	private static final Logger log = LoggerFactory.getLogger(DestinoServiceImp.class);
	
	@Autowired //se inyecta el repositorio para acceder a el
	private DestinoRepository destinoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Destino> findAll() {
		log.info("Ejecutando DestinoServiceImp findAll()");
		return destinoRepository.findAll();
	}

	@Override
	@Transactional
	public void save(Destino destino) {
		log.info("Ejecutando DestinoServiceImp save()");
		destinoRepository.save(destino);
	}

	@Override
	@Transactional
	public void update(Destino destino) {
		log.info("Ejecutando DestinoServiceImp update()");
		destinoRepository.save(destino);
	}

	@Override
	@Transactional
	public void delete(Destino destino) {
		log.info("Ejecutando DestinoServiceImp delete()");
		destinoRepository.delete(destino);
	}

	@Override
	@Transactional(readOnly = true)
	public Destino findById(Long id) {
		log.info("Ejecutando DestinoServiceImp finfById()");
		return destinoRepository.findById(id).get();
	}
}
