package com.example.BioskopApp.entityDTO;

import java.util.Date;

enum Uloge{GLEDALAC, MENADZER, ADMIN}

public class KorisnikDTO {

	protected String korisnicko_ime;
	protected String lozinka; 
	protected String ime;
	protected String prezime; 
	protected String kontakt_telefon; 
	protected String email;
	protected Date datum_rodjenja; 
	protected Uloge uloga; 
	protected Boolean aktivan;
	
	public KorisnikDTO( String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja) 
			{
				this.korisnicko_ime = korisnicko_ime;
				this.lozinka = lozinka;
				this.ime = ime;
				this.prezime = prezime;
				this.kontakt_telefon = kontakt_telefon;
				this.email = email; 
				this.datum_rodjenja = datum_rodjenja; 
			}
	
	public KorisnikDTO(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga) 
			{
				this.korisnicko_ime = korisnicko_ime;
				this.lozinka = lozinka;
				this.ime = ime;
				this.prezime = prezime;
				this.kontakt_telefon = kontakt_telefon;
				this.email = email; 
				this.datum_rodjenja = datum_rodjenja; 
				this.uloga = uloga;
			}
	
	public KorisnikDTO(String korisnicko_ime, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga) 
			{
				this.korisnicko_ime = korisnicko_ime;
				this.ime = ime;
				this.prezime = prezime;
				this.kontakt_telefon = kontakt_telefon;
				this.email = email; 
				this.datum_rodjenja = datum_rodjenja; 
				this.uloga = uloga;
			}

	public String getKorisnickoIme() {
		return korisnicko_ime;
	}

	public void setKorisnickoIme(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getkTelefon() {
		return kontakt_telefon;
	}

	public void setkTelefon(String kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatumRodjenja() {
		return datum_rodjenja;
	}

	public void setDatumRodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public Uloge getUloga() {
		return uloga;
	}

	public void setUloga(Uloge uloge) {
		this.uloga = uloge;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}
	
}
