package com.example.Bioskop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.Film;
import com.example.Bioskop.entity.DTO.FilmDTO;
import com.example.Bioskop.entity.DTO.FilmoviDTO;
import com.example.Bioskop.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired 
	private FilmRepository filmRepository; 
	
	public Film findOne(Long id) {
		Film film = this.filmRepository.findById(id).get();
		return film;
	}
	
	public List<Film> findAll(){
		List<Film> filmovi = this.filmRepository.findAll(); 
		return filmovi; 
	}
	
	public Film save(Film film) {
		return this.filmRepository.save(film);
	}
	
	public FilmoviDTO getData() {
		List<Film> filmovi = findAll(); 
		List<String> zanrovi = new ArrayList<String>(); 
		for(int i = 0; i<filmovi.size(); i++)
		{
			if(!zanrovi.contains(filmovi.get(i).getZanr())) {
				zanrovi.add(filmovi.get(i).getZanr());
			}
		}
		return new FilmoviDTO(filmovi, zanrovi);
	}
	
	public List<Film> orderNaziv(){
		return this.filmRepository.findAllByOrderByNaziv(); 
	}
	
	public List<Film> findByNaziv(String naziv){
		List<Film> filmovi = this.filmRepository.findAllByNazivIgnoreCase(naziv);
		return filmovi;
	}
	
	public List<Film> findByKriterijum(String naziv, String zanr, String opis, double prosecnaocena){
		List<Film> filmovi = this.filmRepository.findByNazivIgnoreCaseAndZanrIgnoreCaseAndOpisIgnoreCaseAndProsecnaocena(naziv, zanr, opis, prosecnaocena);
		return filmovi; 
	}
	
	public Film findOneNaziv(String naziv) {
		Film film = this.filmRepository.findByNazivIgnoreCase(naziv); 
		return film;
	}
	
	public List<Film> orderProsecnaOcena(){
		return this.filmRepository.findAllByOrderByProsecnaocena();
	}
	
	public void setProsecnaOcena(Long id, double prosecna_ocena)
	{
		this.filmRepository.setProsecnaOcena(id, prosecna_ocena);
	}
}
