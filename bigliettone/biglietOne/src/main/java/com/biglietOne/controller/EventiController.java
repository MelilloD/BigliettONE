package com.biglietOne.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biglietOne.models.Citta;
import com.biglietOne.models.Evento;
import com.biglietOne.service.CittaService;
import com.biglietOne.service.EventoService;

@Controller
public class EventiController {

    @Autowired
    EventoService eService;

    @Autowired
    CittaService cService;

    @RequestMapping(method = RequestMethod.GET, path = "/paginaEventi")
	public String home(@RequestParam Map<String, String> params ,HttpSession session, Model model) {
        List<Evento> listaEventi = new ArrayList<Evento>();
        
        String tipo = params.get("tipo");
        if("citta".equals(tipo)){
            int idCitta = Integer.parseInt(params.get("idCitta"));
            listaEventi = eService.getEventiFromIdCitta(idCitta);
            model.addAttribute("listaEventi", listaEventi);
            
        }

        if("categoria".equals(tipo)){
            String categoria = params.get("categoria");
            listaEventi = eService.getEventiFromCategoria(categoria);
            model.addAttribute("listaEventi", listaEventi);
        }

       // List<Evento> listaEventi = eService.getEventi();
       //  

        List<Citta> listaCitta = cService.getCitta();
 
        model.addAttribute("listaCitta", listaCitta);

        List<String> listaCategorie = eService.getCategorie();
		model.addAttribute("listaCategorie", listaCategorie);
	
		return "paginaEventi.html";
	
	}

    @RequestMapping(method = RequestMethod.GET, path = "/paginaEvento")
    public String evento( @RequestParam("idEvento") String idEvento , HttpSession session, Model model) {

        Evento e =  eService.getEvento(idEvento);
     
        model.addAttribute("evento", e);
      
        return "paginaEvento.html" ;
    
    }


    @RequestMapping(method = RequestMethod.GET, path = "/paginaDettagliEvento")
        public String dettaglioEvento(HttpSession session, Model model) {
    
            return "paginaDettagliEvento.html" ;
    }
    
}
