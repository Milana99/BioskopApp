package com.example.BioskopApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.example.BioskopApp.entity.Korisnik;


@SpringBootApplication
public class BioskopAppApplication {
	
	@Autowired
	/*private KorisnikRepository korisnikRepository;

	public void run(String... args) {


		Korisnik korisnik = new Korisnik();
		korisnik.setKorisnickoIme("Jovank12a");
		

		this.korisnikRepository.save(korisnik);

		List<Korisnik> korisnici = this.korisnikRepository.findAll();

		for (Korisnik e : korisnici){
			System.out.println(e);
		}
	}*/
	public static void main(String[] args) {
		SpringApplication.run(BioskopAppApplication.class, args);
	}

}
