create database Contactos;
use Contactos;

//Tabla Deportista//
create table Deportista (idDep int auto_increment primary key,nombreDep varchar(20) , apPaDep varchar(20), apMaDep varchar(20), generoDep varchar(20), 
dia varchar(10), mes varchar(10), año varchar(20), deporte varchar(20));

//Tabla Doctor//
create table Doctor (idDoc int auto_increment primary key ,nombreDoc varchar(20) , apPaDoc varchar (20), apMaDoc varchar(20), dia varchar(10),
mes varchar(10),año varchar(20),especialidad varchar(40),nomHospital varchar(40),direHospital varchar(50));

//Tabla Estudiante//
create table Estudiante (idEstu int auto_increment primary key,nombreEstu varchar(20), apPaEstu varchar (20), apMaEstu varchar(20), luNac varchar(30),
dia varchar(10), mes varchar(10), año varchar(20), carrera varchar(20), email varchar(50));

//Tabla Licenciado//                                                                                      
create table Licenciado (idLic int auto_increment primary key ,nombreLic varchar (20), apPaLic varchar(20), apMaLic varchar(20), telOfi varchar(20), 
hrsAten varchar(20));
 
//Tabla Persona//                
create table Persona (idPers auto_increment int primary key, nombrePers varchar(20), apPaPers varchar(20), apMaPers varchar(20), domicilio varchar(50), 
medContacPref varchar(20), ocupacion varchar(20));
 
//Tabla Medios de contacto para Deportista// 
create table MediosDeContactoDep ( CelDep varchar(2000),TelCasaDep varchar(2000), CorreoDep varchar(2000) ,idMediContacDep int auto_increment primary key, idDep int, 
foreign key (idDep) references Deportista(idDep));

//Tabla Medios de contacto para Doctor//                                          
create table MediosDeContactoDoc ( CelDoc varchar(2000), TelCasaDoc varchar(2000), CorreoDoc varchar(2000), idMediContacDoc int auto_increment primary key, idDoc int, 
foreign key (idDoc) references Doctor(idDoc));

//Tabla de Medios de contacto para Estudiante//                                      
create table MediosDeContactoEstu ( CelEstu varchar(2000), TelCasaEstu varchar(2000), CorreoEstu varchar(2000), idMediContacEstu int auto_increment primary key, idEstu int,
foreign key (idEstu) references Estudiante(idEstu));
 
//Tabla de Medios de contacto para Licenciado//                                           
create table MediosDeContactoLic ( CelLic varchar(2000), TelCasaLic varchar(2000), CorreoLic varchar(2000), idMediContacLic int auto_increment primary key, idLic int,
foreign key (idLic) references Licenciado(idLic));

//Tabla para Medios de contacto para Persona//                                          
create table MediosDeContactoPers ( CelPers varchar(2000), TelCasaPers varchar(2000), CorreoPers varchar(2000), idMediContacPers int auto_increment primary key, idPers int,
foreign key (idPers) references Persona(idPers));

//Proceso de Insercion de datos a Contactors//
DELIMITER $$

CREATE PROCEDURE insert_into_MediosDeContactoDep(in cel, in cCasa, in Correo, in nombre,in nomPa, in nomMa)
BEGIN
    insert into MediosDeContactoDep (CelDep,TelCasaDep,CorreoDep,idDep) values (cel,cCasa,Correo,(select idDep from Deportista WHERE nombreDep = nombre and apPaDep = nomPa and apMaDep= nomMa ));
END;
                                 
CREATE PROCEDURE insert_into_MediosDeContactoDoc(in cel, in cCasa, in Correo, in nombre,in nomPa, in nomMa)
BEGIN
    insert into MediosDeContactoDep (CelDoc,TelCasaDoc,CorreoDoc,idDoc) values (cel,cCasa,Correo,(select idDoc from Doctor WHERE nombreDoc = nombre and apPaDoc = nomPa and apMaDoc= nomMa ));
END                                        
;
                                                                                                                                   
CREATE PROCEDURE insert_into_MediosDeContactoEstu(in cel, in cCasa, in Correo, in nombre,in nomPa, in nomMa)
BEGIN
    insert into MediosDeContactoDep (CelEstu,TelCasaEstu,CorreoEstu,idEstu) values (cel,cCasa,Correo,(select idDoc from Estudiante WHERE nombreEstu = nombre and apPaEstu = nomPa and apMaEstu= nomMa ));
END                                        
;
                                                                                                      
CREATE PROCEDURE insert_into_MediosDeContactoLic(in cel, in cCasa, in Correo, in nombre,in nomPa, in nomMa)
BEGIN
    insert into MediosDeContactoDep (CelLic,TelCasaLic,CorreoLic,idLic) values (cel,cCasa,Correo,(select idLic from Licenciado WHERE nombreLic = nombre and apPaLic = nomPa and apMaLic= nomMa ));
END                                        
;

CREATE PROCEDURE insert_into_MediosDeContactoPers(in cel, in cCasa, in Correo, in nombre,in nomPa, in nomMa)
BEGIN
    insert into MediosDeContactoDep (CelPers,TelCasaPers,CorreoEstu,idPers) values (cel,cCasa,Correo,(select idPers from Persona WHERE nombrePers = nombre and apPaPers = nomPa and apMaPers = nomMa ));
END                                        
;
                                                                                                  
                                                                                                  


