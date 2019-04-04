/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author beto-
 */
public class ContactoDocDAO {Connection conex= new Connection();
        PreparedStatement est;
        
        public void addContact(ContactoDocVO conDoctor, DoctorVO doctor){

	try{
                est = conex.getConnection().prepareStatement("Call"
                        + " insert_into_MediosDeContactoDoc (?,?,?,?,?,?)");
                est.setString(1, conDoctor.getNumCelularDoc());
                est.setString(2, conDoctor.getNumCasaDoc());
                est.setString(3, conDoctor.getCorreoDoc());
                est.setString(4, doctor.getNombreDoc());
                est.setString(5, doctor.getApPaDoc());
                est.setString(6, doctor.getApMaDoc());
                est.executeUpdate();
		est.close();
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar"
                    + " Contactos: \n"+e);
        }
    }
        
         public ContactoDocVO buscarDoctor(int codigo){
        
        ContactoDocVO contactFound= new ContactoDocVO();
	boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContactoDoc where idDoc = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                contactFound.setNumCelularDoc(res.getString("CelDoc"));
		contactFound.setNumCasaDoc(res.getString("TelCasaDoc"));
		contactFound.setCorreoDoc(res.getString("CorreoDoc"));
		
            }
            consulta.close();
            res.close();
            conex.desconectar();					
	} catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error: \n"+e);	}
        
	if (existe) {
            return contactFound;
	} else return null;				
    }
   
 public void eliminarContactos(int code) {
        
        try {

            est = conex.getConnection().prepareStatement("DELETE FROM MediosDeContactoDoc"
                    + "WHERE idDoc = ?");
            est.setInt(1, code);
            est.execute();
            est.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar Contactos: \n" + e);
        }
    }
   
    
    
    
}
