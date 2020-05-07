package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Bioskop;

public interface BioskopRepository extends JpaRepository<Bioskop, Long> {

}
