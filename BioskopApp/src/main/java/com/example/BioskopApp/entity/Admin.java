package com.example.BioskopApp.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Korisnik {
	@OneToOne 
	private Bioskop bioskop;
	
	public Admin(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
				String email, Date datum_rodjenja, Uloge uloga, Boolean aktivan, Bioskop bioskop) 
				{
					super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan);
					this.bioskop = bioskop;
				}
	
	public Admin(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga,  Bioskop bioskop) 
			{
				super(korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga);
				this.bioskop = bioskop;
			}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}
	

}
