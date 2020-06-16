INSERT INTO KORISNIK (type, id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) 
VALUES ('Menadzer', 1, 'Milana123', 'lozinka', 'Milana', 'Radovanovic', '1234567', 'milana.radovanovic@gmail.com', '1999-04-01', 1, true);
INSERT INTO KORISNIK (type, id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) 
VALUES ('Gledalac', 2, 'AnaA', 'password', 'Ana', 'Anic', '11111', 'ana.anic@gmail.com', '2001-11-01', 0, false);
INSERT INTO KORISNIK (type, id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) 
VALUES ('Menadzer', 3, 'MilosM', 'sifra', 'Milos', 'Milosevic', '222222', 'milos.milosevic@gmail.com', '1998-01-12', 1, true);
INSERT INTO KORISNIK (type, id, korisnicko_ime, lozinka, ime, prezime, kontakt_telefon, email, datum_rodjenja, uloga, aktivan) 
VALUES ('Gledalac', 4, 'MarkoM', 'zastita', 'Marko', 'Markovic', '098773', 'marko.markovic@gmail.com', '1989-12-01', 0, true);

INSERT INTO BIOSKOP(id, adresa, broj_telefona_centrale, email, naziv) 
VALUES (1, 'Trg mladenaca', '1234', 'bioskop.com', 'Moj bioskop');

INSERT INTO BIOSKOP_MENADZERI(bioskop_id, menadzeri_id) VALUES (1, 1);
INSERT INTO BIOSKOP_MENADZERI(bioskop_id, menadzeri_id) VALUES (1, 3);

INSERT INTO FILM(id, naziv, opis_filma, prosecna_ocena, trajanje, zanr) VALUES (1, 'Marli_i_ja', 'Neki opis', '7.0', '1:00', 'Drama'); 
INSERT INTO FILM(id, naziv, opis_filma, prosecna_ocena, trajanje, zanr) VALUES (2, 'Knjiga_o_dzungli', 'Neki opis', '9.0', '1:00', 'Animirani');

INSERT INTO ODGLEDANI_FILMOVI(ocena, id_filma, gledalac) VALUES (8, 1, 1);
INSERT INTO ODGLEDANI_FILMOVI(ocena, id_filma, gledalac) VALUES (6, 2, 3);
INSERT INTO ODGLEDANI_FILMOVI(ocena, id_filma, gledalac) VALUES (9, 2, 1);

INSERT INTO SALA (id, kapacitet, oznaka_sale, bioskop_id) VALUES (1, 123, 'B1', 1);
INSERT INTO SALA (id, kapacitet, oznaka_sale, bioskop_id) VALUES (2, 100, 'A2', 1);
INSERT INTO SALA (id, kapacitet, oznaka_sale, bioskop_id) VALUES (3, 30, 'B4', 1);

INSERT INTO PROJEKCIJA (id, br_rez_karata, cena, dan, film_id, sala_id) VALUES (1, 30, 340, '2020-10-06', 2, 1);
INSERT INTO PROJEKCIJA (id, br_rez_karata, cena, dan, film_id, sala_id) VALUES (2, 20, 200, '2020-05-06', 1, 2);
INSERT INTO PROJEKCIJA (id, br_rez_karata, cena, dan, film_id, sala_id) VALUES (3, 40, 300, '2020-03-06', 2, 3);


INSERT INTO REZERVISANI_FILMOVI(id_korisnika, id_rezervisanog_filma) VALUES (2, 2);
INSERT INTO REZERVISANI_FILMOVI(id_korisnika, id_rezervisanog_filma) VALUES (1, 1);





