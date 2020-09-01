package com.example.Bioskop.entity;

import java.io.Serializable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static java.lang.Boolean.FALSE;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Korisnik implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name="k_ime", nullable=false, unique=true)
	protected String username;
	
	@Column(nullable=false)
	protected String lozinka;
	
	@Column(nullable=false)
	protected String ime;
	
	@Column(nullable=false)
	protected String prezime;
	
	@Column
	protected String telefon;
	
	@Column(nullable=false)
	protected String email;
	
	@Column
	protected Date datum_rodjenja;
	
	@Column
	protected Uloge uloga;
	
	@Column
	protected Boolean aktivan;
	
	@OneToMany(mappedBy="korisnik", fetch=FetchType.EAGER, orphanRemoval = true)
	Set<OdgledaniFilmovi> odgledaniFilmovi = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Bioskop bioskop;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REZERVACIJE", 
	joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	Set<Projekcija> rezervisane_karte = new HashSet<>();
	
	public Korisnik(String k_ime, String lozinka, String ime, String prezime, String telefon, String email, Date datum_rodjenja,
			Uloge uloga, Boolean aktivan) {
		this.username = k_ime;
		this.lozinka=lozinka;
		this.ime=ime;
		this.prezime=prezime;
		this.telefon=telefon;
		this.email=email;
		this.datum_rodjenja=datum_rodjenja;
		this.uloga=uloga;
		this.aktivan=aktivan;
		
	}
	
	
	public Korisnik(String k_ime2, String lozinka2, String ime2, String prezime2, String telefon2, String email2,
			Date datum_rodjenja2, Uloge uloga2, Boolean aktivan2, Bioskop bioskop2, Object object, Object object2) {
		// TODO Auto-generated constructor stub
	}


	public String getK_ime() {
		return username;
	}

	public void setK_ime(String k_ime) {
		this.username = k_ime;
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

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email =email;
	}

	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(Date datum_rodjenja) {
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

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Set<OdgledaniFilmovi> getOdgledaniFilmovi() {
		return odgledaniFilmovi;
	}


	public void setOdgledaniFilmovi(Set<OdgledaniFilmovi> odgledaniFilmovi) {
		this.odgledaniFilmovi = odgledaniFilmovi;
	}


	public Bioskop getBioskop() {
		return bioskop;
	}


	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}


	public Set<Projekcija> getRezervisane_karte() {
		return rezervisane_karte;
	}


	public void setRezervisane_karte(Set<Projekcija> rezervisane_karte) {
		this.rezervisane_karte = rezervisane_karte;
	}


	@Override
	public String toString() {
		return "Korisnik [k_ime=" + username + ", ime=" + ime + ", prezime=" + prezime + ", telefon=" + telefon
				+ ", Email=" + email + ", datum_rodjenja=" + datum_rodjenja + ", uloga=" + uloga + ", aktivan="
				+ aktivan + "]";
	}
	
	
	
}
