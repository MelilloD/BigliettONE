drop database db;
create database db;
use db ;
create table Utenti
( 
 id_utente int primary key auto_increment,
 nome varchar(45),
 cognome varchar(45),
 data_nascita date,
 email varchar(45),
 username varchar(45),
 pass varchar(45),
 eventi_preferite varchar(45),
 categorie_preferite varchar(45)
 );
 
create table artista (id_artista int primary key auto_increment, 
nome_artista varchar(45),
inf_artista varchar(45)
);
create table citta(id_citta int primary key auto_increment,
    nome_citta varchar (45),
    provincia varchar(45));
create table locations (id_location int primary key auto_increment,
     nome_location varchar (45),
     tipologia_location varchar (45),
     id_citta int , 
     indirizzo varchar (45),
     capienza int ,
     indicazioni_stradali varchar (45),
     foreign key (id_citta)references citta (ID_citta)) ;

     create table eventi_details (
     id_eventi_details int primary key auto_increment,
     data_evento date,
     id_location int,
     id_evento int,
     posti_liberi int,
     foreign key(id_location) references locations(id_location));

     create table prezzi(
     id_prezzi int primary key auto_increment,
     id_eventi_details int,
     prezzo double (10,2),
     foreign key(id_eventi_details) references eventi_details(id_eventi_details));

     create table eventi(
     id_eventi int primary key auto_increment,
     id_eventi_details int,
     categoria varchar(45),
     titolo varchar(45),
     prima_data date,
     ultima_data date,
     id_artista int,
     info_evento varchar(45),
     locandina varchar(45),
     foreign key(id_eventi_details) references eventi_details(id_eventi_details),
     foreign key(id_artista) references artista(id_artista)
     );
     create table prenotazione(
     id_prenotazione int primary key auto_increment,
     id_utente int,
     id_eventi_details int,
     foreign key(id_eventi_details) references eventi_details(id_eventi_details),
     foreign key(id_utente) references utenti(id_utente)
     );