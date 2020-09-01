package com.example.Bioskop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.OdgledaniFilmovi;
import com.example.Bioskop.repository.OgledaniFilmovicRepository;

@Service
public class OdgledaniFilmoviService {

	@Autowired 
	private OgledaniFilmovicRepository odgledaniFilmoviRepository; 
	
	public OdgledaniFilmovi findOne(Long id) {
		return this.odgledaniFilmoviRepository.findById(id).get();
	}
	
	public List<OdgledaniFilmovi> findAll(){
		return this.odgledaniFilmoviRepository.findAll();
	}
	
	public OdgledaniFilmovi save(OdgledaniFilmovi odgledaniFilmovi) {
		return this.odgledaniFilmoviRepository.save(odgledaniFilmovi);
	}
	
	public List<OdgledaniFilmovi> getOceniFilm(Long id){
		return this.odgledaniFilmoviRepository.findByFilmId(id); 
	}
	
	public void setOcena(Long id, long ocena) {
		this.odgledaniFilmoviRepository.setOcena(id, ocena);
	}
	
	public double izracunajOcenu(Long id) {
		List<OdgledaniFilmovi> ocene = this.odgledaniFilmoviRepository.findByFilmId(id);
		
		double srednjaOcena = 0;
		int brojac = 0; 
		
		for(int i=0; i<ocene.size(); i++) {
			if(ocene.get(i).getOcena() == 0) {
				continue;
			}
			else {
				srednjaOcena += ocene.get(i).getOcena();
				brojac++;
			}
		}
		srednjaOcena /= brojac; 
		return srednjaOcena;
		
	}
}
