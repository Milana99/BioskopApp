package com.example.BioskopApp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("Menadzer")
public class Menadzer extends Korisnik {
	
	@ManyToOne
	private Bioskop bioskop;
	
	public Menadzer(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga, Boolean aktivan, Bioskop bioskop) 
			{
				super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan);
				this.bioskop = bioskop;
			}
	
	public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloge,  Bioskop b) 
			{
				super(korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloge);
				this.bioskop = b;
			}
	
	public Menadzer(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja) 
			{
				super(korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja);
				
			}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}
	
}
