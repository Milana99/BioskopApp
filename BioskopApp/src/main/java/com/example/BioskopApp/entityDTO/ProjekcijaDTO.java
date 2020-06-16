package com.example.BioskopApp.entityDTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.BioskopApp.entity.Film;
import com.example.BioskopApp.entity.Sala;

public class ProjekcijaDTO {
	
	private Film film; 
	private Date dan;
	private double cena; 
	private int br_rez_karata;
	
	
	public ProjekcijaDTO(Film film, Date dan, double cena)
	{
		this.film = film;
		this.dan = dan;
		this.cena = cena;
	}
	public int getBr_rez_karata() {
		return br_rez_karata;
	}

	public void setBr_rez_karata(int br_rez_karata) {
		this.br_rez_karata = br_rez_karata;
	}
		
	public Date getDan() {
		return dan;
	}
	public void setDan(Date dan) {
		this.dan = dan;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	@Override
	public String toString() {
		return "Projekcija [projekcijaFilma=" + ", dan=" + dan + ", cena=" + cena + "]";
	} 
}
