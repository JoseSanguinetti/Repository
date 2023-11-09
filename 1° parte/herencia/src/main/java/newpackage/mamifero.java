/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author Chicho
 */
public abstract class mamifero {
    String dieta;

    public mamifero() {
    }

    public mamifero(String dieta) {
        this.dieta = dieta;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return "mamifero{" + "dieta=" + dieta + '}';
    }
    
    public abstract void accionMamifera();
}
