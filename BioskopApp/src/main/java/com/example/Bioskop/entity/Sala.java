package com.example.Bioskop.entity;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Sala implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="oznaka_sale", nullable = false, unique=true)
	private String oznaka_sale;
	
	@Column
	private int kapacitet;
	
	@ManyToMany
	@JoinTable(name = "LISTA_PROJEKCIJA",
	joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "projekcija_id", referencedColumnName = "id"))
	private Set<Projekcija> lista_projekcija = new HashSet<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Bioskop bioskop; 
	
	public Sala(Long id, String oznaka_sale, int kapacitet, Set<Projekcija> lista_projekcija, Bioskop bioksop) {
		this.oznaka_sale = oznaka_sale;
		this.kapacitet=kapacitet;
		this.bioskop=bioskop;
	}
	
	public Sala(int kapacitet2, String oznaka_sale2, Object object, Bioskop bioskop2) {
		// TODO Auto-generated constructor stub
	}

	public int getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}

	public String getOznaka_sale() {
		return oznaka_sale;
	}

	public void setOznaka_sale(String oznaka_sale) {
		this.oznaka_sale = oznaka_sale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Projekcija> getLista_projekcija() {
		return lista_projekcija;
	}

	public void setLista_projekcija(Set<Projekcija> lista_projekcija) {
		this.lista_projekcija = lista_projekcija;
	}

	public Bioskop getBioskop() {
		return bioskop;
	}

	public void setBioskop(Bioskop bioskop) {
		this.bioskop = bioskop;
	}

	@Override
	public String toString() {
		return "Sala [kapacitet=" + kapacitet + ", oznaka_sale=" + oznaka_sale + "]";
	}
	
	
}
