INSERT INTO Korisnik(type, k_ime, lozinka, ime, prezime, telefon, email, datum_rodjenja, aktivan, uloga) VALUES('mr', 'milana', 'sifra', 'Milana', 'Radovanovic', '0612221', 'milana.rad@gmail.com', '1992-11-03', TRUE, 1);
INSERT INTO Korisnik(type, k_ime, lozinka, ime, prezime, telefon, email, datum_rodjenja, aktivan, uloga) VALUES('fe', 'rasa', 'sifra', 'Radovan', 'Radovanovic', '060123', 'radovan.raske@gmail.com', '1997-09-04', TRUE, 2);
INSERT INTO Korisnik(type, k_ime, lozinka, ime, prezime, telefon, email, datum_rodjenja, aktivan, uloga) VALUES('fr', 'pera', 'sifra', 'Pera', 'Peric', '0612221', 'pera.peki@gmail.com', '1992-11-03', TRUE, 1);

INSERT INTO Bioskop(naziv, adresa, broj_telefona_centrale, email) VALUES ('Filmomanijak', 'Trg Oslobodjenja 21', '021 334 123', 'filmo.maniak@gmail.com' );

INSERT INTO Film(naziv, opis, zanr, trajanje_min, prosecna_ocena) VALUES ('Gospodar Prstenova', 'Veoma dobar film', 'Fantazija-Avantura', 170, 6);
INSERT INTO Film(naziv, opis, zanr, trajanje_min, prosecna_ocena) VALUES ('Lucky number Slevin', 'Odlican film', 'Akcija-Misterija', 110, 7);

INSERT INTO Sala(oznaka_sale, kapacitet, bioskop_id) VALUES ('B1', 50, 1);
INSERT INTO Sala(oznaka_sale, kapacitet, bioskop_id) VALUES ('B2', 120, 1);
INSERT INTO Sala(oznaka_sale, kapacitet, bioskop_id) VALUES ('A1', 80, 1);
INSERT INTO Sala(oznaka_sale, kapacitet, bioskop_id) VALUES ('A2', 250, 1);

INSERT INTO Projekcija(dan, vreme, cena, bioskop_id, film_id) VALUES ('2020-04-03', '12:00', 450, 1, 1 );
INSERT INTO Projekcija(dan, vreme, cena, bioskop_id, film_id) VALUES ('2020-04-03', '14:00', 450, 1, 1 );

INSERT INTO ODGLEDANI_FILMOVI(ocena, korisnik_id, film_id) VALUES (0, 2, 1);
INSERT INTO ODGLEDANI_FILMOVI(ocena, korisnik_id, film_id) VALUES (0, 1, 1);

INSERT INTO LISTA_PROJEKCIJA(sala_id, projekcija_id) VALUES (2, 1); 
INSERT INTO LISTA_PROJEKCIJA(sala_id, projekcija_id) VALUES (1, 1); 

INSERT INTO REZERVACIJE(korisnik_id, projekcija_id) VALUES (2, 1); 

