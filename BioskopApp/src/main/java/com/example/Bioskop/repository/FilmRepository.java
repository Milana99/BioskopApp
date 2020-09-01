package com.example.Bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.Film;
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

	List<Film> findByNazivIgnoreCaseAndZanrIgnoreCaseAndOpisIgnoreCaseAndProsecnaocena(String naziv, String zanr, String opis, Double prosecnaocena);
	List<Film> findAllByNazivIgnoreCase(String naziv);
	List<Film> findAllByOrderByNaziv();
	List<Film> findAllByOrderByProsecnaocena();
	Film findByNazivIgnoreCase(String naziv);
	
	@Modifying
	@Query("update Film set prosecnaocena = :prosecnaocena WHERE id = :filmId")
	void setProsecnaOcena(@Param("filmId") Long id, @Param("prosecnaocena") double prosecnaocena);
	
	
}
