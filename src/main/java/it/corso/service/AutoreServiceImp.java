package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import it.corso.dao.AutoreDao;
import it.corso.model.Autore;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AutoreServiceImp implements AutoreService {
	
	@Autowired //proprieta di spring inietta l istanza quello che ci serve depency injection
	AutoreDao autoreDao;

	@Override
	public List<Autore> getAll() {
		
		
		// TODO Auto-generated method stub
		List<Autore> autori=(List<Autore>) autoreDao.findAll(Sort.by(Sort.Direction.DESC,"name"));
		return autori;
	}
	
	@Override
	public void save(Autore autore) {
		autoreDao.save(autore);
	}
	
	@Override
	public Autore getAutoreById(int id) {
		Optional<Autore> autoreOptional=autoreDao.findById(id);
		if(autoreOptional.isPresent())
			return autoreOptional.get();
		throw new EntityNotFoundException("Non trovato");
		
	}
	
	@Override
	public void deleteAutore(Autore autore) {
		autoreDao.delete(autore);
	}
	@Override 
	public void updateAutore(Autore autore) {
		autoreDao.save(autore);
	}
	

}
