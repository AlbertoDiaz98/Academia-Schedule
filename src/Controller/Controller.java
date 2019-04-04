package Controller;
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
    private Connection connection;
    private vAgregarDeportista vagregarDeportista;
    private vAgregarDoctor vagregarDoctor;
    private vAgregarEstudiante vagregarEstudiante;
    private vAgregarLicenciado vagregarLicenciado;
    private vAgregarPersona vagregarPersona;
    private vOptions voption;
    //En el constructor inicializamos nuestros objetos
    public Controller( v1 view, Connection connection, vAgregarDeportista vaddSportMan, vAgregarDoctor vaddDoctor,vAgregarEstudiante vaddStudent
    , vAgregarLicenciado vaddLicentiate, vAgregarPersona vaddPerson, vOptions voption){
       this.v1view = view;
       this.connection = connection;
       this.vagregarDeportista = vaddSportMan ;
       this.vagregarDoctor = vaddDoctor;
       this.vagregarEstudiante = vaddStudent;
       this.vagregarLicenciado = vaddLicentiate;
       this.vagregarPersona = vaddPerson;
       this.voption = voption;
       iniciar();
       iniciarDeportista();
       iniciarDoctor();
       iniciarEstudiante();
       iniciarLicenciado();
       iniciarPersona();
   }
    private void iniciar(){
        //buttons from v1 view
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
    }
    private void iniciarDeportista(){
        this.vagregarDeportista.btnVolver.setActionCommand("volverMenuDeportista");
        vagregarDeportista.btnVolver.addActionListener(this);
    }
    private void iniciarDoctor(){
        this.vagregarDoctor.btnVolver.setActionCommand("volverMenuDoctor");
        vagregarDoctor.btnVolver.addActionListener(this);
    }
    private void iniciarEstudiante(){
        this.vagregarEstudiante.btnVolver.setActionCommand("volverMenuEstudiante");
        vagregarEstudiante.btnVolver.addActionListener(this);
    }
    private void iniciarLicenciado(){
        this.vagregarLicenciado.btnVolver.setActionCommand("volverMenuLicenciado");
        vagregarLicenciado.btnVolver.addActionListener(this);
    }
    private void iniciarPersona(){
        this.vagregarPersona.btnVolver.setActionCommand("vovlerMenuPersona");
        vagregarPersona.btnVolver.addActionListener(this);
    }
    public void go(){
        this.v1view.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals("openSportmanView")){
            this.vagregarDeportista.setVisible(true);
            this.v1view.setVisible(false);
        }else if(comando.equals("openDoctorView")){
            this.vagregarDoctor.setVisible(true);
            this.v1view.setVisible(false);
        }else if(comando.equals("openStudentView")){
            this.vagregarEstudiante.setVisible(true);
            this.v1view.setVisible(false);
        }else if(comando.equals("openLicentiateView")){
            this.vagregarLicenciado.setVisible(true);
            this.v1view.setVisible(false);
        }else if(comando.equals("openPersonView")){
            this.vagregarPersona.setVisible(true);
            this.v1view.setVisible(false);
        }else if(comando.equals("volverMenuDeportista")){
            this.v1view.setVisible(true);
            this.vagregarDeportista.setVisible(false);
        }else if(comando.equals("volverMenuDoctor")){
            this.v1view.setVisible(true);
            this.vagregarDeportista.setVisible(false);
        }else if(comando.equals("volverMenuEstudiante")){
            this.v1view.setVisible(true);
            this.vagregarEstudiante.setVisible(false);
        }else if(comando.equals("volverMenuLicenciado")){
            this.v1view.setVisible(true);
            this.vagregarLicenciado.setVisible(false);
        }else if(comando.equals("vovlerMenuPersona")){
            this.v1view.setVisible(true);
            this.vagregarPersona.setVisible(false);
        }
    }
}