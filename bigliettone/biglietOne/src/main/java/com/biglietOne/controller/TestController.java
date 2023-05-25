package com.biglietOne.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biglietOne.models.Evento;
import com.biglietOne.service.EventoService;

@Controller
public class TestController {
	
	@Autowired
	EventoService eService;

	
	@RequestMapping(method = RequestMethod.GET, path = "/test")
	public String home(HttpSession session) {
		
		List<Evento> listaEventi = eService.getEventi();
		
		System.out.println("fermati");
		return "index.html";
	
	}
}
