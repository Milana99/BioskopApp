package com.example.BioskopApp.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

@Entity
@Table(name = "odgledani_filmovi")
public class Ocena implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private double ocena;
	
	@ManyToOne
	@JoinColumn(name = "id_filma")
	private Film film;
	
	@ManyToOne
	@JoinColumn(name = "gledalac")
	private Gledalac gledalac; 
	
	public Ocena(Long id, Double ocena, Film film, Gledalac gledalac)
	{
		this.id = id;
		this.ocena = ocena;
		this.film = film;
		this.gledalac = gledalac;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Gledalac getGledalac() {
		return gledalac;
	}

	public void setGledalac(Gledalac gledalac) {
		this.gledalac = gledalac;
	}
	
	
	

}
