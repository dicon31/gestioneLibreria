package it.corso.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.corso.dao.LibroDao;
import it.corso.model.Libro;
import jakarta.persistence.EntityNotFoundException;

@Service
public class LibroServiceImp implements LibroService {
	@Autowired //proprieta di spring inietta l istanza quello che ci serve depency injection
	LibroDao libroDao;

	@Override
	public List<Libro>getAll() {
		
		// TODO Auto-generated method stub
		List<Libro> libri=(List<Libro>) libroDao.findAll();
		return libri;
	}
	@Override
	public void save(Libro libro) {
		libroDao.save(libro);
	}
	@Override
	public Libro getLibroById(int id) {
		Optional<Libro> libroOptional=libroDao.findById(id);
		if(libroOptional.isPresent())
			return libroOptional.get();
		throw new EntityNotFoundException("Non trovato");
		
	}
	
	@Override
	public void deleteLibro(Libro libro) {
		libroDao.delete(libro);
	}
	@Override 
	public void updateLibro(Libro libro) {
		libroDao.save(libro);
	}
	

	
}
