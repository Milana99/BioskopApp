package com.example.Bioskop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.DTO.BioskopDTO;
import com.example.Bioskop.service.BioskopService;

@Controller
public class BioskopController {

	@Autowired
	private BioskopService bioskopService;
	
	@GetMapping("/bioskopi")
	public String bioskopi(Model model) {
		List<Bioskop> bioskopi = this.bioskopService.findAll(); 
		model.addAttribute("bioskopi",bioskopi); 
		return "bioskopi.html";
	}
	
	@DeleteMapping("/bioskopi/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
		if(bioskopService.deleteById(id))
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("/dodaj-bioskop")
	public ResponseEntity<?> add(@RequestBody BioskopDTO bioskopDTO){
		Bioskop bioskop = bioskopService.save(Bioskop.getBioskopByDTO(bioskopDTO)); 
		if(bioskop == null)
			return new ResponseEntity<>(HttpStatus.CONFLICT); 
		return new ResponseEntity<Bioskop>(bioskop, HttpStatus.OK);
	}
	
	@GetMapping("/bioskop/{id}")
	public String bioskop(@PathVariable(name="id") Long id, Model model) {
		Bioskop bioskop = this.bioskopService.findOne(id); 
		model.addAttribute("bioskop", bioskop);
		return "bioskop.html"; 
	}
	
	@PutMapping("/edit-bioskop")
	public ResponseEntity<?> editBioskop(@RequestBody Bioskop bioskop){
		try {
			this.bioskopService.editBioskop(bioskop);
			return new ResponseEntity<>(HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
