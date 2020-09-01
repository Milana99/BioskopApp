package com.example.Bioskop.entity.DTO;

public class SalaDTO {

	private String oznaka_sale; 
	private int kapacitet; 
	private Long bioskop_id;
	public String getOznaka_sale() {
		return oznaka_sale;
	}
	public void setOznaka_sale(String oznaka_sale) {
		this.oznaka_sale = oznaka_sale;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public Long getBioskop_id() {
		return bioskop_id;
	}
	public void setBioskop_id(Long bioskop_id) {
		this.bioskop_id = bioskop_id;
	} 
	
	public SalaDTO() {}
	
}
