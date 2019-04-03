create database Contactos;
use Contactos;

//Tabla Deportista//
create table Deportista (idDep int primary key,nombreDep varchar(20) , apPaDep varchar(20), apMaDep varchar(20), generoDep varchar(20), 
dia varchar(10), mes varchar(10), año varchar(20), deporte varchar(20));

//Tabla Doctor//
create table Doctor (idDoc int primary key ,nombreDoc varchar(20) , apPaDoc varchar (20), apMaDoc varchar(20), dia varchar(10),
mes varchar(10),año varchar(20),especialidad varchar(40),nomHospital varchar(40),direHospital varchar(50));

//Tabla Estudiante//
create table Estudiante (idEstu int primary key,nombreEstu varchar(20), apPaEstu varchar (20), apMaEstu varchar(20), luNac varchar(30),
dia varchar(10), mes varchar(10), año varchar(20), carrera varchar(20), email varchar(50));

//Tabla Licenciado//                                                                                      
create table Licenciado (idLic int primary key ,nombreLic varchar (20), apPaLic varchar(20), apMaLic varchar(20), telOfi varchar(20), 
hrsAten varchar(20));
 
//Tabla Persona//                
create table Persona (idPers int primary key, nombrePers varchar(20), apPaPers varchar(20), apMaPers varchar(20), domicilio varchar(50), 
medContacPref varchar(20), ocupacion varchar(20));
 
//Tabla Medios de contacto para Deportista// 
create table MediosDeContactoDep (mediContacDep varchar(2000),idMediContacDep int primary key, idDep int, 
foreign key (idDep) references Deportista(idDep));

//Tabla Medios de contacto para Doctor//                                          
create table MediosDeContactoDoc (mediContacDoc varchar(2000),idMediContacDoc int primary key, idDoc int, 
foreign key (idDoc) references Doctor(idDoc));

//Tabla de Medios de contacto para Estudiante//                                      
create table MediosDeContactoEstu (mediContacEstu varchar(2000),idMediContacEstu int primary key, idEstu int,
foreign key (idEstu) references Estudiante(idEstu));
 
//Tabla de Medios de contacto para Licenciado//                                           
create table MediosDeContactoLic (mediContacLic varchar(2000),idMediContacLic int primary key, idLic int,
foreign key (idLic) references Licenciado(idLic));

//Tabla para Medios de contacto para Persona//                                          
create table MediosDeContactoPers (mediContacPers varchar(2000),idMediContacPers int primary key, idPers int,
foreign key (idPers) references Persona(idPers));
                                        
//Query Deportista//

Insert into Deportista (idDep, nombreDep, apPaDep, apMaDep, generoDep, dia, mes, año, deporte)values ("","","","","","","","","");
Select * from Deportista where id = idDep;
Delete from Deportista where id = idDep;
                                        


