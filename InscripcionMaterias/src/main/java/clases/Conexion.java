/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chicho
 */
public class Conexion {
    public Connection conectar = null;
    String usuario = "root";
    String contraseña = "root";
    String baseDatos = "inscripcion";
    String ip = "localhost";
    String puerto = "3306";

    String ruta = "jdbc:mysql://" + ip + ":" + puerto + "/" + baseDatos;

    public Connection establecerConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(ruta, usuario, contraseña);
            //System.out.println("Se conecto correctamente");
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO se conecto correctamente" + e);
        }
        return conectar;
    }

    public void cerrarConexion() throws SQLException {
        try {
            conectar.close();
        } catch (Exception e) {
        }
    }
}