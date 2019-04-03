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
public class DoctorDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addPerson(DoctorVO doctor) {

        try {
            est = conex.getConnection().prepareStatement("INSERT"
                    + "INTO Doctor VALUES (?,?,?,?,?,?,?,?,?,?)");
            est.setInt(1, doctor.getIdDoc());
            est.setString(2, doctor.getNombreDoc());
            est.setString(3, doctor.getApPaDoc());
            est.setString(4, doctor.getApMaDoc());
            est.setString(5, doctor.getDia());
            est.setString(6, doctor.getMes());
            est.setString(7, doctor.getAño());
            est.setString(8, doctor.getEspecialidad());
            est.setString(9, doctor.getNomHospital());
            est.setString(10, doctor.getDireHospital());
            est.executeUpdate();
            est.close();
            conex.desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n" + e);

        }
    }

    public DoctorVO buscarPersona(int codigo) {
        Connection conex = new Connection();
        DoctorVO personFound = new DoctorVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Doctor where id = ?");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
                personFound.setIdDoc(Integer.parseInt(res.getString("idDoc")));
                personFound.setNombreDoc(res.getString("nombreDoc"));
                personFound.setApPaDoc(res.getString("apPaDoc"));
                personFound.setApMaDoc(res.getString("apMaDoc"));
                personFound.setDia(res.getString("dia"));
                personFound.setMes(res.getString("mes"));
                personFound.setAño(res.getString("año"));
                personFound.setNomHospital(res.getString("nomHospital"));
                personFound.setDireHospital(res.getString("direHospital"));

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

            est = conex.getConnection().prepareStatement("DELETE FROM Doctor "
                    + "WHERE idDoc = ?");
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

    public void modificarPersona(DoctorVO doctor) {
        try {
            String consulta = "UPDATE persona SET idDoc=?"
                    + ",nombreDoc = ?, apPaDoc = ?, apMaDoc = ?, dia = ? "
                    + ", mes = ?, año = ?, especialidad = ?, nomHospital = ?"
                    + ", direHospital = ? WHERE idDoc = ?";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);
            estatuto.setInt(1, doctor.getIdDoc());
            estatuto.setString(2, doctor.getNombreDoc());
            estatuto.setString(3, doctor.getApPaDoc());
            estatuto.setString(4, doctor.getApMaDoc());
            estatuto.setString(5, doctor.getDia());
            estatuto.setString(6, doctor.getMes());
            estatuto.setString(7, doctor.getAño());
            estatuto.setString(8, doctor.getEspecialidad());
            estatuto.setString(9, doctor.getNomHospital());
            estatuto.setString(10, doctor.getDireHospital());
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

}
