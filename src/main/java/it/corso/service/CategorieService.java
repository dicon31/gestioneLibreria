package it.corso.service;

import java.util.List;


import it.corso.model.Categorie;

public interface CategorieService {

	List<Categorie> getAll(); 
	void save(Categorie categorie);
	Categorie getCategorieById(int id);
	void delete(Categorie categorie);
	void updateCategoria(Categorie categorie);
}
