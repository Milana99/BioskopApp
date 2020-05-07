package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

}
