package it.corso.model;

import jakarta.persistence.*;

@Entity // classe POJO che rispecchia un entità
@Table(name = "book") //mappatura con la tebella book del db
public class Libro {
	
	@Id
	private int id;
	
	
	@Column (name="title")
	private String titolo;
	
	@Column (name="price")
	private Float prezzo;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="author_id", referencedColumnName = "id")
	private Autore autore;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="category_id", referencedColumnName = "id")
	private Categorie categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	public Categorie getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorie categoria) {
		this.categoria = categoria;
	}
}
