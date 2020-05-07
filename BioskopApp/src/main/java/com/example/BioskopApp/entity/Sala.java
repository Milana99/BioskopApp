package com.example.BioskopApp.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
public class Sala implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String oznaka_sale;
	
	@Column
	private int kapacitet; 
	
	
	@OneToMany(mappedBy = "sala")
	private Set<Projekcija> projekcija = new HashSet<>();
	
	@ManyToOne
	private Bioskop bioskop;
	
	/*@OneToMany(mappedBy = "salee")
	@JoinTable(name = "Terminska_Lista_Projekcije",
    	joinColumns = { @JoinColumn(name = "Sala", referencedColumnName = "oznakaSale"),
    					@JoinColumn(name="Br_rezervisanih_karata")},
    	inverseJoinColumns = {@JoinColumn(name = "Film_koji_se_projektuje", referencedColumnName = "filmic"),
    						@JoinColumn(name = "Dan_projekcije", referencedColumnName = "dan"),
    						@JoinColumn(name = "Cena_filma", referencedColumnName = "cena")})
	private Set<Projekcija> terminskaListaProjekcija = new HashSet<Projekcija>();*/
	
	public Sala(Long id, String oznaka_sale, int kapacitet, Set<Projekcija> projekcija)
	{
			this.id = id;
			this.oznaka_sale = oznaka_sale;
			this.kapacitet = kapacitet;
			this.projekcija = projekcija;
	}
	
	public int getKapacitet() {
		return kapacitet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public String getOznakaSale() {
		return oznaka_sale;
	}
	public void setOznakaSale(String oznakaSale) {
		this.oznaka_sale = oznakaSale;
	}
	
	@Override
	public String toString() {
		return "Sala [kapacitet=" + kapacitet + ", oznakaSale=" + oznaka_sale + ", cena=" + "]";
	}
	
}
