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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beto-
 */
public class DeportistasDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addPerson(DeportistasVO deportista) {

        try {
            est = conex.getConnection().prepareStatement("INSERT"
                    + " INTO Deportista VALUES (?,?,?,?,?,?,?,?,?)");
            est.setString(1, deportista.getNombreDep());
            est.setString(2, deportista.getApPaDep());
            est.setString(3, deportista.getApMaDep());
            est.setString(4, deportista.getGeneroDep());
            est.setString(5, deportista.getDia());
            est.setString(6, deportista.getMes());
            est.setString(7, deportista.getAño());
            est.setString(8, deportista.getDeporte());
            est.executeUpdate();
            est.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n" + e);
        }
    }

    public DeportistasVO buscarPersona(int codigo) {
        Connection conex = new Connection();
        DeportistasVO personFound = new DeportistasVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Deportista where idDep = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e);
        }

        if (existe) {
            return personFound;
        } else {
            return null;
        }
    }

    public void eliminarPersona(int code) {
        Connection conex = new Connection();
        try {

            est = conex.getConnection().prepareStatement("DELETE FROM Deportista "
                    + "WHERE idDep = ?");
            est.setInt(1, code);
            est.execute();
            JOptionPane.showMessageDialog(null,
                    "Datos eliminados Correctamente",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
            est.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al eliminar dator: \n" + e);
        }
    }

    public void modificarPersona(DeportistasVO deportista) {
        try {
            String consulta = "UPDATE Deportista SET idDep= ? "
                    + ",nombreDep = ? , apPaDep=? , apMaDep=? , generoDep=? "
                    + ", dia= ? , mes= ?, año= ? , deporte= ? WHERE idDep=? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, deportista.getIdDep());
            estatuto.setString(2, deportista.getNombreDep());
            estatuto.setString(3, deportista.getApPaDep());
            estatuto.setString(4, deportista.getApMaDep());
            estatuto.setString(5, deportista.getGeneroDep());
            estatuto.setString(6, deportista.getDia());
            estatuto.setString(7, deportista.getMes());
            estatuto.setString(8, deportista.getAño());
            estatuto.setString(9, deportista.getDeporte());
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

     public DefaultTableModel mostrarDatosDep(){
    
     DefaultTableModel tablaDep = new DefaultTableModel();
     boolean existe=false;
	try{
            
            
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Deportista"
                            + "");
            
            
            ResultSet res = consulta.executeQuery();
            tablaDep.addColumn("Id");
            tablaDep.addColumn("Nombre");
            tablaDep.addColumn("Apellido Paterno ");
            tablaDep.addColumn("Apellido Materno");
            tablaDep.addColumn("Genero");
            tablaDep.addColumn("Dia de Nacimiento");
            tablaDep.addColumn("Mes de Nacimiento");
            tablaDep.addColumn("Año de Nacimiento");
            tablaDep.addColumn("Deporte que Practica");

// Bucle para cada resultado en la consulta
while (res.next())
{
   
   Object [] fila = new Object[9]; 

   
   for (int i=0;i<9;i++)
      fila[i] = res.getObject(i+1); 

   
   tablaDep.addRow(fila); 
}

           
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            
	}
       
        return tablaDep;
        
    }
    
   
    
    
}
