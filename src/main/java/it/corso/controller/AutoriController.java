package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Autore;
import it.corso.service.AutoreService;



@Controller
@RequestMapping("/autori")
public class AutoriController {
	
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping
	public String getAutori(Model model) {
		Autore autore=new Autore();
		model.addAttribute("autori",autoreService.getAll());
		model.addAttribute("autore", autore);
		//visualizzare tutti gli autori
		//come facciamo?
		return "home-autori";
	}
	@PostMapping("save")
	public String saveAutori(@ModelAttribute("newAuthor")Autore autore) {
		autoreService.save(autore);
		return "redirect:/autori";
	}
	@GetMapping("delete")
	public String deleteAutore(@RequestParam("id") int id) {
		autoreService.deleteAutore(autoreService.getAutoreById(id));
		return "redirect:/autori";
	}
	@GetMapping("update")
	public String editAutore(@RequestParam("id") int id,Model model) {
		Autore autore = autoreService.getAutoreById(id);
		model.addAttribute("autore", autore);
		return "modifica-autori";
	}
	
	@PostMapping("update/{id}")
	public String updateAutore(@PathVariable("id")int id,@ModelAttribute("autore")Autore autore) {
		autoreService.updateAutore(autore);
		return "redirect:/autori";
	}

	
	
	
	
	
	//metodo per la lista
	//metodo per l'inserimento
	//metodo per l'eliminazione
	//metodo per la modifica
	/**
	 * th href una chiamata in get o per eliminare per cancellare dobbiamo passare un chiamata primaria 
	 * entra nel controller che ha autore il delete in get sta nel href get e un link tu stai aprendo un chiamta tutto che passa in get
	 * dobbiamo recuperare l id lo dobbiamo metttre abbiamo un chiave poi lo passiamo al service e poi lo passa al delete
	 * recuperiamo l autore tutto lo possiamo al model
	 * th field serve mappare i campi quello che staimo scrivendo al nome dell autore
	 * service composta da interfaccia solo metodi impl le i metodi e poi lo implementi 
	 * il dao responsabilita di acccedere al database
	 * 
	 * **/
}
