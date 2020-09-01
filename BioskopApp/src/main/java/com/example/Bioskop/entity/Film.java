package com.example.Bioskop.entity;

import java.io.Serializable;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Film implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="naziv", nullable=false)
	private String naziv;
	
	@Column
	private String opis;
	
	@Column(nullable=false)
	private String zanr;
	
	@Column(nullable=false)
	private int trajanje_min;
	
	@Column(name = "prosecna_ocena")
	private double prosecnaocena;
	
	@OneToMany(mappedBy = "film")
	private Set<OdgledaniFilmovi> ocena = new HashSet<OdgledaniFilmovi>();
	
	@OneToMany(mappedBy = "film")
	Set<Projekcija> lista_projekcija = new HashSet<Projekcija>();

	public Film(Long id, String naziv, String opis, String zanr, int trajanje_min, double prosecna_ocena) {
		this.id = id;
		this.naziv=naziv;
		this.zanr=zanr;
		this.trajanje_min= trajanje_min;
		this.prosecnaocena = prosecna_ocena;
		
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public int getTrajanje_min() {
		return trajanje_min;
	}

	public void setTrajanje_min(int trajanje_min) {
		this.trajanje_min = trajanje_min;
	}

	public double getOcena() {
		return prosecnaocena;
	}

	@Override
	public String toString() {
		return "Film [naziv=" + naziv + ", opis=" + opis + ", zanr=" + zanr + ", trajanje_min=" + trajanje_min
				+ ", ocena=" + prosecnaocena + "]";
	}
}
