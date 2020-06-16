package com.example.BioskopApp.entityDTO;

import com.example.BioskopApp.entity.Bioskop;

public class MenadzerDTO {
	 private Bioskop bioskop;

	    public MenadzerDTO() {
	    }

	    public MenadzerDTO(Bioskop bioskop) {
	        this.bioskop = bioskop;
	    }

	    public Bioskop getBioskop() {
	        return bioskop;
	    }

	    public void setBioskop(Bioskop bioskop) {
	        this.bioskop = bioskop;
	    }
}
