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
public class ContactoLicDAO {
    
    Connection conex= new Connection();
        PreparedStatement est;
        
        public void addContact(ContactoLicVO conLic, LicenciadoVO licenciado){

	try{
                est = conex.getConnection().prepareStatement("Call"
                        + " insert_into_MediosDeContactoLic (?,?,?,?,?,?)");
                est.setString(1, conLic.getNumCelularLic());
                est.setString(2, conLic.getNumCasaLic());
                est.setString(3, conLic.getCorreoLic());
                est.setString(4, licenciado.getNombreLic());
                est.setString(5, licenciado.getApPaLic());
                est.setString(6, licenciado.getApMaLic());
                est.executeUpdate();
		est.close();
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar"
                    + " Contactos: \n"+e);
        }
    }
        
         public ContactoLicVO buscarPersona(int codigo){
        
        ContactoLicVO contactFound= new ContactoLicVO();
	boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContactoLic where idLic = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                contactFound.setNumCelularLic(res.getString("CelLic"));
		contactFound.setNumCasaLic(res.getString("TelCasaLic"));
		contactFound.setCorreoLic(res.getString("CorreoLic"));
		
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

            est = conex.getConnection().prepareStatement("DELETE FROM MediosDeContactoLic"
                    + "WHERE idLic = ?");
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
