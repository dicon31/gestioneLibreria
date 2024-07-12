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


import it.corso.model.Libro;
import it.corso.service.AutoreService;
import it.corso.service.CategorieService;
import it.corso.service.LibroService;

@Controller
@RequestMapping("/libri")
public class LibroController {
	
	@Autowired
	private LibroService libriService;
	
	@Autowired
    private AutoreService autoreService;

    @Autowired
    private CategorieService categorieService;

	
	@GetMapping
	public String getLibroString(Model model) {
		Libro libro=new Libro();
		model.addAttribute("libri", libriService.getAll());
		model.addAttribute("libro", libro);
		model.addAttribute("autori",autoreService.getAll());
		model.addAttribute("categorie", categorieService.getAll());
		return "home-libri";
	}
	@PostMapping("save")
	public String saveLibro(@ModelAttribute("newLibro")Libro libro) {
		libriService.save(libro);
		return "redirect:/libri";
	}
	@GetMapping("delete")
	public String deleteLibro(@RequestParam("id")int id) {
		libriService.deleteLibro(libriService.getLibroById(id));
		return "redirect:/libri";
	}
	@GetMapping("update")
	public String editLibro(@RequestParam("id") int id, Model model) {
	    Libro libro = libriService.getLibroById(id);
	    model.addAttribute("libro", libro);
	    model.addAttribute("autori", autoreService.getAll());
	    model.addAttribute("categorie", categorieService.getAll());
	    return "modifica-libri";
	}
	
	@PostMapping("update/{id}")
	public String updateLibro(@PathVariable("id")int id,@ModelAttribute("libro")Libro libro) {
		libriService.updateLibro(libro);
		return "redirect:/libri";
	}
	


}
