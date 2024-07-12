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


import it.corso.model.Categorie;
import it.corso.service.CategorieService;


@Controller
@RequestMapping("/categorie")
public class CategorieController {

	@Autowired
	private CategorieService categorieService;
	
	@GetMapping
	public String getCategoriaString(Model model) {
		//abbimo creato un oggetto che poi lo passiamo al model
		Categorie categoria=new Categorie();
		model.addAttribute("categorie", categorieService.getAll());
		model.addAttribute("categoria", categoria);
		return "home-categorie";
	}
	@PostMapping("save")
	public String saveCategorie(@ModelAttribute("newCategorie")Categorie categoria) {
		categorieService.save(categoria);
		return "redirect:/categorie";
	}
	@GetMapping("delete")
	public String deleteCategorie(@RequestParam("id")int id) {
		categorieService.delete(categorieService.getCategorieById(id));
		return "redirect:/categorie";
	}
	@GetMapping("update")
	public String editCategorie(@RequestParam("id") int id,Model model) {
		Categorie categoria = categorieService.getCategorieById(id);
		model.addAttribute("categoria", categoria);
		return "modifica-categorie";
	}
	
	@PostMapping("update/{id}")
	public String updateCategoria(@PathVariable("id")int id,@ModelAttribute("categoria")Categorie categoria) {
		categorieService.updateCategoria(categoria);
		return "redirect:/categorie";
	}
	
}
