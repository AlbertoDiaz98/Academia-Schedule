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
public class ContactoPerDAO {

    Connection conex = new Connection();
    PreparedStatement est;
    ShowContacts sw = new ShowContacts();
    DefaultTableModel contactoPer = new DefaultTableModel();

    public void addContact(ContactoPerVO conPersona, PersonaVO persona) {
        try {
            est = conex.getConnection().prepareStatement("Call"
                    + "insert_into_MediosDeContactoPers (?,?,?,?,?,')");
            est.setString(1, conPersona.getNumCelular());
            est.setString(2, conPersona.getNumCasa());
            est.setString(3, conPersona.getEmail());
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

    public void modificarContacto(PersonaVO per, ContactoPerVO contacto) {
        try {
            String consulta = "UPDATE MediosDeContactoPers SET "
                    + "CelPers=?, TelCasaEstu=?, CorreoPers=?  WHERE idPers=? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, per.getIdPers());
            estatuto.setString(2, contacto.getNumCelular());
            estatuto.setString(3, contacto.getNumCasa());
            estatuto.setString(4, contacto.getEmail());
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
                contactFound.setNumCelular(res.getString("CelPer"));
                contactFound.setNumCasa(res.getString("TelCasaPer"));
                contactFound.setEmail(res.getString("CorreoPer"));

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

    public DefaultTableModel mostrarContactosPer() {
        try {
            contactoPer = sw.mostrarContactos("Per");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se pudo recuperar Datos");
        }
        return contactoPer;
    }

}
