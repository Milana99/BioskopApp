package com.example.BioskopApp.entityDTO;

public class LoginDTO {
	 private String korisnicko_ime;
	    private String lozinka;

	    public LoginDTO(String korisnicko_ime, String lozinka) {
	        this.korisnicko_ime = korisnicko_ime;
	        this.lozinka = lozinka;
	    }

	    public LoginDTO() {
	    }

	    public String getKorisnickoIme() {
	        return korisnicko_ime;
	    }

	    public void setKorisnickoIme(String korisnickoIme) {
	        this.korisnicko_ime = korisnickoIme;
	    }
	   
	    public String getLozinka() {
	        return lozinka;
	    }

	    public void setLozinka(String lozinka) {
	        this.lozinka = lozinka;
	    }
	    
	    @Override
	    public String toString() {
	        return "PrijavaKorisnikaDTO{" + "korisnickoIme='" + korisnicko_ime + '\'' +  ", lozinka='" + lozinka + '\'' +
	                '}';
	    }

}
