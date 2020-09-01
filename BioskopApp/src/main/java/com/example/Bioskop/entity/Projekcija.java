package com.example.Bioskop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Projekcija implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column
	private Date dan;
	
	@Column 
	private String vreme;
	
	@Column
	private double cena;
	
	@JsonIgnore
	@ManyToOne
	private Film film; 
	
	@ManyToMany(mappedBy = "lista_projekcija")
	private Set<Sala> sale = new HashSet<Sala>();
	
	@JsonIgnore
	@ManyToOne
	private Bioskop bioskop;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "rezervisane_karte")
	private Set<Korisnik> korisnici = new HashSet<>();

	public Projekcija() {}
	
	public Projekcija (Long id, Date dan, String vreme, double cena, Film film) {
		this.id = id;
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.film = film;
	}
	
	public Date getDan() {
		return dan;
	}

	public void setDan(Date dan) {
		this.dan = dan;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Set<Sala> getSale() {
		return sale;
	}

	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setGledaoci(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	@Override
	public String toString() {
		return "Projekcija [dan=" + dan + ", cena=" + cena + "]";
	}
	
	
}
