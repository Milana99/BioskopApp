package com.example.Bioskop.entity.DTO;

import java.util.List;

import javax.persistence.Column;

import com.example.Bioskop.entity.Film;

public class FilmDTO {

	private String naziv;
	private String opis;
	private String zanr;
	private int trajanje_min;
	private double prosecna_ocena;
	
	private List<Film> filmovi; 
	
	private List<String> zanrovi;
	
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
	public double getProsecna_ocena() {
		return prosecna_ocena;
	}
	public void setProsecna_ocena(double prosecna_ocena) {
		this.prosecna_ocena = prosecna_ocena;
	}
	public FilmDTO(List<Film> filmovi, List<String> zanrovi) {
		super();
		this.filmovi = filmovi;
		this.zanrovi = zanrovi;
	}
	
	
	
}
