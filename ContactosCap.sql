create database Contactos;
use Contactos;

create table Deportista (idDep int primary key,nombreDep varchar(20) , apPaDep varchar(20), apMaDep varchar(20), generoDep varchar(20), 
dia varchar(10), mes varchar(10), año varchar(20), deporte varchar(20));


create table Doctor (idDoc int primary key ,nombreDoc varchar(20) , apPaDoc varchar (20), apMaDoc varchar(20), dia varchar(10),
mes varchar(10),año varchar(20),especialidad varchar(40),nomHospital varchar(40),direHospital varchar(50));
 
 create table Estudiante (idEstu int primary key,nombreEstu varchar(20), apPaEstu varchar (20), apMaEstu varchar(20), luNac varchar(30),
 dia varchar(10), mes varchar(10), año varchar(20), carrera varchar(20), email varchar(50));
 
 create table Licenciado (idLic int primary key ,nombreLic varchar (20), apPaLic varchar(20), apMaLic varchar(20), telOfi varchar(20), 
 hrsAten varchar(20));
 
 create table Persona (idPers int primary key, nombrePers varchar(20), apPaPers varchar(20), apMaPers varchar(20), domicilio varchar(50), 
 medContacPref varchar(20), ocupacion varchar(20));
 
 
create table MediosDeContactoDep (mediContacDep varchar(2000),idMediContacDep int primary key, idDep int, 
foreign key (idDep) references Deportista(idDep));

create table MediosDeContactoDoc (mediContacDoc varchar(2000),idMediContacDoc int primary key, idDoc int, 
foreign key (idDoc) references Doctor(idDoc));

create table MediosDeContactoEstu (mediContacEstu varchar(2000),idMediContacEstu int primary key, idEstu int,
 foreign key (idEstu) references Estudiante(idEstu));
 
create table MediosDeContactoLic (mediContacLic varchar(2000),idMediContacLic int primary key, idLic int,
foreign key (idLic) references Licenciado(idLic));

create table MediosDeContactoPers (mediContacPers varchar(2000),idMediContacPers int primary key, idPers int,
foreign key (idPers) references Persona(idPers));


