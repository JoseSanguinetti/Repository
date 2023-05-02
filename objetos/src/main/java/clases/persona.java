/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Chicho
 */
public class persona {
    String nombre;
    String apellido;
    String colorPelo;
    String colorOjos;
    int altura;
    int peso;
    fecha nacimiento;

    public persona() {
    }

    public persona(String nombre, String apellido, String colorPelo, String colorOjos, int altura, int peso, fecha nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.colorPelo = colorPelo;
        this.colorOjos = colorOjos;
        this.altura = altura;
        this.peso = peso;
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public String getColorOjos() {
        return colorOjos;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public fecha getNacimiento() {
        return nacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public void setColorOjos(String colorOjos) {
        this.colorOjos = colorOjos;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setNacimiento(fecha nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", colorPelo=" + colorPelo + ", colorOjos=" + colorOjos + ", altura=" + altura + ", peso=" + peso + ", nacimiento=" + nacimiento + '}';
    }
    
}
