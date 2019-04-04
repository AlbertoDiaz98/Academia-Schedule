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
public class ShowContacts {
    
     Connection conex = new Connection();
    PreparedStatement est;
    DefaultTableModel contacto = new DefaultTableModel();
     public DefaultTableModel mostrarContactos(String tabla){
    
     
     boolean existe=false;
	try{
            
            est = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContacto"+tabla);
            
            
            ResultSet res = est.executeQuery();
            contacto.addColumn("Tel. Celular");
            contacto.addColumn("Tel. de Casa");
            contacto.addColumn("Correo Electronico");
            
            

// Bucle para cada resultado en la consulta
while (res.next())
{
   
   Object [] fila = new Object[3]; 

   
   for (int i=0;i<3;i++)
      fila[i] = res.getObject(i+1); 

   
   contacto.addRow(fila); 
}

           
        }catch (SQLException e){
           JOptionPane.showMessageDialog(null, "Error, no se pudo recuperar Datos");
            
	}
       
        return contacto;
        
    }
  
 
    
}
