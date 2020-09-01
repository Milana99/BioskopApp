package com.example.Bioskop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bioskop.entity.Bioskop;
import com.example.Bioskop.entity.Sala;
import com.example.Bioskop.repository.SalaRepository;

@Service
public class SalaService {
	@Autowired
	private SalaRepository salaRepository; 
	
	@Autowired BioskopService bioskopService;
	
	public Sala findOne(Long id) {
		return this.salaRepository.findById(id).get();
	}
	
	public List<Sala> findAll(){
		return this.salaRepository.findAll(); 
	}
	
	public Sala save(Sala sala) {
		return this.salaRepository.save(sala);
	}
	
	public boolean deleteById(Long bioskop_id, Long sala_id) {
		try {
			Bioskop bioskop = this.bioskopService.findOne(bioskop_id);
			Sala sala = this.salaRepository.findById(sala_id).get();
			
			bioskop.getSale().remove(sala);
			sala.getLista_projekcija().clear();
			this.salaRepository.deleteById(sala_id);
			return true; 
			
		}catch(Exception e) {
			return false;
		}
		
		//this.salaRepository.deleteById(id);
	}
	
	public void editSala(Sala sala) {
		this.salaRepository.updateSala(sala.getId(), sala.getOznaka_sale(), sala.getKapacitet()); 
	}
}
