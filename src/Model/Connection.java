/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;


/**
 *
 * @author beto-
 */
public class Connection {
     static String login = "root";
   static String password = "935115group";
   static String url = "jdbc:mysql://localhost/Contactos";

   java.sql.Connection conn = null;

   /** Constructor de DbConnection */
   public Connection() {
      try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexi�n
         conn = DriverManager.getConnection(url,login,password);

         if (conn!=null){
            System.out.println("Connection Succeful");
         }
      }
      catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }catch(Exception e){
         System.out.println(e);
      }
   }
   /**Permite retornar la conexi�n*/
   public java.sql.Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
   }
}
