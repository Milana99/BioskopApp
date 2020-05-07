package com.example.BioskopApp.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@DiscriminatorValue("Gledalac")
public class Gledalac extends Korisnik {
	
	/*@ManyToMany
	private Set<Film> odgledani_filmovi = new HashSet<>();
	
	@ManyToMany
	private Set<Film> rezervisani_filmovi = new HashSet<>();
	
	@ManyToMany
	@JoinTable(name = "Odgledani_Filmovi",
     joinColumns = {@JoinColumn(name = "id_korisnika", referencedColumnName = "id")},
     inverseJoinColumns = {@JoinColumn(name = "id_odgledanog_filma", referencedColumnName = "id")})
	private Set<Film> odgledani_filmovi = new HashSet<Film>(); */
	
	@ManyToMany
	@JoinTable(name = "rezervisani_filmovi",
    	joinColumns = {@JoinColumn(name = "id_korisnika", referencedColumnName = "id")},
    	inverseJoinColumns = @JoinColumn(name = "id_rezervisanog_filma", referencedColumnName = "id"))
	private Set<Film> rezervisani_filmovi = new HashSet<Film>();	
	
	public Gledalac(Long id, String korisnicko_ime, String lozinka, String ime, String prezime, String kontakt_telefon, 
			String email, Date datum_rodjenja, Uloge uloga, Boolean aktivan, Set<Film> odgledani_filmovi, Set<Film> rezervisani_filmovi) 
			{
				super(id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan);
				this.rezervisani_filmovi = rezervisani_filmovi;
			}
	
	
}
