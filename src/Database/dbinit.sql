DROP DATABASE IF EXISTS SuiviServiceEtudiants;

CREATE DATABASE SuiviServiceEtudiants DEFAULT CHARACTER SET utf8;

USE SuiviServiceEtudiants;

create table etudiant(
etudid int primary key,
etudcne varchar(10),
etudnom varchar(20),
etudprenom varchar(20),
etudsfam varchar(20),
etudnat varchar(20),
etudnai date,
etudesexe varchar(10),
etudad1 varchar(100),
etudcps int,
etudvil varchar(20),
etuddpt int,
etudtel varchar(10),
etudmail varchar(100),
etudrib bigint,
cniepere varchar(10),
etudnomp varchar(20),
etudprep varchar(20),
etuddnp date,
etudddp date,
cniemere varchar(10),
etudnomm varchar(20),
etudprem varchar(20),
etuddnm date,
etudddm date);

create table etablissement(
	codeetab int primary key,
	desetab varchar(100),
	etuddpm int);


create table filiere(
	codeetab int,
	codefil int,
	desfil varchar(100),
	primary key(codeetab,codefil),
	foreign key(codeetab) references etablissement(codeetab) on delete cascade on update cascade);

create table inscription(
	etudid int,
	etudetab int,
	etudfil int,
	etudinsc date,
	primary key(etudid,etudetab,etudinsc),
	foreign key(etudid) references etudiant(etudid) on delete cascade on update cascade);

create table servicesetud(
	etudid int,
	etudans int,
	etudbo int,
	etudcu int,
	etudcmb int,
	etudcmbo int,
	primary key(etudid,etudans),
	foreign key(etudid) references etudiant(etudid) on delete cascade on update cascade);
