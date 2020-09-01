package com.example.Bioskop.entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;


import javax.persistence.*;

import com.example.Bioskop.entity.DTO.BioskopDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Bioskop implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String naziv;
	
	@Column(nullable=false)
	private String adresa;
	
	@Column(nullable=false)
	private String broj_telefona_centrale;
	
	@Column(nullable=false)
	private String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bioskop")
	private Set<Korisnik> menadzeri = new HashSet<Korisnik>();
	
	@OneToMany(mappedBy = "bioskop",cascade = CascadeType.ALL)
	private Set<Sala> sale = new HashSet<Sala>();
	
	@OneToMany(mappedBy = "bioskop")
	private Set<Projekcija> projekcije = new HashSet<Projekcija>(); 
	
	public Bioskop(Long id, String naziv, String adresa, String broj_telefona_centrale, String email,
			Set<Korisnik> menadzeri, Set<Sala> sale) {
		this.id=id;
		this.naziv=naziv;
		this.adresa=adresa;
		this.broj_telefona_centrale=broj_telefona_centrale;
		this.email=email;
		this.menadzeri=menadzeri;
		this.sale=sale;
	}
	
	

	public Bioskop() {
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Set<Korisnik> getMenadzeri() {
		return menadzeri;
	}



	public void setMenadzeri(Set<Korisnik> menadzeri) {
		this.menadzeri = menadzeri;
	}



	public Set<Sala> getSale() {
		return sale;
	}



	public void setSale(Set<Sala> sale) {
		this.sale = sale;
	}



	public Set<Projekcija> getProjekcije() {
		return projekcije;
	}



	public void setProjekcije(Set<Projekcija> projekcije) {
		this.projekcije = projekcije;
	}



	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBroj_telefona_centrale() {
		return broj_telefona_centrale;
	}

	public void setBroj_telefona_centrale(String broj_telefona_centrale) {
		this.broj_telefona_centrale = broj_telefona_centrale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		return "Bioskop [naziv=" + naziv + ", adresa=" + adresa + ", broj_telefona_centrale=" + broj_telefona_centrale
				+ ", email=" + email + "]";
	}



	public static Bioskop getBioskopByDTO(BioskopDTO bioskopDTO) {
		Bioskop bioskop = new Bioskop(); 
		bioskop.setNaziv(bioskopDTO.getNaziv());
		bioskop.setAdresa(bioskopDTO.getAdresa());
		bioskop.setBroj_telefona_centrale(bioskopDTO.getBroj_telefona_centrale());
		bioskop.setEmail(bioskopDTO.getEmail());
		return bioskop;
	}
	
	
	
	
}
