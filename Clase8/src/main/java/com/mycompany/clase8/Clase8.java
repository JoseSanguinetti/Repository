/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase8;

import clases.carrito;
import clases.descuentoPorcentajeConTope;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Clase8 {
    
    public static void main(String[] args) throws IOException {
        carrito carro = new carrito(50,'p'); //valor del descuento y tope del descuento
        String[] partes; // para separar la linea leida del archivo
        int cont=0;
        Scanner sc = new Scanner(new File("venta.txt")); //scanner para leer el archivo linea por linea

	while (sc.hasNextLine()) { //mientras tenga proxima linea
            partes=sc.nextLine().split(","); // leo la linea y la separo en un vector [0]=nombre [1]=precio [2]=cantidad
            carro.agregarItem(partes[0],partes[1],partes[2]); //paso los parametros para agregarlos a la lista
            cont++;
        }    
        carro.imprimirTicket();
    }
}
