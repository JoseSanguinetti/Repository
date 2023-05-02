/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase5;

import clases.carrito;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Clase5 {

    public static void main(String[] args) throws IOException {
        carrito carro = new carrito();
        String[] partes; // para splitear la linea leida del archivo
        int cont=0;
        Scanner sc = new Scanner(new File("venta.txt")); //scanner para leer el archivo linea por linea
        
	while (sc.hasNextLine()) { //mientras tenga proxima linea
            partes=sc.nextLine().split(","); // leo la linea y la separo en un vector [0]=nombre [1]=precio [2]=cantidad
            carro.agregarItem(carro.crearItemCarrito(partes[0],partes[1],partes[2]), cont); //creo un item y lo agrego en el indice "cont"
            cont++;
        }
        carro.imprimirTicket();
    }
}
