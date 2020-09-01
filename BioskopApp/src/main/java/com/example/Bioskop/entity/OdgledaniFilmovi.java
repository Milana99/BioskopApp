package com.example.Bioskop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class OdgledaniFilmovi implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Korisnik korisnik;
	
	@ManyToOne
	private Film film; 
	
	@Column
	private long ocena;
	
	public OdgledaniFilmovi(Long id, Korisnik korisnik, Film film, long ocena) {
		super();
		this.id = id;
		this.korisnik = korisnik;
		this.film = film;
		this.ocena = ocena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public long getOcena() {
		return ocena;
	}

	public void setOcena(long ocena) {
		this.ocena = ocena;
	}
	
}
