package com.example.Bioskop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.Sala;
@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

	@Modifying
	@Query("update Sala set oznaka_sale = :oznaka_sale, kapacitet = :kapacitet WHERE id = :id")
	void updateSala(@Param("id") Long id, @Param("oznaka_sale") String oznaka_sale, @Param("kapacitet") int kapacitet);
}
