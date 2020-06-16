package com.example.BioskopApp.entityDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.BioskopApp.entity.Bioskop;
import com.example.BioskopApp.entity.Projekcija;

public class SalaDTO {

	private String oznaka_sale;
	private int kapacitet; 
	private ArrayList<ProjekcijaDTO> projekcija;
	
	public SalaDTO(String oznaka_sale, int kapacitet, ArrayList<ProjekcijaDTO> projekcija)
	{
			this.oznaka_sale = oznaka_sale;
			this.kapacitet = kapacitet;
			this.projekcija = projekcija;
	}
	
	public int getKapacitet() {
		return kapacitet;
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
