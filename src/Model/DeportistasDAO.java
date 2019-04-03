/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author beto-
 */
public class DeportistasDAO {
    
    	Connection conex= new Connection();
        PreparedStatement est;
        
     public void addPerson(DeportistasVO deportista){

	try{
                est = conex.getConnection().prepareStatement("INSERT"
                    + " INTO Deportista VALUES (?,?,?,?,?,?,?,?,?)");
                est.setInt(1, deportista.getIdDep());
                est.setString(2, deportista.getNombreDep());
                est.setString(3, deportista.getApPaDep());
                est.setString(4, deportista.getApMaDep());
                est.setString(5, deportista.getGeneroDep());
                est.setString(6, deportista.getDia());
                est.setString(7, deportista.getMes());
                est.setString(8, deportista.getAño());
                est.setString(9, deportista.getDeporte());
                est.executeUpdate();
		est.close();
                conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n"+e);
        }
    }
    
     
    public DeportistasVO buscarPersona(int codigo){
        Connection conex= new Connection();
        DeportistasVO personFound= new DeportistasVO();
	boolean existe=false;
	try{
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Deportistas where id = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while(res.next()){
                existe=true;
                personFound.setIdDep(Integer.parseInt(res.getString("idDep")));
		personFound.setNombreDep(res.getString("nombreDep"));
		personFound.setApPaDep(res.getString("ApPaDep"));
		personFound.setApMaDep(res.getString("ApMaDep"));
		personFound.setGeneroDep(res.getString("generoDep"));
                personFound.setDia(res.getString("dia"));
                personFound.setMes(res.getString("mes"));
                personFound.setAño(res.getString("año"));
                personFound.setDeporte(res.getString("deporte"));
            }
            consulta.close();
            res.close();
            conex.desconectar();					
	} catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error: \n"+e);	}
        
	if (existe) {
            return personFound;
	} else return null;				
    }
     
     
    public void eliminarPersona(int code){
        Connection conex= new Connection();
	try{
            
            est=conex.getConnection().prepareStatement("DELETE FROM Deportista "
                    + "WHERE id = ?");            
            est.setInt(1, code);
            est.execute();
            JOptionPane.showMessageDialog(null,
                    "Datos eliminados Correctamente",
                    "Información",JOptionPane.INFORMATION_MESSAGE);
            est.close();
            conex.desconectar();
			
	} catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar dator: \n"+e);
	}
    }
    
}
