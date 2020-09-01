package com.example.Bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.Korisnik;
import com.example.Bioskop.entity.Uloge;
@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Korisnik findByEmail(String email);
	Korisnik findByUsername(String username);
	List<Korisnik> findByUloga(Uloge uloga);

}
