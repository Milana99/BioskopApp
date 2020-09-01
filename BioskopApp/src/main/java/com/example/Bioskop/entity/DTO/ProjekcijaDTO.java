package com.example.Bioskop.entity.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Film;
import com.example.Bioskop.entity.Sala;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProjekcijaDTO {
	
	private Date dan;
	private String vreme;
	private double cena;
	private Long film_id;
	private Long sala_id;
	private Long bioskop_id;
	public Date getDan() {
		return dan;
	}
	public void setDan(Date dan) {
		this.dan = dan;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public Long getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}
	public Long getSala_id() {
		return sala_id;
	}
	public void setSala_id(Long sala_id) {
		this.sala_id = sala_id;
	}
	public Long getBioskop_id() {
		return bioskop_id;
	}
	public void setBioskop_id(Long bioskop_id) {
		this.bioskop_id = bioskop_id;
	}
	
	
	public ProjekcijaDTO(Date dan, String vreme, double cena, Long film_id, Long sala_id, Long bioskop_id) {
		super();
		this.dan = dan;
		this.vreme = vreme;
		this.cena = cena;
		this.film_id = film_id;
		this.sala_id = sala_id;
		this.bioskop_id = bioskop_id;
	}
	public ProjekcijaDTO() {}
	
	
	
}
