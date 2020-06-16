package com.example.BioskopApp.service;

import java.util.List;

import com.example.BioskopApp.entity.Korisnik;
import com.example.BioskopApp.entityDTO.KorisnikDTO;

public interface KorisnikService {
	
    KorisnikDTO dodaj(KorisnikDTO korisnikdto);
    
    KorisnikDTO login(String korisnicko_ime,String lozinka, boolean aktivan);
    
    KorisnikDTO pregled(String korisnicko_ime);

}
