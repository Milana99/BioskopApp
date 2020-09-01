package com.example.Bioskop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Film;
import com.example.Bioskop.entity.Projekcija;
import com.example.Bioskop.entity.Sala;
import com.example.Bioskop.entity.DTO.ProjekcijaDTO;
import com.example.Bioskop.repository.ProjekcijaRepository;

@Service
public class ProjekcijaService {
	@Autowired
	private ProjekcijaRepository projekcijaRepository;
	
	@Autowired
	private BioskopService bioskopService; 
	
	@Autowired
	private FilmService filmService; 
	
	@Autowired
	private SalaService salaService; 
	
	public Projekcija findOne(Long id)
	{
		return this.projekcijaRepository.findById(id).get();
	}
	
	public List<Projekcija> findAll(){
		return this.projekcijaRepository.findAll();
	}
	
	public Projekcija save(Projekcija projekcija) {
		return this.projekcijaRepository.save(projekcija);
	}
	
	public List<Projekcija> findByBioskopId(Long id){
		return projekcijaRepository.findByBioskopId(id);
	}
	
	public void addProjekcija(ProjekcijaDTO projekcijaDTO) {
		Projekcija projekcija = new Projekcija(); 
		
		Bioskop bioskop = this.bioskopService.findOne(projekcijaDTO.getBioskop_id());
		Film film = this.filmService.findOne(projekcijaDTO.getFilm_id());
		Sala sale = this.salaService.findOne(projekcijaDTO.getSala_id()); 
		
		projekcija.setBioskop(bioskop);
		projekcija.setFilm(film);
		projekcija.getSale().add(sale);
		projekcija.setDan(projekcijaDTO.getDan());
		projekcija.setCena(projekcijaDTO.getCena());
		projekcija.setVreme(projekcijaDTO.getVreme());
		projekcija.setGledaoci(null);
		
		bioskop.getProjekcije().add(projekcija); 
		sale.getLista_projekcija().add(projekcija);
		this.projekcijaRepository.save(projekcija);
		
	}
}
