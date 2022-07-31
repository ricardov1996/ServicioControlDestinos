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

import com.edutecno.model.Destino;
import com.edutecno.service.DestinoService;
import com.edutecno.service.PasajeroService;

@Controller
@RequestMapping("destinos")
public class DestinoController {
	
	@Autowired
	private DestinoService destinoService;
	
	@Autowired
	private PasajeroService pasajeroService;
	
	//encargado de despachar todos los destinos hacia una vista destinos
	@GetMapping
	public ModelAndView destinos() {
		ModelAndView modelAndView = new ModelAndView("destinos");
		modelAndView.addObject("destinos", destinoService.findAll());
		return modelAndView;	
	}
	
	@GetMapping("/crear")
	public ModelAndView crear() {
		ModelAndView modelAndView = new ModelAndView("crear-destino");
		modelAndView.addObject("destino", new Destino());
		modelAndView.addObject("pasajeros", pasajeroService.findAll());
		return modelAndView;
	}
	@PostMapping("/crear")
	public RedirectView crear(@ModelAttribute Destino destino) {
		destinoService.save(destino);
		return new RedirectView("/destinos");
	}
	
	@GetMapping("/editar")
	public ModelAndView editar(@RequestParam Long id) {
		ModelAndView modelAndView = new ModelAndView("editar-destino");
		modelAndView.addObject("destino", new Destino());
		modelAndView.addObject("destinoVO", destinoService.findById(id));
		return modelAndView;	
	}
	@PostMapping("/editar")
	public RedirectView editar(@ModelAttribute Destino destino) {
		destinoService.update(destino);
		return new RedirectView("/destinos");
	}
	@GetMapping("/eliminar")
	public RedirectView eliminar(@RequestParam Long id) {
		Destino destino = destinoService.findById(id);
		destinoService.delete(destino);
		return new RedirectView("/destinos");
	}
}
