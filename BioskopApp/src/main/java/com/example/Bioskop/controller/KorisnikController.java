package com.example.Bioskop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Film;
import com.example.Bioskop.entity.Korisnik;
import com.example.Bioskop.entity.Sala;
import com.example.Bioskop.entity.DTO.KorisnikDTO;
import com.example.Bioskop.entity.DTO.LoginDTO;
import com.example.Bioskop.entity.DTO.MenadzerDTO;
import com.example.Bioskop.entity.DTO.OcenaDTO;
import com.example.Bioskop.entity.DTO.ProjekcijaDTO;
import com.example.Bioskop.entity.DTO.RezervacijeDTO;
import com.example.Bioskop.entity.DTO.SalaDTO;
import com.example.Bioskop.service.BioskopService;
import com.example.Bioskop.service.FilmService;
import com.example.Bioskop.service.KorisnikService;
import com.example.Bioskop.service.ProjekcijaService;
import com.example.Bioskop.service.SalaService;

@Controller
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService; 
	
	@Autowired
	private BioskopService bioskopService; 
	
	@Autowired
	private SalaService salaService; 
	
	@Autowired
	private FilmService filmService; 
	
	@Autowired 
	private ProjekcijaService projekcijaService; 
	
	@GetMapping("/reg")
	public String registracija() {
		return "reg.html";
	}
	
	@PostMapping("/reg-korisnik")
	public ResponseEntity<?> regKorisnik(@RequestBody Korisnik korisnik){
		Korisnik noviKorisnik; 
		try {
			noviKorisnik = korisnikService.save(korisnik); 
			
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		}return new ResponseEntity<>(noviKorisnik, HttpStatus.OK);
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
		Korisnik korisnik; 
		
		try {
			korisnik = this.korisnikService.checkKorisnickoIme(loginDTO);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE); 
		}
		if(korisnik == null)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND); 
		if(!(this.korisnikService.login(loginDTO, korisnik)))
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Korisnik>(korisnik, HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public String account(@PathVariable(name = "id") Long id, Model model) {
		Korisnik korisnik = this.korisnikService.findOne(id);
		model.addAttribute("korisnik", korisnik);
		return "account.html";
	}
	
	@GetMapping("account/{id}/registruj-men")
	public String registrovan(@PathVariable(name = "id") Long id, Model model) {
		List<Bioskop> bioskopi = this.bioskopService.findAll();
		Korisnik korisnik = this.korisnikService.findOne(id);
		model.addAttribute("bioskopi", bioskopi);
		model.addAttribute("korisnik", korisnik); 
		return "registruj_men.html";
	}
	
	//----------------------------------ODGLEDANI FILMOVI----------------------------------------//
	
	@GetMapping("/account/{id}/odgledani-filmovi")
	public String odgledaniFilmovi(@PathVariable(name = "id") Long id, Model model) {
		Korisnik korisnik = this.korisnikService.findOne(id);
		model.addAttribute("korisnik", korisnik);
		return "odgledaniFilmovi.html";
	}

	@PutMapping("/oceni")
	public ResponseEntity<?> oceni(@RequestBody OcenaDTO ocenaDTO){
		try {
			this.korisnikService.oceniFilm(ocenaDTO.getOcena(), ocenaDTO.getFilm_id(), ocenaDTO.getOdgledani_filmovi_id());
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//---------------------------------------------REZERVACIJE----------------------------------//
	
	@GetMapping("/account/{id}/rezervacije")
	public String rezervacije(@PathVariable(name = "id") Long id, Model model) {
		Korisnik korisnik = this.korisnikService.findOne(id); 
		model.addAttribute("korisnik", korisnik); 
		return "rezervacije.html";
	}
	
	@PostMapping("/rezervisi-karte")
	public ResponseEntity<?> rezervisiKarte(@RequestBody RezervacijeDTO rezervacijeDTO)
	{
		boolean karta = false;
		try {
			karta = this.korisnikService.addRezervacija(rezervacijeDTO.getKorisnik_id(), rezervacijeDTO.getProjekcija_id());
			if(karta)
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT); 
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/otkazi-rezervaciju")
	public ResponseEntity<?> cancle(@RequestBody RezervacijeDTO rezervacijeDTO)
	{
		try {
			this.korisnikService.otkaziRezervaciju(rezervacijeDTO.getKorisnik_id(), rezervacijeDTO.getProjekcija_id());
			return new ResponseEntity<>(HttpStatus.OK); 
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	//--------------------------------------MENADZER-------------------------------------//
	
	@GetMapping("/account/{id}/menadzeri")
	public String menadzeri(@PathVariable(name = "id") Long id, Model model) {
		List<Korisnik> korisnici = this.korisnikService.getMenadzeri(); 
		Korisnik korisnik = this.korisnikService.findOne(id); 
		model.addAttribute("menadzeri", korisnici);
		model.addAttribute("korisnik", korisnik); 
		return "menadzeri.html";
	}
	
	@DeleteMapping("/ukloni-menadzera/{id}")
	public ResponseEntity<?> ukloni(@PathVariable(name = "id") Long id){
		try {
			this.korisnikService.deleteKorisnik(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/reg-menadzer")
	public ResponseEntity<?> kreirajMenadzera(@RequestBody MenadzerDTO menadzerDTO){
		try {
			this.korisnikService.saveMenadzer(menadzerDTO);
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}/bioskop")
	public String menadzerBioskopa(@PathVariable(name = "id") Long id, Model model) {
		Korisnik korisnik = this.korisnikService.findOne(id);
		Bioskop bioskop = korisnik.getBioskop(); 
		model.addAttribute("korisnik", korisnik); 
		model.addAttribute("bioskop", bioskop); 
		return "menadzerBioskopa.html";
	}
	
	
	
	//-------------------------------SALA-------------------------------------//
	
	@DeleteMapping("/delete-sala/{bioskop_id}/sala/{sala-id}")
	public ResponseEntity<?> delete_sala(@PathVariable(name = "bioskop_id") Long bioskop_id, @PathVariable(name = "sala_id") Long sala_id){
		try {
			if(this.salaService.deleteById(bioskop_id, sala_id))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.CONFLICT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/add-sala")
	public ResponseEntity<?> addSala(@RequestBody SalaDTO salaDTO){
		try {
			korisnikService.addSala(salaDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		}
	}
	
	@PutMapping("/edit-sala")
	public ResponseEntity<?> editSala(@RequestBody Sala sala){
		try {
			this.korisnikService.editSala(sala);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("account/{id}/bioskop/sala/{sala_id}")
	public String salaEditing(@PathVariable(name = "id") Long id, @PathVariable(name = "sala_id") Long sala_id, Model model) {
		Sala sala = this.salaService.findOne(sala_id);
		model.addAttribute("sala", sala);
		return "sala.html";
	}
	
	//----------------------------------------------PROJEKCIJA-------------------------------------//
	
	@GetMapping("/account/{id}/projekcije")
	public String projekcije(@PathVariable(name = "id") Long id, Model model) {
		Korisnik korisnik = this.korisnikService.findOne(id); 
		Bioskop bioskop = korisnik.getBioskop(); 
		List<Film> filmovi = this.filmService.findAll();
		model.addAttribute("korisnik", korisnik); 
		model.addAttribute("bioskop", bioskop); 
		model.addAttribute("filmovi", filmovi); 
		return "projekcije.html";
	}
	
	@PostMapping("/add-projekcija")
	public ResponseEntity<?> addProjekcija(@RequestBody ProjekcijaDTO projekcijaDTO){
		try {
			this.projekcijaService.addProjekcija(projekcijaDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}
}
