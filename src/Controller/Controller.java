/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import Model.*;
import vistascap.*;
/**
 *
 * @author Raymundo
 */
public class Controller implements ActionListener{
    //View packages
    private v1 v1view;
    private vAgregarDeportista vagregarDeportista;
    private vAgregarDoctor vagregarDoctor;
    private vAgregarEstudiante vagregarEstudiante;
    private vAgregarLicenciado vagregarLicenciado;
    private vAgregarPersona vagregarPersona;
    private vOptions voption;
    //En el constructor inicializamos nuestros objetos
    public Controller( v1 view , vAgregarDeportista vaddSportMan, vAgregarDoctor vaddDoctor,vAgregarEstudiante vaddStudent
    , vAgregarLicenciado vaddLicentiate, vAgregarPersona vaddPerson, vOptions voption){
       this.v1view = view;
       this.vagregarDeportista = vaddSportMan ;
       this.vagregarDoctor = vaddDoctor;
       this.vagregarEstudiante = vaddStudent;
       this.vagregarLicenciado = vaddLicentiate;
       this.vagregarPersona = vaddPerson;
       this.voption = voption;
       iniciar();
   }
    private void iniciar(){
        this.v1view.btnDeportista.setActionCommand("openSportmanView");
        this.v1view.btnDoctor.setActionCommand("openDoctorView");
        this.v1view.btnEstudiante.setActionCommand("openStudentView");
        this.v1view.btnLicenciado.setActionCommand("openLicentiateView");
        this.v1view.btnPersona.setActionCommand("openPersonView");
        v1view.btnDeportista.addActionListener(this);
        v1view.btnDoctor.addActionListener(this);
        v1view.btnEstudiante.addActionListener(this);
        v1view.btnLicenciado.addActionListener(this);
        v1view.btnPersona.addActionListener(this);
        this.v1view.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        
    }
}