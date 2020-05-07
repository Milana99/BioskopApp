package com.example.BioskopApp.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import javax.persistence.*;

@Entity
public class Projekcija implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	@JoinColumn
	private Film film; 
	
	@Column
	private Date dan;
	
	@Column
	private double cena; 
	
	@Column
	private int br_rez_karata;
	
	@ManyToOne
	@JoinColumn
	private Sala sala; 
	
	
	public Projekcija(Long id, Film film, Date dan, double cena)
	{
		this.id = id;
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
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
