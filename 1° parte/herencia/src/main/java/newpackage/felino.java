/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

public class felino extends mamifero{
    String nombre;
    String color;

    public felino() {
    }

    public felino(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public felino(String nombre, String color, String dieta) {
        super(dieta);
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public String getDieta() {
        return dieta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return "felino{" + "nombre=" + nombre + ", color=" + color + '}';
    }

   
    @Override
    public void accionMamifera() {
        System.out.println("MIAU!");
    }
    
    
}
