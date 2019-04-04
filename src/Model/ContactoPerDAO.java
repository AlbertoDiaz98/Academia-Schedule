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
public class ContactoPerDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addContact(ContactoPerVO conPersona, PersonaVO persona) {
        try {
            est = conex.getConnection().prepareStatement("Call"
                    + "insert_into_MediosDeContactoPers (?,?,?,?,?,')");
            est.setString(1, conPersona.getNumCelularPer());
            est.setString(2, conPersona.getNumCasaPer());
            est.setString(3, conPersona.getCorreoPer());
            est.setString(4, persona.getNombrePers());
            est.setString(5, persona.getApPaPers());
            est.setString(6, persona.getApMaPers());
            est.executeUpdate();
            est.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar"
                    + " Contactos: \n" + e);
        }
    }

    public ContactoPerVO buscarPersona(int codigo) {

        ContactoPerVO contactFound = new ContactoPerVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM MediosDeContactoPers where idPers = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
                contactFound.setNumCelularPer(res.getString("CelPer"));
                contactFound.setNumCasaPer(res.getString("TelCasaPer"));
                contactFound.setCorreoPer(res.getString("CorreoPer"));

            }
            consulta.close();
            res.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: \n" + e);
        }

        if (existe) {
            return contactFound;
        } else {
            return null;
        }
    }

    public void eliminarContactos(int code) {

        try {

            est = conex.getConnection().prepareStatement("DELETE FROM MediosDeContactoPers"
                    + "WHERE idPers = ?");
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
