package com.biglietOne.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biglietOne.models.Citta;
import com.biglietOne.models.User;
import com.biglietOne.service.CittaService;
import com.biglietOne.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	private UserService uService;

	@Autowired
    CittaService cService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String home(HttpSession session, Model model) {
		if(session.getAttribute("username") != null) {
			session.invalidate();
		}

		List<Citta> listaCitta = cService.getCitta();
		

        model.addAttribute("listaCitta", listaCitta);

		return "index.html";
	
	}

	/* PAGINE DI LOGIN E REGISTER */

	@RequestMapping(path = "/loginPage", method = RequestMethod.GET)
    public String loginPage(HttpSession session) {
        
        return "loginPage.html";
    }

	@RequestMapping(path = "/registerPage", method = RequestMethod.GET)
    public String registerPage(HttpSession session) {
        
        return "registerPage.html";
    }
	
	/* ------------------------------------------------- */

	@RequestMapping(method = RequestMethod.POST, path = "/login")
	public String loginDipendenti(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
		
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		User c = uService.checkUser(username, password);
		if(c != null) {
			/* da aggiungere nome , cognome ecc. */
			session.setAttribute("nome", c.getNome());
			session.setAttribute("cognome", c.getCognome());
			session.setAttribute("data_nascita", c.getDataNascita());
			session.setAttribute("email", c.getEmail());
			return "areaUtente.html";
		} else {
			session.setAttribute("errore", "Username o password errata");
			return "loginPage.html";
		}	
	}

	@RequestMapping(path = "/checkout", method = RequestMethod.GET)
    public String checkOut(HttpSession session) {
        
        return "checkout.html";
    }

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
	
	

}
