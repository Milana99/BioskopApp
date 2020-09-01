package com.example.Bioskop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Korisnik;
import com.example.Bioskop.entity.Projekcija;
import com.example.Bioskop.entity.Sala;
import com.example.Bioskop.repository.BioskopRepository;


@Transactional
@Service
public class BioskopService {

	@Autowired
	private BioskopRepository bioskopRepository; 
	
	@Autowired 
	private KorisnikService korisnikService; 
	
	public Bioskop findOne(Long id) {
		Bioskop bioskop = this.bioskopRepository.findById(id).get();
		return bioskop; 
	}
	
	public Bioskop findByNaziv(String naziv) {
		Bioskop bioskop = this.bioskopRepository.findByNazivIgnoreCase(naziv);
		return bioskop; 
	}
	
	public List<Bioskop> findAll(){
		List<Bioskop> bioskopi = this.bioskopRepository.findAll();
		return bioskopi; 
	}
	
	public Bioskop save(Bioskop bioskop) {
		if(bioskop.getNaziv().trim().length() <= 3 || bioskop.getAdresa().trim().length() <= 3 
				|| bioskop.getEmail().trim().length() <= 3 || bioskop.getBroj_telefona_centrale().trim().length() <= 3) {
			return null; 
		}
		return this.bioskopRepository.save(bioskop);
	}
	
	public boolean deleteById(Long id) {
		try {
			Bioskop bioskop = bioskopRepository.findById(id).get();
			List<Korisnik> korisnici = this.korisnikService.findAll(); 
			for(int i = 0; i<korisnici.size(); i++) {
				for(Projekcija projekcija: korisnici.get(i).getRezervisane_karte()) {
					if(projekcija.getBioskop().getId() == bioskop.getId())
						korisnici.get(i).getRezervisane_karte().remove(projekcija);
				}
			}
			for(Sala sala : bioskop.getSale())
				sala.getLista_projekcija().clear();
			
			bioskop.getProjekcije().clear();
			bioskop.getSale().clear();
			bioskopRepository.delete(bioskop);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
		//this.bioskoRepository.deleteById(id);
	}
	
	public void editBioskop(Bioskop bioskop) {
		this.bioskopRepository.updateBioskop(bioskop.getId(), bioskop.getNaziv(), bioskop.getAdresa(), bioskop.getBroj_telefona_centrale(), bioskop.getEmail());
	}
	
}
