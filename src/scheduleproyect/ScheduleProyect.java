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
        vAgregarDeportista vaddSportMan = new vAgregarDeportista();
        vAgregarDoctor vaddDoctor = new vAgregarDoctor();
        vAgregarEstudiante vaddStudent = new vAgregarEstudiante();
        vAgregarLicenciado vaddLicentiate = new vAgregarLicenciado();
        vAgregarPersona vaddPerson = new vAgregarPersona();
        vOptions voption = new vOptions();
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista1);
            new Controller(vista1,con , vaddSportMan, vaddDoctor, vaddStudent, vaddLicentiate, vaddPerson, voption).go();
        } catch (UnsupportedLookAndFeelException ex) {}
          catch (ClassNotFoundException ex) {}
          catch (InstantiationException ex) {}
          catch (IllegalAccessException ex) {}
    }
    
}
