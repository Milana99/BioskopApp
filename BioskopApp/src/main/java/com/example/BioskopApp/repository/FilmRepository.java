package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
