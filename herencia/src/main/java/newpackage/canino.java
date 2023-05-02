/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

public class canino extends mamifero{
    String nombre;
    String color;

    public canino() {
    }

    public canino(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public canino(String nombre, String color, String dieta) {
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

    @Override
    public String getDieta() {
        return dieta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
    
    public void accionMamifera(){
        System.out.println("WOOF!");
    }
    
}
