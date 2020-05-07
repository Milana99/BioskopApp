package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Projekcija;

public interface ProjekcijaRepository extends JpaRepository<Projekcija, Long> {

}
