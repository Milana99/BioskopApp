package com.example.BioskopApp.entityDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.BioskopApp.entity.Menadzer;
import com.example.BioskopApp.entity.Sala;


public class BioskopDTO {
	
	private String naziv;
	private String adresa; 
	private String broj_telefona_centrale; 
	private String email;
    ArrayList<SalaDTO>sale;
    ArrayList<MenadzerDTO>menadzeri;

	
	public BioskopDTO(String naziv, String adresa, String broj_telefonske_centrale, String email,  
			  ArrayList<SalaDTO>sale, ArrayList<MenadzerDTO> menadzeri)
					{
						this.naziv = naziv; 
						this.adresa = adresa;
						this.broj_telefona_centrale = broj_telefonske_centrale;
						this.email = email;
						this.menadzeri = menadzeri;
						this.sale = sale;
					}
	
	public BioskopDTO(String naziv, String adresa, String broj_telefona_centrale, String eMail) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.broj_telefona_centrale = broj_telefona_centrale;
        this.email = eMail;
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
