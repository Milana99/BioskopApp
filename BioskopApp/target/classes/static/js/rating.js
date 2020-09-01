function showRated(korisnik){
    showAll(korisnik);
    for(let i=0;i<korisnik.odgledaniFilmovi.length;i++){
        if(korisnik.odgledaniFilmovi[i].rating!=0)
            document.getElementById(korisnik.odgledaniFilmovi[i].id).style.display="";
        else
            document.getElementById(korisnik.odgledaniFilmovi[i].id).style.display="none";
    }
}
function showUnrated(korisnik){
    showAll(korisnik);
    for(let i=0;i<korisnik.odgledaniFilmovi.length;i++){
        if(korisnik.odgledaniFilmovi[i].rating==0)
            document.getElementById(korisnik.odgledaniFilmovi[i].id).style.display="";
        else
            document.getElementById(korisnik.odgledaniFilmovi[i].id).style.display="none";
    }
}
function showAll(korisnik){
    for(let i=0;i<korisnik.odgledaniFilmovi.length;i++){
        document.getElementById(korisnik.odgledaniFilmovi[i].id).style.display="";
    }
}
