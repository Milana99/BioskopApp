package com.example.BioskopApp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BioskopApp.entity.Korisnik;
import com.example.BioskopApp.entityDTO.KorisnikDTO;
import com.example.BioskopApp.entityDTO.LoginDTO;
import com.example.BioskopApp.service.KorisnikService;
@RestController
@RequestMapping
public class KorisnikController {

	/*private final KorisnikService korisnikService;*/
	
	
	@GetMapping("/")
	public String welcome() {
		return "index.html";
	}

    /*@Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }*/

    /*
        Kreiranje novog korisnika
    */

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,    
            produces = MediaType.APPLICATION_JSON_VALUE)     
   /* public ResponseEntity<KorisnikDTO> dodaj(@RequestBody KorisnikDTO korisnikDTO) throws Exception {
        
    	/*KorisnikDTO rezultat= korisnikService.dodaj(korisnikDTO);*/
    	
    	 /*if(rezultat==null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	 else return new ResponseEntity<>(rezultat,HttpStatus.OK);*/
    	 
      /* Korisnik korisnik = new Korisnik(korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka(), korisnikDTO.getIme(), 
        		korisnikDTO.getPrezime(), korisnikDTO.getkTelefon(), korisnikDTO.getEmail(), korisnikDTO.getDatumRodjenja())

        Korisnik noviKorisnik = korisnikService.create(korisnik);

        KorisnikDTO noviKorisnikDTO = new KorisnikDTO(noviKorisnik.getKorisnickoIme(), noviKorisnik.getLozinka(), noviKorisnik.getIme(), 
        		noviKorisnik.getPrezime(), noviKorisnik.getkTelefon(), noviKorisnik.getEmail(), noviKorisnik.getDatumRodjenja());

        return new ResponseEntity<>(noviKorisnikDTO, HttpStatus.OK);
        }
    /*Pregled dodavanja novog korisnika*/
    @GetMapping("/dodaj")
    public String dodajKorisnika(Model model){
        KorisnikDTO korisnik=new KorisnikDTO(null, null, null, null, null, null, null, null);
        model.addAttribute("korisnik",korisnik);
    return "registracija.html";
    }
    
    /*Login korisnika*/
    /*@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> prijavaKorisnika(@RequestBody LoginDTO prijavaKorisnik) {
    	
        KorisnikDTO korisnikDTO = korisnikService.login(prijavaKorisnik.getKorisnickoIme(), prijavaKorisnik.getLozinka(), true);
        if(korisnikDTO == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }*/
    
    /*Pregled logina*/
    @GetMapping("/login")
    public String prijavaKorisnika(Model model){
    	
        KorisnikDTO korisnikDTO =new KorisnikDTO(null, null, null, null, null, null, null, null);
        model.addAttribute("korisnik",korisnikDTO);
        return "prijava.html";
    }
    
    /*pregled profila*/
    /*@GetMapping(value = "/pregled/{korisnickoIme}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<KorisnikDTO> getUser(@PathVariable String korisnickoIme) {
    	
        /*KorisnikDTO korisnikdto = korisnikService.pregled(korisnickoIme);
        if(korisnikdto == null) return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(korisnikdto, HttpStatus.OK);
        
    }*/
  }
