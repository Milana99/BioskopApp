package com.example.BioskopApp.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Film implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(name = "Opis_Filma")
	private String opis; 
	
	@Column
	private String zanr; 
	
	@Column
	private String trajanje; 
	
	@Column
	private double prosecna_ocena;
	
	/*@ManyToMany(mappedBy = "odgledaniFilmovi")
	private Set<Gledalac> lista_gledalaca = new HashSet<Gledalac>();*/
	
	@ManyToMany(mappedBy = "rezervisani_filmovi")
	private Set<Gledalac> lista_rezervisanih_gledalaca = new HashSet<Gledalac>();
	
	@OneToMany(mappedBy = "film")
	private Set<Ocena> lista_ocena = new HashSet<>();
	
	@OneToMany(mappedBy = "film", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Projekcija> projekcija_filma = new HashSet<Projekcija>(); 
	
	public Film(Long id, String naziv, String opis, String zanr, String trajanje, Double ocena)
	{
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.zanr = zanr; 
		this.trajanje = trajanje; 
		this.prosecna_ocena = ocena;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public double getOcena() {
		return prosecna_ocena;
	}

	@Override
	public String toString() {
		return "Film [naziv=" + naziv 
				+ ", opis=" + opis 
				+ ", zanr=" + zanr 
				+ ", trajanje=" + trajanje 
				+ ", ocena=" + prosecna_ocena + "]";
	} 
	
	
}
