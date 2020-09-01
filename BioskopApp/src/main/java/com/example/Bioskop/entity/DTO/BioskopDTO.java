package com.example.Bioskop.entity.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BioskopDTO {

	private String naziv;
	private String adresa;
	private String broj_telefona_centrale;
	private String email;
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
	
	public BioskopDTO() {}

}
