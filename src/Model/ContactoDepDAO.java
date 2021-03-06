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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beto-
 */
public class ContactoDepDAO {
    
  Connection conex= new Connection();
        PreparedStatement est;
        ShowContacts sw = new ShowContacts();
        DefaultTableModel contactoDep= new DefaultTableModel();        
        
        
        public void addContact(ContactoDepVO conDeportista, DeportistasVO deportista){

	try{
                est = conex.getConnection().prepareStatement("Call"
                        + " insert_into_MediosDeContactoDep (?,?,?,?,?,?)");
                est.setString(1, conDeportista.getNumCelularDep());
                est.setString(2, conDeportista.getNumCasaDep());
                est.setString(3, conDeportista.getCorreoDep());
                est.setString(4, deportista.getNombreDep());
                est.setString(5, deportista.getApPaDep());
                est.setString(6, deportista.getApMaDep());
                est.executeUpdate();
		est.close();
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar"
                    + " Contactos: \n"+e);
        }
    }
        
         public ContactoDepVO buscarPersona(int codigo){
        
        ContactoDepVO contactFound= new ContactoDepVO();
	boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContactoDep where idDep = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                contactFound.setNumCelularDep(res.getString("CelDep"));
		contactFound.setNumCasaDep(res.getString("TelCasaDep"));
		contactFound.setCorreoDep(res.getString("CorreoDep"));
		
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

            est = conex.getConnection().prepareStatement("DELETE FROM MediosDeContactoDep"
                    + "WHERE idDep = ?");
            est.setInt(1, code);
            est.execute();
            est.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar Contactos: \n" + e);
        }
    }
        
public void modificarContacto(DeportistasVO deportista, ContactoDepVO contacto) {
        try {
            String consulta = "UPDATE MediosDeContactoDep SET "
                    + "CelDep=?, TelCasaDep=?, CorreoDep=?  WHERE idDep=? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, deportista.getIdDep());
            estatuto.setString(2, contacto.getNumCelularDep());
            estatuto.setString(3, contacto.getNumCasaDep());
            estatuto.setString(4, contacto.getCorreoDep());
           
            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    " Se ha Modificado Correctamente ",
                    "Proceso Realizado Correctamente",
                    JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Error al Modificar: \n" + e,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
 
    public DefaultTableModel mostrarContactosDep(){
	try{
            contactoDep= sw.mostrarContactos("Dep");
        }catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error, no se pudo recuperar Datos");
	}
        return contactoDep;
    }
      
}
