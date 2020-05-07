package com.example.BioskopApp.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;

import static java.lang.Boolean.FALSE;
enum Uloge{GLEDALAC, MENADZER, ADMIN}

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Korisnik implements Serializable {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id; 
	
	@Column(nullable = false)
	protected String korisnicko_ime;
	
	@Column(nullable = false)
	protected String lozinka; 
	
	@Column
	protected String ime;
	
	@Column
	protected String prezime; 
	
	@Column
	protected String kontakt_telefon; 
	
	@Column
	protected String email;
	
	@Column
	protected Date datum_rodjenja; 
	
	@Column
	protected Uloge uloga; 
	
	@Column
	protected Boolean aktivan;
	
	public Korisnik(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga, Boolean aktivan) 
			{
				this.id = id; 
				this.korisnicko_ime = korisnicko_ime;
				this.lozinka = lozinka;
				this.ime = ime;
				this.prezime = prezime;
				this.kontakt_telefon = kontakt_telefon;
				this.email = email; 
				this.datum_rodjenja = datum_rodjenja; 
				this.uloga = uloga;
				this.aktivan = aktivan;
			}

	public Korisnik(String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
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

	public void setUloga(Uloge uloga) {
		this.uloga = uloga;
	}

	public Boolean getAktivan() {
		return aktivan;
	}

	public void setAktivan(Boolean aktivan) {
		this.aktivan = aktivan;
	}

	@Override
	public String toString() {
		return "Korisnik [korisnickoIme=" + korisnicko_ime 
				+ ",  ime=" + ime 
				+ ", prezime=" + prezime 
				+ ", kTelefon=" + kontakt_telefon 
				+ ", email=" + email 
				+ ", datumRodjenja=" + datum_rodjenja
				+ ", uloga=" + uloga 
				+ ", aktivan=" + aktivan + "]";
	} 
	
}
