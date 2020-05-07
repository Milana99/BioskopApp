package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {

}
