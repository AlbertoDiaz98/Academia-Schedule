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
public class PersonaDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addPerson(PersonaVO persona) {

        try {
            est = conex.getConnection().prepareStatement("INSERT"
                    + "INTO Persona VALUES (?,?,?,?,?,?,?)");
            est.setInt(1, persona.getIdPers());
            est.setString(1, persona.getNombrePers());
            est.setString(2, persona.getApPaPers());
            est.setString(3, persona.getApMaPers());
            est.setString(4, persona.getDomicilio());
            est.setString(5, persona.getMedContacPref());
            est.setString(6, persona.getOcupacion());
            est.executeUpdate();
            est.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n" + e);

        }
    }

    public PersonaVO buscarPersona(int codigo) {
        Connection conex = new Connection();
        PersonaVO personFound = new PersonaVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Persona where id = ?");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
                personFound.setIdPers(Integer.parseInt(res.getString("idPers")));
                personFound.setNombrePers(res.getString("nombrePers"));
                personFound.setApPaPers(res.getString("apPaPers"));
                personFound.setApMaPers(res.getString("apMaPers"));
                personFound.setDomicilio(res.getString("domicilio"));
                personFound.setMedContacPref(res.getString("medContacPref"));
                personFound.setOcupacion(res.getString("ocupacion"));

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

            est = conex.getConnection().prepareStatement("DELETE FROM Persona "
                    + "WHERE idPers = ?");
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

    public void modificarPersona(PersonaVO persona) {
        try {
            String consulta = "UPDATE persona SET idPers=?"
                    + ",nombrePers = ?, apPaPers = ?, apMaPers = ?"
                    + ",dimicilio = ?, medContacPref = ?"
                    + ", ocupacion = ? WHERE idPers = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1, persona.getIdPers());
            estatuto.setString(2, persona.getNombrePers());
            estatuto.setString(3, persona.getApPaPers());
            estatuto.setString(4, persona.getApMaPers());
            estatuto.setString(5, persona.getDomicilio());
            estatuto.setString(6, persona.getMedContacPref());
            estatuto.setString(7, persona.getOcupacion());
            estatuto.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Se ha Modificado Correctamente",
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

    public DefaultTableModel mostrarContactosPers() {

        DefaultTableModel tablaPers = new DefaultTableModel();
        boolean existe = false;
        try {

            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Deportista"
                    + "");

            ResultSet res = consulta.executeQuery();
            tablaPers.addColumn("Id");
            tablaPers.addColumn("Nombre");
            tablaPers.addColumn("Apellido Paterno ");
            tablaPers.addColumn("Apellido Materno");
            tablaPers.addColumn("Domicilio");
            tablaPers.addColumn("Medio de Contacto Preferido");
            tablaPers.addColumn("Ocupacion");

// Bucle para cada resultado en la consulta
            while (res.next()) {

                Object[] fila = new Object[9];

                for (int i = 0; i < 6; i++) {
                    fila[i] = res.getObject(i + 1);
                }

                tablaPers.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, no se conectó");
            System.out.println(e);
        }

        return tablaPers;

    }

}
