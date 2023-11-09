/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.herencia;

import newpackage.canino;
import newpackage.felino;
import newpackage.mamifero;
import newpackage.pruebaInterface;

public class Herencia {

    public static void main(String[] args) {
        canino perro = new canino("pompi","blanco","deTodo");
        felino gato = new felino("noah","gris","deTodo");
        
        pruebaInterface inter = new pruebaInterface();
        
        inter.saludo();
        
        perro.accionMamifera();// polimorfismo, con el mismo metodo (heredado) las 2 clases hacen diferentes cosas
        gato.accionMamifera();
    }
}
