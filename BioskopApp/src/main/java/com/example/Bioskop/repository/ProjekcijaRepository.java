package com.example.Bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bioskop.entity.Projekcija;
@Repository
public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {

	List<Projekcija> findByBioskopId(Long id);
}
