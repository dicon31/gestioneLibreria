package it.corso.service;

import java.util.List;


import it.corso.model.Libro;
public interface LibroService {
	List<Libro> getAll(); 
	void save(Libro libro);
	Libro getLibroById(int id);
	void deleteLibro(Libro libro);
	void updateLibro(Libro libro);
}
