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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chicho
 */
public class Alumno {
    public String nombre;
    public int legajo;
    public ArrayList<String> materiasAprobadas= new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<>();
    }
    
    public Alumno(String nombre, int legajo, ArrayList<String> materiasAprobadas) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.materiasAprobadas = materiasAprobadas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public List<String> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void setMateriasAprobadas(ArrayList<String> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", legajo=" + legajo + ", materiasAprobadas=" + materiasAprobadas + '}';
    }

    public void guardarAlumno()  throws JsonProcessingException, SQLException{
        try {
            Conexion conexion = new Conexion();
            ObjectMapper objectMapper = new ObjectMapper();
            
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            String jsonString = objectMapper.writeValueAsString(this.materiasAprobadas);
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            statement.executeUpdate("INSERT INTO alumnos VALUES('"+this.nombre+"', "+this.legajo+", '"+ jsonString +"')");
            
            conexion.cerrarConexion();
            
            System.out.println("Alumno guardado exitosamente");
            
        } catch (JsonProcessingException | SQLException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean leerAlumno(int legajo) throws SQLException, IOException{
        boolean resultado = false;
        try {
            Conexion conexion = new Conexion();
            ObjectMapper objectMapper = new ObjectMapper();
            
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos WHERE legajo=\""+legajo+"\"");
            if (resultSet.next() == false) { //si resultset es false quiere decir que el select no encontro el dato
                resultado = false;
            } else {
                this.nombre=resultSet.getString("nombre");
                this.legajo=resultSet.getInt("legajo");
                this.materiasAprobadas=objectMapper.readValue(resultSet.getString("aprobadas"), ArrayList.class);
                resultado = true;
            }
            conexion.cerrarConexion();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }    
}
