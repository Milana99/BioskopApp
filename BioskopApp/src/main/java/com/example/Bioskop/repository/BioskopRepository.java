package com.example.Bioskop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.Bioskop;
@Repository
public interface BioskopRepository extends JpaRepository<Bioskop, Long> {
	
	Bioskop findByNazivIgnoreCase(String naziv);
	
	@Modifying
	@Query("update Bioskop set naziv= :naziv, adresa = :adresa, broj_telefona_centrale = :broj_telefona_centrale, email = :email WHERE id = :id")
	void updateBioskop(@Param("id") Long id, @Param("naziv") String naziv, @Param("adresa") String adresa, @Param("broj_telefona_centrale") String broj_telefona_centrale, @Param("email") String email); 
}
