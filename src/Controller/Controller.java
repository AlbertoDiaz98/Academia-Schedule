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
    private ContactoDocVO contactoDocVO;
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
    private vContactosDeportista vcontactoDeportista;
    private vContactosDoctor vcontactoDoctor;
    private vContactosEstudiante vcontactoEstudiante;
    private vContactoLicenciado vcontactoLicenciado;
    private vContactosPersona vcontactoPersona;
    
    //En el constructor inicializamos nuestros objetos
    public Controller( v1 view, Connection connection,ContactoDepDAO contactoDepDAO, 
            ContactoDepVO contactoDepVO, vAgregarDeportista vaddSportMan, ContactoDocDAO contactoDocDAO,
            ContactoDocVO contactoDocVO, ContactoEstDAO contactoEstDAO, ContactoEstVO contactoEstVO,
            ContactoLicDAO contactoLicDAO, ContactoLicVO contactoLicVO, ContactoPerDAO contactoPerDAO,
            ContactoPerVO contactoPerVO, DeportistasDAO deportistasDAO, DeportistasVO deportistasVO,
            DoctorDAO doctorDAO, DoctorVO doctorVO, EstudianteDAO estudianteDAO, EstudianteVO estudianteVO,
            LicenciadoDAO licenciadoDAO, LicenciadoVO licendiadoVO, PersonaDAO personaDAO, PersonaVO personaVO,
           vAgregarDoctor vaddDoctor,vAgregarEstudiante vaddStudent
    , vAgregarLicenciado vaddLicentiate, vAgregarPersona vaddPerson, vOptions voption 
   ,vContactosDeportista vcDeportista, vContactosDoctor vcDoctor, vContactoLicenciado vcLicenciado,
    vContactosEstudiante vcEstudiante, vContactosPersona vcPersona){
       this.v1view = view;
       this.connection = connection;
       this.contactoDepDAO = contactoDepDAO;
       this.contactoDepVO = contactoDepVO;
       this.contactoDocDAO = contactoDocDAO;
       this.contactoDocVO = contactoDocVO;
       this.contactoEstDAO = contactoEstDAO;
       this.vagregarDeportista = vaddSportMan ;
       this.vagregarDoctor = vaddDoctor;
       this.vagregarEstudiante = vaddStudent;
       this.vagregarLicenciado = vaddLicentiate;
       this.vagregarPersona = vaddPerson;
       this.voption = voption;
       this.vcontactoDeportista = vcDeportista;
       this.vcontactoDoctor = vcDoctor;
       this.vcontactoEstudiante= vcEstudiante;
       this.vcontactoLicenciado= vcLicenciado;
       this.vcontactoPersona= vcPersona;
       
       
       iniciar();
       iniciarAddDeportista();
       iniciarAddDoctor();
       iniciarAddEstudiante();
       iniciarAddLicenciado();
       iniciarAddPersona();
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

    private void iniciarAddDeportista(){
        this.vagregarDeportista.btnVolver.setActionCommand("volverContacto");
        vagregarDeportista.btnVolver.addActionListener(this);
    }
    private void iniciarAddDoctor(){
        this.vagregarDoctor.btnVolver.setActionCommand("volverContacto");
        vagregarDoctor.btnVolver.addActionListener(this);
    }
    private void iniciarAddEstudiante(){
        this.vagregarEstudiante.btnVolver.setActionCommand("volverContacto");
        vagregarEstudiante.btnVolver.addActionListener(this);
    }
    private void iniciarAddLicenciado(){
        this.vagregarLicenciado.btnVolver.setActionCommand("volverContacto");
        vagregarLicenciado.btnVolver.addActionListener(this);
    }
    private void iniciarAddPersona(){
        this.vagregarPersona.btnVolver.setActionCommand("volverContacto");
        vagregarPersona.btnVolver.addActionListener(this);
    }
    
    private void iniciarConDeportista(){
        this.vcontactoDeportista.btnVolver.setActionCommand("volverMenu");
        vcontactoDeportista.btnVolver.addActionListener(this);
    }
    private void iniciarConDoctor(){
        this.vcontactoDoctor.btnVolver.setActionCommand("volverMenu");
        vcontactoDoctor.btnVolver.addActionListener(this);
    }
    private void iniciarConEstudiante(){
        this.vcontactoEstudiante.btnVolver.setActionCommand("volverMenu");
        vcontactoEstudiante.btnVolver.addActionListener(this);
    }
    private void iniciarConLicenciado(){
        this.vcontactoLicenciado.btnVolver.setActionCommand("volverMenu");
        vcontactoLicenciado.btnVolver.addActionListener(this);
    }
    private void iniciarConPersona(){
        this.vcontactoPersona.btnVolver.setActionCommand("volverMenu");
        vcontactoPersona.btnVolver.addActionListener(this);
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
        else if(comando.equals("insertarDoctor")){
            this.contactoDocVO.setCorreoDoc(this.vagregarDoctor.txtEmail.getText());
            this.contactoDocVO.setNumCasaDoc(this.vagregarDoctor.txtCasa.getText());
            this.contactoDocVO.setNumCelularDoc(this.vagregarDoctor.txtCelular.getText());
            this.doctorVO.setApPaDoc(this.vagregarDoctor.txtApellidoP.getText());
            this.doctorVO.setApMaDoc(this.vagregarDoctor.txtApellidoM.getText());
            this.doctorVO.setDia((String)this.vagregarDoctor.cBoxDia.getSelectedItem());
            this.doctorVO.setMes((String)this.vagregarDoctor.cBoxMes.getSelectedItem());
            this.doctorVO.setAño((String)this.vagregarDoctor.cBoxAño.getSelectedItem());
            this.doctorVO.setEspecialidad((String)this.vagregarDoctor.cBoxEspecialidad.getSelectedItem());
            this.doctorVO.setNomHospital(this.vagregarDoctor.txtNombreHospital.getText());
            this.doctorVO.setDireHospital(this.vagregarDoctor.txtDireccionHospital.getText());
            this.vagregarDoctor.txtNombre.getText();   
        }
        
        else if(comando.equals("insertarEstudiante")){
            this.contactoEstVO.setCorreoEst(this.vagregarEstudiante.txtEmail.getText());
            this.contactoEstVO.setNumCasaEst(this.vagregarEstudiante.txtCasa.getText());
            this.contactoDocVO.setNumCelularDoc(this.vagregarEstudiante.txtCelular.getText());
            this.estudianteVO.setNombreEstu(this.vagregarEstudiante.txtNombre.getText());
            this.estudianteVO.setApPaEstu(this.vagregarEstudiante.txtApellidoP.getText());
            this.estudianteVO.setApMaEstu(this.vagregarEstudiante.txtApellidoM.getText());
            this.estudianteVO.setDia((String)this.vagregarEstudiante.cBoxDia.getSelectedItem());
            this.estudianteVO.setMes((String)this.vagregarEstudiante.cBoxMes.getSelectedItem());
            this.estudianteVO.setAño((String)this.vagregarEstudiante.cBoxAño.getSelectedItem());
            this.estudianteVO.setCarrera((String)this.vagregarEstudiante.txtCarrera.getText());
            this.estudianteVO.setLuNac(this.vagregarDoctor.txtNombreHospital.getText());
            this.estudianteDAO.addPerson(estudianteVO);
            this.contactoEstDAO.addContact(contactoEstVO, estudianteVO);     
            
            
        }
        
        
        else if(comando.equals("modificarEstudiante")){
            this.estudianteDAO.buscarPersona(Integer.parseInt(this.vcontactoDeportista.txtIDDep.getText()));
            this.contactoEstDAO.buscarEstuante(Integer.parseInt(this.vcontactoDeportista.txtIDDep.getText()));
            this.vagregarEstudiante.txtNombre.setText(this.estudianteVO.getNombreEstu()); 
            this.vagregarEstudiante.txtApellidoP.setText(this.estudianteVO.getApPaEstu());
            this.vagregarEstudiante.txtApellidoM.setText(this.estudianteVO.getApMaEstu());
            this.vagregarEstudiante.txtApellidoP.setText(this.estudianteVO.getApPaEstu());
            this.vagregarEstudiante.txtCarrera.setText(this.estudianteVO.getCarrera());
            this.vagregarEstudiante.txtLugarN.setText(this.estudianteVO.getLuNac());
            this.vagregarEstudiante.cBoxDia.setSelectedItem(this.estudianteVO.getDia());
            this.vagregarEstudiante.cBoxMes.setSelectedItem(this.estudianteVO.getMes());
            this.vagregarEstudiante.cBoxAño.setSelectedItem(this.estudianteVO.getAño());
            this.vagregarEstudiante.txtCelular.setText(this.contactoEstVO.getNumCelularEst());
            this.vagregarEstudiante.txtCasa.setText(this.contactoEstVO.getNumCasaEst());
            this.vagregarEstudiante.txtEmail.setText(this.contactoEstVO.getCorreoEst());
            closeWindows();
            this.vagregarEstudiante.setVisible(true);
        }
        
        else if(comando.equals("eliminarEstudiante")){
            this.contactoEstDAO.eliminarContactos(Integer.parseInt(this.vcontactoEstudiante.txtIDEstu.getText()));
            
        }
        
        
        else if(comando.equals("insertarPersona")){
            this.contactoPerVO.setCorreoPer(this.vagregarPersona.txtEmail.getText());
            this.contactoPerVO.setNumCasaPer(this.vagregarPersona.txtCasaPer.getText());
            this.contactoPerVO.setNumCelularPer(this.vagregarPersona.txtCelularPer.getText());
            this.personaVO.setApPaPers(this.vagregarPersona.txtApPaPer.getText());
            this.personaVO.setApMaPers(this.vagregarPersona.txtApMaPer.getText());
            this.personaVO.setDomicilio(this.vagregarPersona.txtDomicilioPer.getText());
            this.personaVO.setOcupacion(this.vagregarPersona.txtOcupacionPer.getText());
            this.personaVO.setMedContacPref((String)this.vagregarPersona.cBoxContactoPer.getSelectedItem());
            this.vagregarPersona.txtNombrePer.getText();           
        }
    }
}