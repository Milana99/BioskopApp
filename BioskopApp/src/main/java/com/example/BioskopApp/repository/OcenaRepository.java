package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Ocena;

public interface OcenaRepository extends JpaRepository<Ocena, Long> {

}
