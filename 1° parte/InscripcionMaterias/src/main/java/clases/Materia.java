/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chicho
 */
public class Materia {
    public String nombre;
    public ArrayList<String> Correlativas = new ArrayList<>();

    public Materia() {
    }
    
    public Materia(String nombre) {
        this.nombre = nombre;
        this.Correlativas = new ArrayList<>();
    }

    public Materia(String nombre, ArrayList<String> Correlativas) {
        this.nombre = nombre;
        this.Correlativas = Correlativas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getCorrelativas() {
        return Correlativas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorrelativas(ArrayList<String> Correlativas) {
        this.Correlativas = Correlativas;
    }

    @Override
    public String toString() {
        return "Materia{" + "nombre=" + nombre + ", Correlativas=" + Correlativas + '}';
    }
    
    public void guardarMateria() throws JsonProcessingException, SQLException{
        try {
            Conexion conexion = new Conexion();
            ObjectMapper objectMapper = new ObjectMapper();
            
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            String jsonString = objectMapper.writeValueAsString(this.Correlativas);
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            statement.executeUpdate("INSERT INTO materias VALUES('"+this.nombre+"', '"+ jsonString +"')");
            
            conexion.cerrarConexion();
            
            System.out.println("Materia guardada exitosamente");
            
        } catch (JsonProcessingException | SQLException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean leerMateria(String nombre) throws SQLException, IOException{
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            ObjectMapper objectMapper = new ObjectMapper();
            
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM materias WHERE nombre=\""+nombre+"\"");
            if (resultSet.next() == false) { //si resultset es false quiere decir que el select no encontro el dato
                resultado = false;
            } else {
                this.nombre = resultSet.getString("nombre");
                this.Correlativas = objectMapper.readValue(resultSet.getString("correlativas"), ArrayList.class);
                resultado = true;
            }
            conexion.cerrarConexion();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Materia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
