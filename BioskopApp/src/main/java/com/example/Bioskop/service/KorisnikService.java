package com.example.Bioskop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Korisnik;
import com.example.Bioskop.entity.Projekcija;
import com.example.Bioskop.entity.Sala;
import com.example.Bioskop.entity.Uloge;
import com.example.Bioskop.entity.DTO.LoginDTO;
import com.example.Bioskop.entity.DTO.MenadzerDTO;
import com.example.Bioskop.entity.DTO.SalaDTO;
import com.example.Bioskop.service.OdgledaniFilmoviService;
import com.example.Bioskop.repository.KorisnikRepository;

@Transactional
@Service
public class KorisnikService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private OdgledaniFilmoviService odgledaniFilmoviService; 
	
	@Autowired
	private ProjekcijaService projakcijaService; 
	
	@Autowired
	private BioskopService bioskopService; 
	
	@Autowired
	private SalaService salaService;
	
	public Korisnik findOne(Long id) {
		return this.korisnikRepository.findById(id).get();
	}

	public List<Korisnik> findAll(){
		List<Korisnik> korisnici = this.korisnikRepository.findAll();
		return korisnici;
	}
	
	public Korisnik save(Korisnik korisnik) {
		return this.korisnikRepository.save(korisnik);
	}
	
	public boolean login(LoginDTO loginDTO, Korisnik korisnik) {
		if(korisnik.getLozinka().equals(loginDTO.getLozinka()))
			return true;
		return false;
	}
	
	public Korisnik checkKorisnickoIme(LoginDTO loginDTO) {
		Korisnik korisnik = this.korisnikRepository.findByUsername(loginDTO.getK_ime());
		if(korisnik == null)
			return null;
		return korisnik;
	}
	
	public void oceniFilm(Long ocena, Long film_id, Long odgledaniFilm_id) {
		this.odgledaniFilmoviService.setOcena(odgledaniFilm_id, ocena);
		double srednjaOcena = this.odgledaniFilmoviService.izracunajOcenu(film_id);
		this.filmService.setProsecnaOcena(film_id, srednjaOcena);
		return;
	}
	
	public void otkaziRezervaciju(Long korisnik_id, Long projekcija_id) {
		Korisnik korisnik = this.korisnikRepository.findById(korisnik_id).get();
		Projekcija projekcija = this.projakcijaService.findOne(projekcija_id);
		korisnik.getRezervisane_karte().remove(projekcija);
		return;
		
	}
	
	public List<Korisnik> getMenadzeri(){
		return this.korisnikRepository.findByUloga(Uloge.MENADZER);
	}
	
	public void deleteKorisnik(Long id) {
		this.korisnikRepository.deleteById(id);
	}
	
	public void saveMenadzer(MenadzerDTO menadzerDTO) {
		Bioskop bioskop = bioskopService.findOne(menadzerDTO.getBioskop_id());
		Korisnik korisnik = new Korisnik(menadzerDTO.getK_ime(), menadzerDTO.getLozinka(), menadzerDTO.getIme(), 
				menadzerDTO.getPrezime(), menadzerDTO.getTelefon(), menadzerDTO.getEmail(), menadzerDTO.getDatum_rodjenja(), 
				menadzerDTO.getUloga(), menadzerDTO.getAktivan(), bioskop, null, null);
		this.korisnikRepository.save(korisnik);
	}
	public boolean addRezervacija(Long korisnik_id, Long projekcija_id) {
		Korisnik korisnik = this.korisnikRepository.findById(korisnik_id).get();
		Projekcija projekcija = this.projakcijaService.findOne(projekcija_id);
		if(korisnik.getRezervisane_karte().contains(projekcija))
			return false;
		
		for(Sala sala: projekcija.getSale()) {
			if(sala.getKapacitet() - projekcija.getKorisnici().size() > 0) {
				korisnik.getRezervisane_karte().add(projekcija);
				return true; 
			}
		}
		return false;
	}
	
	public void addSala(SalaDTO salaDTO) {
		Bioskop bioskop = this.bioskopService.findOne(salaDTO.getBioskop_id());
		Sala sala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka_sale(), null, bioskop); 
		this.salaService.save(sala);
	}
	
	public void editSala(Sala sala) {
		this.salaService.editSala(sala);
	}
	
}
