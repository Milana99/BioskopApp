package com.example.Bioskop.entity.DTO;

public class OcenaDTO {

	private Long film_id; 
	private Long odgledani_filmovi_id;
	private Long ocena;
	public Long getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}
	public Long getOdgledani_filmovi_id() {
		return odgledani_filmovi_id;
	}
	public void setOdgledani_filmovi_id(Long odgledani_filmovi_id) {
		this.odgledani_filmovi_id = odgledani_filmovi_id;
	}
	public Long getOcena() {
		return ocena;
	}
	public void setOcena(Long ocena) {
		this.ocena = ocena;
	}
	public OcenaDTO(Long film_id, Long odgledani_filmovi_id, Long ocena) {
		super();
		this.film_id = film_id;
		this.odgledani_filmovi_id = odgledani_filmovi_id;
		this.ocena = ocena;
	} 
	
	public OcenaDTO() {}
	
}
