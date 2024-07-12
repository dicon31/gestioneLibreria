package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Autore {
	
	@Id
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(
		cascade = CascadeType.REFRESH, 
		fetch = FetchType.LAZY, 
		mappedBy = "autore", 
		orphanRemoval = true
	)
	private List<Libro> books = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
