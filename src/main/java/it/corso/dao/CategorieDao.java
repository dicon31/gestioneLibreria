package it.corso.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Categorie;

public interface CategorieDao extends CrudRepository<Categorie, Integer> {
	Iterable <Categorie> findAll(Sort sort);
}

