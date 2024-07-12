package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity // classe POJO che rispecchia un entità
@Table(name = "category") // mappatura con la tebella author del db
public class Categorie {

	@Id
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(cascade = CascadeType.REFRESH, 
			fetch = FetchType.LAZY, // la modalita la quale al caricamento della pagina
			mappedBy = "categoria", 
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

}
