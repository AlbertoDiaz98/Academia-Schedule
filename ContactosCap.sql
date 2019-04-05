reate database Contactos;
use Contactos;

//Tabla Deportista//
create table Deportista (idDep int auto_increment primary key,nombreDep varchar(20) not null , apPaDep varchar(20) not null, apMaDep varchar(20) not null, generoDep varchar(20) not null, 
dia varchar(10) not null , mes varchar(10) not null , año varchar(20) not null, deporte varchar(20) not null);

//Tabla Doctor//
create table Doctor (idDoc int auto_increment primary key ,nombreDoc varchar(20) not null , apPaDoc varchar(20) not null , apMaDoc varchar(20) not null , dia varchar(10) not null ,
mes varchar(10) not null ,año varchar(20) not null,especialidad varchar(40) not null ,nomHospital varchar(40) not null ,direHospital varchar(50) not null );

//Tabla Estudiante//
create table Estudiante (idEstu int auto_increment primary key,nombreEstu varchar(20) not null , apPaEstu varchar (20) not null, apMaEstu varchar(20) not null, luNac varchar(30) not null,
dia varchar(10) not null, mes varchar(10) not null, año varchar(20) not null, carrera varchar(20) not null, email varchar(50) not null);

//Tabla Licenciado//                                                                                      
create table Licenciado (idLic int auto_increment primary key ,nombreLic varchar(20) not null, apPaLic varchar(20) not null, apMaLic varchar(20) not null, telOfi varchar(20)not null, 
hrsAten varchar(20) not null);
 
//Tabla Persona//                
create table Persona (idPers auto_increment int primary key, nombrePers varchar(20) not null, apPaPers varchar(20) not null, apMaPers varchar(20) not null, domicilio varchar(50) not null, 
medContacPref varchar(20) not null, ocupacion varchar(20) not null);
 
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
                                                                                                  
                                                                                                  


