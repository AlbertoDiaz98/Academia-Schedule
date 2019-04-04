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
        this.vagregarDeportista.btnVolver.setActionCommand("volverMenu");
        vagregarDeportista.btnVolver.addActionListener(this);
    }
    private void iniciarDoctor(){
        this.vagregarDoctor.btnVolver.setActionCommand("volverMenu");
        vagregarDoctor.btnVolver.addActionListener(this);
    }
    private void iniciarEstudiante(){
        this.vagregarEstudiante.btnVolver.setActionCommand("volverMenu");
        vagregarEstudiante.btnVolver.addActionListener(this);
    }
    private void iniciarLicenciado(){
        this.vagregarLicenciado.btnVolver.setActionCommand("volverMenu");
        vagregarLicenciado.btnVolver.addActionListener(this);
    }
    private void iniciarPersona(){
        this.vagregarPersona.btnVolver.setActionCommand("volverMenu");
        vagregarPersona.btnVolver.addActionListener(this);
    }
    public void go(){
        this.v1view.setVisible(true);
    }
    public void closeWindows(){
        this.v1view.setVisible(false);
        this.vagregarDeportista.setVisible(false);
        this.vagregarDoctor.setVisible(false);
        this.vagregarEstudiante.setVisible(false);
        this.vagregarLicenciado.setVisible(false);
        this.vagregarPersona.setVisible(false);
    }
    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals("openSportmanView")){
            closeWindows();
            this.vagregarDeportista.setVisible(true);
        }else if(comando.equals("openDoctorView")){
            closeWindows();
            this.vagregarDoctor.setVisible(true);
        }else if(comando.equals("openStudentView")){
            closeWindows();
            this.vagregarEstudiante.setVisible(true);
        }else if(comando.equals("openLicentiateView")){
            closeWindows();
            this.vagregarLicenciado.setVisible(true);
        }else if(comando.equals("openPersonView")){
            closeWindows();
            this.vagregarPersona.setVisible(true);
        }else if(comando.equals("volverMenu")){
            closeWindows();
            this.v1view.setVisible(true);
        }
    }
}