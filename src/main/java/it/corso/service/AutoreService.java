package it.corso.service;

import java.util.List;
import it.corso.model.Autore;
public interface AutoreService {
	
	List<Autore> getAll(); 
	
	void save(Autore autore);
	
	Autore getAutoreById(int id);
	
	void deleteAutore(Autore autore);
	
	void updateAutore(Autore autore);
}
