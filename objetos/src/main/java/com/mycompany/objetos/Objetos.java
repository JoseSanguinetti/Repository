/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.objetos;

import clases.fecha;
import clases.persona;
import java.util.Scanner;

/**
 *
 * @author Chicho
 */
public class Objetos {

    public static void main(String[] args) {
        persona yo = new persona("jose","sanguinetti","marron","verde",187,85,new fecha(13,02,90));
        
        persona otraPersona=crearPersona();
        
        System.out.println(yo.toString());
        System.out.println(otraPersona.toString());
    }
    
    public static persona crearPersona(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ingrese el nombre de la persona");
        String nombre = sc.next();
        System.out.println("ingrese el apellido de la persona");
        String apellido = sc.next();
        System.out.println("ingrese el color de pelo de la persona");
        String colorPelo = sc.next();
        System.out.println("ingrese el color de ojos de la persona");
        String colorOjos = sc.next();
        System.out.println("ingrese la altura de la persona");
        int altura = sc.nextInt();
        System.out.println("ingrese el peso de la persona");
        int peso = sc.nextInt();
        System.out.println("ingrese fecha de nacimiento (dia mes año)");
        fecha fec = new fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
        
        return new persona(nombre,apellido,colorPelo,colorOjos,altura,peso,fec);
    }
}
