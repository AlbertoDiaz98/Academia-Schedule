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
public class LicenciadoDAO {

    Connection conex = new Connection();
    PreparedStatement est;

    public void addPerson(LicenciadoVO licenciado) {

        try {
            est = conex.getConnection().prepareStatement("INSERT"
                    + " INTO Licenciado VALUES (?,?,?,?,?,?,?,?,?)");
            est.setString(1, licenciado.getNombreLic());
            est.setString(2, licenciado.getApPaLic());
            est.setString(3, licenciado.getApMaLic());
            est.setString(4, licenciado.getTelOfi());
            est.setString(5, licenciado.getHrsAten());
            est.executeUpdate();
            est.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al registrar: \n" + e);
        }
    }

    public LicenciadoVO buscarPersona(int codigo) {
        Connection conex = new Connection();
        LicenciadoVO personFound = new LicenciadoVO();
        boolean existe = false;
        try {
            PreparedStatement consulta;
            consulta = conex.getConnection().prepareStatement(
                    "SELECT * FROM Licenciado where idLic = ? ");
            consulta.setInt(1, codigo);
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                existe = true;
                personFound.setIdLic(Integer.parseInt(res.getString("idEstu")));
                personFound.setNombreLic(res.getString("nombreEstu"));
                personFound.setApPaLic(res.getString("ApPaEstu"));
                personFound.setApMaLic(res.getString("ApMaEstu"));
                personFound.setTelOfi(res.getString("telOfi"));
                personFound.setHrsAten(res.getString("hrsAten"));
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

            est = conex.getConnection().prepareStatement("DELETE FROM Licenciado "
                    + "WHERE idLic = ?");
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

    public void modificarPersona(LicenciadoVO licenciado) {
        try {
            String consulta = "UPDATE Licenciado SET idLic= ? "
                    + ",nombreLic = ? , apPaLic=? , apMaLic=? , telOfi=? "
                    + ", hrsAten= ? WHERE idLic=? ";
            PreparedStatement estatuto;
            estatuto = conex.getConnection().prepareStatement(consulta);

            estatuto.setInt(1, licenciado.getIdLic());
            estatuto.setString(2, licenciado.getNombreLic());
            estatuto.setString(3, licenciado.getApPaLic());
            estatuto.setString(4, licenciado.getApMaLic());
            estatuto.setString(5, licenciado.getTelOfi());
            estatuto.setString(6, licenciado.getHrsAten());
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
