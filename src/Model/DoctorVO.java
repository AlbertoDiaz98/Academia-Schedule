/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author beto-
 */
public class DoctorVO {

    private int idDoc;
    private String nombreDoc;
    private String apPaDoc;
    private String apMaDoc;
    private String dia;
    private String mes;
    private String año;
    private String especialidad;
    private String nomHospital;
    private String direHospital;

    public int getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public String getApPaDoc() {
        return apPaDoc;
    }

    public void setApPaDoc(String apPaDoc) {
        this.apPaDoc = apPaDoc;
    }

    public String getApMaDoc() {
        return apMaDoc;
    }

    public void setApMaDoc(String apMaDoc) {
        this.apMaDoc = apMaDoc;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getNomHospital() {
        return nomHospital;
    }

    public void setNomHospital(String nomHospital) {
        this.nomHospital = nomHospital;
    }

    public String getDireHospital() {
        return direHospital;
    }

    public void setDireHospital(String direHospital) {
        this.direHospital = direHospital;
    }

}
