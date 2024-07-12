package it.corso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import it.corso.dao.CategorieDao;
import it.corso.model.Categorie;
import jakarta.persistence.EntityNotFoundException;
@Service
public class CategorieServiceImp implements CategorieService {
	@Autowired //proprieta di spring inietta l istanza quello che ci serve depency injection
	CategorieDao categorieDao;

	@Override
	public List<Categorie> getAll() {
		// TODO Auto-generated method stub
		List<Categorie> categorie=(List<Categorie>) categorieDao.findAll();
		return categorie;
	}
	@Override
	public void save(Categorie categorie) {
		categorieDao.save(categorie);
	}
	public Categorie getCategorieById(int id) {
		Optional<Categorie> categorieOptional=categorieDao.findById(id);
		if(categorieOptional.isPresent())
			return categorieOptional.get();
		throw new EntityNotFoundException("Non trovato");
		
	}
	@Override
	public void delete(Categorie categorie) {
		categorieDao.delete(categorie);
	}
	@Override 
	public void updateCategoria(Categorie categorie) {
		categorieDao.save(categorie);
	}
}
