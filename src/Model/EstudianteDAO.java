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
public class EstudianteDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addPerson(EstudianteVO estudiante) {

        try {
            est = conex.getConnection().prepareStatement("INSERT"
                    + " INTO Estudiante VALUES (?,?,?,?,?,?,?,?,?)");
            est.setString(1, estudiante.getNombreEstu());
            est.setString(2, estudiante.getApPaEstu());
            est.setString(3, estudiante.getApMaEstu());
            est.setString(4, estudiante.getLuNac());
            est.setString(5, estudiante.getDia());
            est.setString(6, estudiante.getMes());
            est.setString(7, estudiante.getAño());
            est.setString(8, estudiante.getCarrera());
            est.setString(9, estudiante.getEmail());
            est.executeUpdate();
            est.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n" + e);
        }
    }

    public EstudianteVO buscarPersona(int codigo) {
        Connection conex = new Connection();
        EstudianteVO personFound = new EstudianteVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Estudiante where idEstu = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
                personFound.setIdEstu(Integer.parseInt(res.getString("idEstu")));
                personFound.setNombreEstu(res.getString("nombreEstu"));
                personFound.setApPaEstu(res.getString("ApPaEstu"));
                personFound.setApMaEstu(res.getString("ApMaEstu"));
                personFound.setLuNac(res.getString("ApMaEstu"));
                personFound.setDia(res.getString("dia"));
                personFound.setMes(res.getString("mes"));
                personFound.setAño(res.getString("año"));
                personFound.setCarrera(res.getString("carrera"));
                personFound.setEmail(res.getString("email"));
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

            est = conex.getConnection().prepareStatement("DELETE FROM Estudiante "
                    + "WHERE idEstu = ?");
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

    public void modificarPersona(EstudianteVO estudiante) {
        try {
            String consulta = "UPDATE Estudiante SET idEstu= ? "
                    + ",nombreEstu = ? , apPaEstu=? , apMaEstu=? , luNac=? "
                    + ", dia= ? , mes= ?, año= ? , carrera= ? , email=? WHERE idEstu=? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, estudiante.getIdEstu());
            estatuto.setString(2, estudiante.getNombreEstu());
            estatuto.setString(3, estudiante.getApPaEstu());
            estatuto.setString(4, estudiante.getApMaEstu());
            estatuto.setString(5, estudiante.getLuNac());
            estatuto.setString(6, estudiante.getDia());
            estatuto.setString(7, estudiante.getMes());
            estatuto.setString(8, estudiante.getAño());
            estatuto.setString(9, estudiante.getCarrera());
            estatuto.setString(10, estudiante.getEmail());
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

}
