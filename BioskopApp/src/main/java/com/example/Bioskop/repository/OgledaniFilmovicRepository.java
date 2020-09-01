package com.example.Bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.OdgledaniFilmovi;

@Repository
public interface OgledaniFilmovicRepository extends JpaRepository<OdgledaniFilmovi, Long> {
	List<OdgledaniFilmovi> findByFilmId(Long id);
	
	@Modifying 
	@Query("update OdgledaniFilmovi set ocena = :ocena WHERE id = :id")
	void setOcena(@Param("id") Long id, @Param("ocena") long ocena);
}
