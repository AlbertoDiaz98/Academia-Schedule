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
                est.setString(1, conDoctor.getNumCalularDoc());
                est.setString(2, conEstudiante.getNumCasaEst());
                est.setString(3, conEstudiante.getCorreoEst());
                est.setString(4, estudiante.getNombreEstu());
                est.setString(5, estudiante.getApPaEstu());
                est.setString(6, estudiante.getApMaEstu());
                est.executeUpdate();
		est.close();
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar"
                    + " Contactos: \n"+e);
        }
    }
        
         public ContactoEstVO buscarEstuante(int codigo){
        
        ContactoEstVO contactFound= new ContactoEstVO();
	boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContactoEst where idDep = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                contactFound.setNumCelularEst(res.getString("CelEst"));
		contactFound.setNumCasaEst(res.getString("TelCasaEst"));
		contactFound.setCorreoEst(res.getString("CorreoEst"));
		
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

            est = conex.getConnection().prepareStatement("DELETE FROM MediosDeContactoEst"
                    + "WHERE idEst = ?");
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
