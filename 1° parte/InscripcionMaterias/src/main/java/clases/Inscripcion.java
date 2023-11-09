/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chicho
 */
public class Inscripcion {
    Alumno alumno;
    Materia materia;
    Date fecha = new Date();

    public Inscripcion() {
    }

    public Inscripcion(Alumno alumno, Materia materia) {
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = new Date();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "alumno=" + alumno + ", materia=" + materia + ", fecha=" + fecha + '}';
    }
    
    public void validarInscripcion() throws SQLException{
        try {
            Conexion conexion = new Conexion();
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonFecha = objectMapper.writeValueAsString(formatter.format(this.fecha));
            
            if(alumno.materiasAprobadas.indexOf(materia.nombre) >= 0){ 
                //si es mayor o igual a 0 la materia fue encontrada en la lista de materias aprobadas, si es negativo no se encontro.
                statement.executeUpdate("INSERT INTO inscripciones VALUES('"+this.alumno.nombre+"', '"+this.materia.nombre+"', '"+ "Error: materia ya aprobada" +"', '"+ jsonFecha +"')");
                System.out.println("error materia ya aprobada");
            }else if(alumno.getMateriasAprobadas().containsAll(materia.getCorrelativas())){
                statement.executeUpdate("INSERT INTO inscripciones VALUES('"+this.alumno.nombre+"', '"+this.materia.nombre+"', '"+ "Aprobada" +"', '"+ jsonFecha +"')");
                System.out.println("inscripcion valida");
            }else{
                statement.executeUpdate("INSERT INTO inscripciones VALUES('"+this.alumno.nombre+"', '"+this.materia.nombre+"', '"+ "Rechazada" +"', '"+ jsonFecha +"')");
                System.out.println("inscripcion Rechazada");
            }
            conexion.cerrarConexion();
        } catch (SQLException | JsonProcessingException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
