/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author home
 */
public class Menu {
    int opcion;
    boolean error;

    public Menu() {
    }

    public Menu(int opcion) {
        this.opcion = opcion;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
    public void agregarAlumno() throws JsonProcessingException, SQLException {
        Alumno alumno = new Alumno();
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingrese el nombre del alumno");
        alumno.setNombre(scanner.nextLine().toLowerCase());
        
        String leg;
        do {            
            System.out.println("ingrese el numero de legajo");
            leg = scanner.nextLine();
        } while (!leg.matches("([0-9]{5})"));
        alumno.setLegajo(Integer.parseInt(leg));
        
        System.out.println("cuantas materias aprobadas tiene el alumno");
        this.error = true;
        int cant = 0;
        do{
            try {
                cant = scanner.nextInt();
                this.error = false;
            } catch (Exception e) {
                System.out.println("no ingresaste un numero");
                scanner.nextLine();
            }
        }while(this.error);
        scanner.nextLine(); // para limpiar el \n que quedo en el buffer
        
        for (int i = 0; i < cant; i++) {
            System.out.println("ingrese el nombre de la materia aprobada");
            alumno.materiasAprobadas.add(scanner.nextLine().toLowerCase());
        }
        try {
            alumno.guardarAlumno();
        } catch (JsonProcessingException | SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarAlumno() throws SQLException, IOException{
        Alumno alumno = new Alumno();
        Scanner scanner = new Scanner(System.in);
        
        String leg;
        do {            
            System.out.println("ingrese el numero de legajo del alumno que desea ver");
            leg = scanner.nextLine();
        } while (!leg.matches("([0-9]{5})"));
        
        try {
            if(alumno.leerAlumno(Integer.parseInt(leg)))
                System.out.println(alumno.toString()); 
            else
                System.out.println("ERROR: alumno no registrado");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void agregarMateria() throws JsonProcessingException, SQLException{
        Materia materia = new Materia();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ingrese el nombre de la materia");
        materia.setNombre(scanner.nextLine().toLowerCase());
        
        System.out.println("cuantas correlativas tiene la materia");
        this.error = true;
        int cant = 0;
        do{
            try {
                cant = scanner.nextInt();
                this.error = false;
            } catch (Exception e) {
                System.out.println("no ingresaste un numero");
                scanner.nextLine();
            }
        }while(this.error);
        scanner.nextLine(); // para limpiar el \n que quedo en el buffer
        
        for (int i = 0; i < cant; i++) {
            System.out.println("ingrese el nombre de la correlativa");
            materia.Correlativas.add(scanner.nextLine().toLowerCase());
        }
        try {
            materia.guardarMateria();
        } catch (JsonProcessingException | SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarMateria() throws SQLException, IOException{
        Materia materia = new Materia();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("ingrese el nombre de la materia que desea ver");
        try {
            if(materia.leerMateria(scanner.nextLine()))
                System.out.println(materia.toString()); 
            else
                System.out.println("ERROR: materia no registrada");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void comprobarInscripcion() throws SQLException, IOException{
        Scanner scanner = new Scanner(System.in);
        Inscripcion inscripcion = new Inscripcion(new Alumno(),new Materia());
        boolean resultadoAlumno = false;
        boolean resultadoMateria = false;
        
        String leg;
        do {            
            System.out.println("ingrese el numero de legajo del alumno");
            leg = scanner.nextLine();
        } while (!leg.matches("([0-9]{5})"));
        
        try {
            if(inscripcion.alumno.leerAlumno(Integer.parseInt(leg)))
                resultadoAlumno = true;
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("ingrese la materia a la que se desea inscribir");
        try {
            if(inscripcion.materia.leerMateria(scanner.nextLine().toLowerCase()))
                resultadoMateria = true;
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if(resultadoAlumno && resultadoMateria)
                inscripcion.validarInscripcion();
            else if(!resultadoAlumno && !resultadoMateria)
                System.out.println("ERROR: alumno no registrado y materia no registrada");
            else if(!resultadoAlumno)
                System.out.println("ERROR: alumno no registrado");
            else
                System.out.println("ERROR: materia no registrada");
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Menu() throws JsonProcessingException, SQLException, IOException{
        this.opcion = 0;
        do{
            System.out.println("*****Que accion desea realizar?*****");
            System.out.println("1 - Agregar Alumno a la base de datos");
            System.out.println("2 - Mostrar Alumno");
            System.out.println("3 - Agregar Materia a la base de datos");
            System.out.println("4 - Mostrar Materia");
            System.out.println("5 - Comprobar inscripcion");
            System.out.println("6 - Crear Tablas");
            System.out.println("7 - Cargar Tabla de Materias");
            System.out.println("0 - Salir");

            Scanner scanner = new Scanner(System.in);
            
            this.error = true;
            do{
                try {
                    this.opcion = scanner.nextInt();
                    this.error = false;
                } catch (Exception e) {
                    System.out.println("no ingresaste un numero");
                    scanner.next();
                }
            }while(this.error);
            
            
            switch (this.opcion) {
                case 1 -> {
                try {
                    agregarAlumno();
                } catch (JsonProcessingException | SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case 2 -> {
                try {
                    mostrarAlumno();
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case 3 -> {
                try {
                    agregarMateria();
                } catch (JsonProcessingException | SQLException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case 4 -> {
                try {
                    mostrarMateria();
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case 5 -> {
                try {
                    comprobarInscripcion();
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case 6 -> {
                    crearTablas();
                }
                case 7 -> {
                    cargarTablaMaterias();
                }
                default -> {
                }    
            }
        }while(this.opcion != 0);
    }
    
    public void crearTablas() throws SQLException{
        try {
            Conexion conexion = new Conexion();
            conexion.establecerConexion();
            Statement statement = conexion.conectar.createStatement();
            statement.executeUpdate("CREATE TABLE alumnos(nombre VARCHAR(50), legajo INT, aprobadas JSON, PRIMARY KEY(legajo));");
            statement.executeUpdate("CREATE TABLE materias(nombre VARCHAR(50), correlativas JSON, PRIMARY KEY(nombre));");
            statement.executeUpdate("CREATE TABLE inscripciones(nombre VARCHAR(50), materia VARCHAR(50), estado VARCHAR(50), fecha JSON);");
            conexion.cerrarConexion();
            System.out.println("Tablas Creadas Exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarTablaMaterias() throws SQLException, JsonProcessingException{ 
        ArrayList<Materia> materias = new ArrayList<>();
        
        materias.add(new Materia("ingles 1",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("ingles 2",new ArrayList<>(Arrays.asList("ingles 1"))));
        materias.add(new Materia("ingles 3",new ArrayList<>(Arrays.asList("ingles 2"))));
        materias.add(new Materia("ingles 4",new ArrayList<>(Arrays.asList("ingles 3"))));
        materias.add(new Materia("computacion 1",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("computacion 2",new ArrayList<>(Arrays.asList("computacion 1"))));
        materias.add(new Materia("analisis matematico 1",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("elementos de programacion",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("sistemas de representacion",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("tecnologia, ingenieria y sociedad",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("algebra y geometria analitica 1	",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("matematica discreta",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("quimica general	",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("fundamentos de tic",new ArrayList<>(Arrays.asList())));
        materias.add(new Materia("fisica 1",new ArrayList<>(Arrays.asList("analisis matematico 1"))));
        materias.add(new Materia("algebra y geometria analitica 2",new ArrayList<>(Arrays.asList("algebra y geometria analitica 1"))));
        materias.add(new Materia("analisis matematico 2",new ArrayList<>(Arrays.asList("analisis matematico 1"))));
        materias.add(new Materia("fisica 2",new ArrayList<>(Arrays.asList("fisica 1"))));
        materias.add(new Materia("requerimientos para la ingenieria",new ArrayList<>(Arrays.asList("fundamentos de tic"))));
        materias.add(new Materia("arquitectura de computadoras",new ArrayList<>(Arrays.asList("matematica discreta", "fundamentos de tic"))));
        materias.add(new Materia("programacion",new ArrayList<>(Arrays.asList("elementos de programacion", "matematica discreta"))));
        materias.add(new Materia("probabilidad y estadistica",new ArrayList<>(Arrays.asList("analisis matematico 2"))));
        materias.add(new Materia("auditoria y seguridad informatica",new ArrayList<>(Arrays.asList("tecnologia, ingenieria y sociedad", "arquitectura de computadoras"))));
        materias.add(new Materia("programación avanzada ",new ArrayList<>(Arrays.asList("analisis matematico 1", "programacion"))));
        materias.add(new Materia("base de datos",new ArrayList<>(Arrays.asList("matematica discreta", "analisis matematico 2"))));
        materias.add(new Materia("sistemas operativos",new ArrayList<>(Arrays.asList("arquitectura de computadoras", "programacion"))));
        materias.add(new Materia("analisis de sistemas",new ArrayList<>(Arrays.asList("matematica discreta", "requerimientos para la ingenieria"))));
        materias.add(new Materia("calculo numerico",new ArrayList<>(Arrays.asList("algebra y geometria analitica 2", "analisis matematico 2"))));
        materias.add(new Materia("ingenieria de requerimientos",new ArrayList<>(Arrays.asList("analisis de sistemas"))));
        materias.add(new Materia("comunicacion de datos",new ArrayList<>(Arrays.asList("arquitectura de computadoras", "sistemas operativos"))));
        materias.add(new Materia("diseño de sistemas",new ArrayList<>(Arrays.asList("analisis de sistemas"))));
        materias.add(new Materia("analisis de software",new ArrayList<>(Arrays.asList("programacion avanzada"))));
        materias.add(new Materia("redes de computadoras",new ArrayList<>(Arrays.asList("fisica 1", "comunicacion de datos"))));
        materias.add(new Materia("sistemas operativos avanzados",new ArrayList<>(Arrays.asList("programacion avanzada", "sistemas operativos"))));
        materias.add(new Materia("lenguajes y compiladores",new ArrayList<>(Arrays.asList("programacion", "sistemas operativos"))));
        materias.add(new Materia("gestion organizacional",new ArrayList<>(Arrays.asList("tecnologia, ingenieria y sociedad", "analisis de sistemas"))));
        materias.add(new Materia("ingenieria de software ",new ArrayList<>(Arrays.asList("sistemas de representacion", "quimica general", "fisica 2", "arquitectura de computadoras", "probabilidad y estadistica", "sistemas operativos", "calculo numerico", "diseño de sistemas"))));
        materias.add(new Materia("elementos de inteligencia artificial",new ArrayList<>(Arrays.asList("quimica general", "algebra y geometria analitica 2", "fisica 2", "probabilidad y estadistica", "sistemas operativos avanzados"))));
        materias.add(new Materia("electiva 1",new ArrayList<>(Arrays.asList("sistemas de representacion", "quimica general", "fisica 2", "probabilidad y estadistica", "sistemas operativos", "calculo numerico", "redes de computadoras"))));
        materias.add(new Materia("automatas y lenguajes formales",new ArrayList<>(Arrays.asList("sistemas de representacion", "quimica general", "algebra y geometria analitica 2", "fisica 2", "probabilidad y estadistica", "calculo numerico", "redes de computadoras"))));
        materias.add(new Materia("electiva 2",new ArrayList<>(Arrays.asList("sistemas de representacion", "quimica general", "fisica 2", "probabilidad y estadistica", "sistemas operativos", "calculo numerico", "redes de computadoras"))));
        materias.add(new Materia("electiva 3",new ArrayList<>(Arrays.asList("sistemas de representacion", "quimica general", "fisica 2", "probabilidad y estadistica", "sistemas operativos", "calculo numerico", "redes de computadoras"))));
        materias.add(new Materia("proyecto de fin de carrera",new ArrayList<>(Arrays.asList("sistemas operativos avanzados", "lenguajes y compiladores", "gestion organizacional", "ingenieria de software", "elementos de inteligencia artificial", "electiva 1", "automatas y lenguajes formales", "electiva 2", "electiva 3", "practica profesional supervisada", "fisica 2"))));
        materias.add(new Materia("practica profesional supervisada",new ArrayList<>(Arrays.asList("ingenieria de requerimientos", "comunicacion de datos", "diseño de sistemas", "analisis de software", "gestion organizacional"))));

        Conexion conexion = new Conexion();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        conexion.establecerConexion();
        
        try {
            Statement statement = conexion.conectar.createStatement();
            for (Materia materia : materias) {
                String jsonString = objectMapper.writeValueAsString(materia.Correlativas);
                statement.executeUpdate("INSERT INTO materias VALUES('"+materia.nombre+"', '"+ jsonString +"')");
            }
            conexion.cerrarConexion();
            System.out.println("Tabla de materias cargada exitosamente");
        } catch (SQLException | JsonProcessingException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}




