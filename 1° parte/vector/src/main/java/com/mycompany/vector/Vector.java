/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Chicho
 */
public class Vector {

    public static void main(String[] args) throws IOException {
        String[] array = crearVector();
        mostrarVector(array);
    }
    
    
    public static String[] crearVector (){
    Scanner sc = new Scanner(System.in);
    System.out.println("ingrese el tamaño del array");
    int input = sc.nextInt();
    
    String[] nuevo = new String[input];
    
    for(int i = 0; i < nuevo.length; i++){
        System.out.println("ingrese lo que quiere escribir en la posicion " + i);
        nuevo[i] = sc.next();
    }
    return nuevo;
    
    }
    
    public static void mostrarVector(String[] vector){
        for (String posicion : vector) {
            System.out.println(posicion);
        }
    }
}
