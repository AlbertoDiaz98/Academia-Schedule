/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduleproyect;
import Controller.Controller;
import Model.*;
import vistascap.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 *
 * @author beto-
 */
public class ScheduleProyect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        v1 vista1 = new v1();
        Connection con = new Connection();
        ContactoDepDAO contactoDepDAO = new ContactoDepDAO();
        ContactoDepVO contactoDepVO = new ContactoDepVO();
        ContactoDocDAO contactoDocDAO = new ContactoDocDAO();
        ContactoDocVO contactoDocVO = new ContactoDocVO();
        ContactoEstDAO contactoEstDAO = new ContactoEstDAO();
        ContactoEstVO contactoEstVO = new ContactoEstVO();
        ContactoLicDAO contactoLicDAO = new ContactoLicDAO();
        ContactoLicVO contactoLicVO = new ContactoLicVO();
        ContactoPerDAO contactoPerDAO = new ContactoPerDAO();
        ContactoPerVO contactoPerVO = new ContactoPerVO();
        DeportistasDAO deportistasDAO = new DeportistasDAO();
        DeportistasVO deportistasVO = new DeportistasVO();
        DoctorDAO doctorDAO = new DoctorDAO();
        DoctorVO doctorVO = new DoctorVO();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        EstudianteVO estudianteVO = new EstudianteVO();
        LicenciadoDAO licenciadoDAO = new LicenciadoDAO();
        LicenciadoVO licenciadoVO = new LicenciadoVO();
        PersonaDAO personaDAO = new PersonaDAO();
        PersonaVO personaVO = new PersonaVO();
        vAgregarDeportista vaddSportMan = new vAgregarDeportista();
        vAgregarDoctor vaddDoctor = new vAgregarDoctor();
        vAgregarEstudiante vaddStudent = new vAgregarEstudiante();
        vAgregarLicenciado vaddLicentiate = new vAgregarLicenciado();
        vAgregarPersona vaddPerson = new vAgregarPersona();
        vOptions voption = new vOptions();
        vContactosDeportista vcDeportista= new vContactosDeportista();
        vContactosDoctor vcDoctor = new vContactosDoctor();
        vContactoLicenciado vcLicenciado = new vContactoLicenciado();
        vContactosEstudiante vcEstudiante = new vContactosEstudiante();
        vContactosPersona vcPersona = new vContactosPersona();

        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista1);
            new Controller(vista1,con,contactoDepDAO,contactoDepVO, 
                vaddSportMan,contactoDocDAO,contactoDocVO,contactoEstDAO,contactoEstVO,contactoLicDAO,
                    contactoLicVO,contactoPerDAO,contactoPerVO,deportistasDAO,deportistasVO,
            doctorDAO,doctorVO,estudianteDAO,estudianteVO,licenciadoDAO,licenciadoVO,personaDAO,personaVO, vaddDoctor, vaddStudent, vaddLicentiate, vaddPerson, voption, 
                    vcDeportista, vcDoctor, vcLicenciado, vcEstudiante, vcPersona).go();
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
    }
    
}
