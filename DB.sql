drop database db;
create database db;
use db ;

 
create table artista (id_artista int primary key auto_increment, 
nome_artista varchar(45),
inf_artista varchar(45)
);
create table citta(
	id_citta int primary key auto_increment,
    nome_citta varchar (45),
    provincia varchar(45));

create table Utenti
( 
 id_utente int primary key auto_increment,
 nome varchar(45),
 cognome varchar(45),
 data_nascita date,
 id_citta int,
 email varchar(45),
 username varchar(45),
 pass varchar(45),
 eventi_preferite varchar(45),
 categorie_preferite varchar(45),
 foreign key (id_citta) references citta(id_citta)
 );
    
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
     id_prezzo,
     foreign key(id_eventi_details) references eventi_details(id_eventi_details),
     foreign key(id_utente) references utenti(id_utente),
     foreign key(id_prezzo) references prezzi(id_prezzi)
     );

INSERT INTO `db`.`citta` (`id_citta`, `nome_citta`) VALUES ('1', 'milano');
INSERT INTO `db`.`citta` (`id_citta`, `nome_citta`) VALUES ('2', 'bologna');


INSERT INTO `db`.`locations` (`id_location`, `nome_location`, `tipologia_location`, `id_citta`, `indirizzo`, `capienza`, `indicazioni_stradali`) VALUES ('1', 'forum assago', 'stadio', '1', 'via bho', '1000', 'prima a destra');

INSERT INTO `db`.`artista` (`id_Artista`, `nome_artista`, `inf_artista`) VALUES ('1', 'Vasco rossi', 'non lo so');

INSERT INTO `db`.`eventi` (`id_eventi`, `categoria`, `titolo`, `prima_data`, `ultima_data`, `id_artista`, `info_evento`) VALUES ('1', 'Rock', 'Vasco in Live', '2023-05-25', '2023-05-30', '1', 'live vasco rossi');

INSERT INTO `db`.`eventi_details` (`id_eventi_details`, `data_evento`, `id_location`, `id_evento`, `posti_liberi`) VALUES ('1', '2023-05-23', '1', '1', '1000');
INSERT INTO `db`.`eventi_details` (`id_eventi_details`, `data_evento`, `id_location`, `id_evento`, `posti_liberi`) VALUES ('2', '2023-05-30', '1', '1', '1000');
INSERT INTO `db`.`utenti` (`id_utente`, `username`, `pass`) VALUES ('1', 'admin', 'admin');
