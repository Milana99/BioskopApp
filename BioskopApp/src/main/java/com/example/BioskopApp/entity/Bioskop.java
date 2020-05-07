package com.example.BioskopApp.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
public class Bioskop implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column
	private String adresa; 
	
	@Column
	private String broj_telefona_centrale; 
	
	@Column
	private String email;
	
	@OneToMany 
	private Set<Menadzer> menadzeri = new HashSet<Menadzer>();
	
	@OneToMany(mappedBy = "bioskop", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Sala> sale = new HashSet<Sala>();
	
	public Bioskop(Long id, String naziv, String adresa, String broj_telefonske_centrale, String email,  
					Set<Menadzer> menadzeri, Set<Sala> sale)
					{
						this.id = id;
						this.naziv = naziv; 
						this.adresa = adresa;
						this.broj_telefona_centrale = broj_telefonske_centrale;
						this.email = email;
						this.menadzeri = menadzeri;
						this.sale = sale;
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
	public String getBrojTelefonaCentrale() {
		return broj_telefona_centrale;
	}
	public void setBrojTelefonaCentrale(String broj_telefona_centrale) {
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
	
	
}
