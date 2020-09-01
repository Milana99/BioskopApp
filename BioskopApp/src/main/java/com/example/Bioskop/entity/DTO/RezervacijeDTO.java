package com.example.Bioskop.entity.DTO;

public class RezervacijeDTO {
	
	private Long korisnik_id; 
	private Long projekcija_id;
	
	public RezervacijeDTO(Long korisnik_id, Long projekcija_id) {
		super();
		this.korisnik_id = korisnik_id;
		this.projekcija_id = projekcija_id;
	}
	
	public RezervacijeDTO() {}
	
	public Long getKorisnik_id() {
		return korisnik_id;
	}
	public void setKorisnik_id(Long korisnik_id) {
		this.korisnik_id = korisnik_id;
	}
	public Long getProjekcija_id() {
		return projekcija_id;
	}
	public void setProjekcija_id(Long projekcija_id) {
		this.projekcija_id = projekcija_id;
	}
	
	
	

}
