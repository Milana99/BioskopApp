package com.example.Bioskop.entity.DTO;

import java.util.List;

import com.example.Bioskop.entity.Film;

public class FilmoviDTO {

	private List<Film> filmovi; 
	private List<Film> zanrovi;
	
	public List<Film> getFilmovi() {
		return filmovi;
	}
	public void setFilmovi(List<Film> filmovi) {
		this.filmovi = filmovi;
	}
	public List<Film> getZanrovi() {
		return zanrovi;
	}
	public void setZanrovi(List<Film> zanrovi) {
		this.zanrovi = zanrovi;
	} 
	
	public FilmoviDTO() {}
	public FilmoviDTO(List<Film> filmovi2, List<String> zanrovi2) {
		// TODO Auto-generated constructor stub
	}
	
}
