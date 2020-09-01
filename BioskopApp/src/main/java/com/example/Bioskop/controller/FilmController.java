package com.example.Bioskop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Bioskop.entity.Film;
import com.example.Bioskop.entity.DTO.FilmoviDTO;
import com.example.Bioskop.service.FilmService;

@Controller
public class FilmController {

	@Autowired
	private FilmService filmService; 
	
	@GetMapping("/filmovi")
	public String filmovi(Model model) {
		FilmoviDTO filmoviDTO = this.filmService.getData();
		model.addAttribute("filmoviDTO", filmoviDTO);
		return "filmovi.html"; 
	}
	
	@GetMapping("/film/{id}")
	public String getFilm(@PathVariable(name="id") Long id, Model model) {
		Film film = this.filmService.findOne(id); 
		model.addAttribute("film", film); 
		return "film.html";
	}
}
