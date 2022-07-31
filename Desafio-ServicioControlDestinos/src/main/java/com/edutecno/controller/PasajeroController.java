package com.edutecno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.edutecno.model.Pasajero;
import com.edutecno.service.DestinoService;
import com.edutecno.service.PasajeroService;

@Controller
@RequestMapping({"/","pasajeros"})
public class PasajeroController {
	
	@Autowired
	private PasajeroService pasajeroService;
	
	@Autowired
	private DestinoService destinoService;
	
	@GetMapping
	public ModelAndView pasajeros() {
		ModelAndView modelAndView = new ModelAndView("pasajeros");
		modelAndView.addObject("pasajeros",pasajeroService.findAll());
		return modelAndView;
	}
	@GetMapping("/crear")
	public ModelAndView crear(){
		ModelAndView modelAndView = new ModelAndView("crear-pasajero");
		//objeto pasajero para ser llenado en la vista con thymeleaf
		modelAndView.addObject("pasajero", new Pasajero());
		modelAndView.addObject("destinos", destinoService.findAll());
		return modelAndView;
	}
	@PostMapping("/crear")
	public RedirectView  crear(@ModelAttribute Pasajero pasajero) {
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros");
	}
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id){
		ModelAndView modelAndView = new ModelAndView("editar-pasajero");
		//objeto para ser llenado en la vista con thymeleaf
		modelAndView.addObject("pasajero", new Pasajero());
		//objeto encontrado y que será editado, por lo que se necesitan enviar sus parametros a la vista
		modelAndView.addObject("pasajeroVO", pasajeroService.findById(id));
		//destinos para seleccionar
		modelAndView.addObject("destinos", destinoService.findAll());
		return modelAndView;
	}
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Pasajero pasajero){
		pasajeroService.save(pasajero);
		return new RedirectView("/pasajeros");
	}
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id){
		//buscando al pasajero a eliminar a la base de datos
		Pasajero pasajero = pasajeroService.findById(id);
		pasajeroService.delete(pasajero);
		return new RedirectView("/pasajeros");
	}

}
