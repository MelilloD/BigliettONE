package com.biglietOne.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.biglietOne.models.Prezzo;
import com.biglietOne.service.PrezzoService;



@Controller
public class CarrelloController {
	
	@Autowired
	private PrezzoService pService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/testPrezzi")
	public String testPrezzi(HttpSession session, Model model) {

		List<Prezzo> listaPrezzi = pService.getPrezzi();
        model.addAttribute("listaPrezzi", listaPrezzi);

		return "testPrezzi.html";
	}

}
