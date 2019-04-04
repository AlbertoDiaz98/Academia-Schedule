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
import javax.swing.JButton;
import Model.*;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import vistascap.*;
/**
 *
 * @author Raymundo
 */
public class Controller implements ActionListener{
    //View packages
    private v1 v1view;
    private Connection connection;
    private ContactoDepDAO contactoDepDAO;
    private ContactoDepVO contactoDepVO;
    private ContactoDocDAO contactoDocDAO;
    private ContactoDocVO contactoDocVo;
    private ContactoEstDAO contactoEstDAO;
    private ContactoEstVO contactoEstVO;
    private ContactoLicDAO contactoLicDAO;
    private ContactoLicVO contactoLicVO;
    private ContactoPerDAO contactoPerDAO;
    private ContactoPerVO contactoPerVO;
    private DeportistasDAO deportistasDAO;
    private DeportistasVO deportistasVO;
    private DoctorDAO doctorDAO;
    private DoctorVO doctorVO;
    private EstudianteDAO estudianteDAO;
    private EstudianteVO estudianteVO;
    private LicenciadoDAO licenciadoDAO;
    private LicenciadoVO licendiadoVO;
    private PersonaDAO personaDAO;
    private PersonaVO personaVO;
    private vAgregarDeportista vagregarDeportista;
    private vAgregarDoctor vagregarDoctor;
    private vAgregarEstudiante vagregarEstudiante;
    private vAgregarLicenciado vagregarLicenciado;
    private vAgregarPersona vagregarPersona;
    private vOptions voption;
    //En el constructor inicializamos nuestros objetos
    public Controller( v1 view, Connection connection,ContactoDepDAO contactoDepDAO, 
            ContactoDepVO contactoDepVO, vAgregarDeportista vaddSportMan, ContactoDocDAO contactoDocDAO,
            ContactoDocVO contactoDocVO, ContactoEstDAO contactoEstDAO, ContactoEstVO contactoEstVO,
            ContactoLicDAO contactoLicDAO, ContactoLicVO contactoLicVO, ContactoPerDAO contactoPerDAO,
            ContactoPerVO contactoPerVO, DeportistasDAO deportistasDAO, DeportistasVO deportistasVO,
            DoctorDAO doctorDAO, DoctorVO doctorVO, EstudianteDAO estudianteDAO, EstudianteVO estudianteVO,
            LicenciadoDAO licenciadoDAO, LicenciadoVO licendiadoVO, PersonaDAO personaDAO, PersonaVO personaVO,
           vAgregarDoctor vaddDoctor,vAgregarEstudiante vaddStudent
    , vAgregarLicenciado vaddLicentiate, vAgregarPersona vaddPerson, vOptions voption){
       this.v1view = view;
       this.connection = connection;
       this.contactoDepDAO = contactoDepDAO;
       this.contactoDepVO = contactoDepVO;
       this.contactoDocDAO = contactoDocDAO;
       this.contactoDocVo = contactoDocVO;
       this.contactoEstDAO = contactoEstDAO;
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
    public void go(){
        this.v1view.setVisible(true);
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
        //database insert, search, add and delete
        else if(comando.equals("insertarDeportista")){
            
            this.contactoDepVO.setCorreoDep(this.vagregarDeportista.txtEmail.getText());
            this.vagregarDeportista.txtNombre.getText();
        }
    }
}