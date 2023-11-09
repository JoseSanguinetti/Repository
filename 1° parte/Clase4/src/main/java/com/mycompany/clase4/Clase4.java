/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Chicho
 */
public class Clase4 {

    public static void main(String[] args) throws IOException {
        //ordenarNumeros(3,1, 2,'a');
        //ordenarNumeros2();
        //ordenarNumeros3();
        //sumaNumerosArchivo("numeros.txt", 'm');// s=sumar m=multiplicar
        //codificadorDecodificador( 2, 'c'); // d= decodificar c=codificar
    }
    
    //1a)
    public static void ordenarNumeros(int num1, int num2, int num3, char orden){ //orden a=ascendente d=descendente
        int aux, num, pos=0;
        int numeros[]={num1,num2,num3};
       
        for(int i=0; i<numeros.length; i++){
            num=numeros[i];
            for(int j=i; j<numeros.length; j++){
                if(numeros[j]<num && orden == 'a' || numeros[j]>num && orden == 'd'){
                    num=numeros[j];
                    pos=j;
                }
            }
            if(numeros[i]!= num){
                aux=numeros[i];
                numeros[i]=num;
                numeros[pos]=aux;
            }
        }
        for(int i=0; i<numeros.length; i++)
            System.out.println(numeros[i]);
    }
    
    //1b)
    public static void ordenarNumeros2(){ //orden a=ascendente d=descendente
        int aux, menor, pos=0;
        int numeros[]=new int [3];
        char orden;
        
        Scanner sc= new Scanner(System.in);

        for(int i=0; i<numeros.length; i++){
            System.out.println("ingrese el numero que desea guardar en la posicion "+i);
            numeros[i] = sc.nextInt();
        }
        do{
            System.out.println("ingrese 'a' para orden ascendente o 'd' para orden descendente");
            orden = sc.next().charAt(0);
            if(orden != 'a' && orden != 'd')
                System.out.println("ERROR: el caracater ingresado no es valido, vuelva a intentar.");
        }while(orden != 'a' && orden != 'd');
        
        for(int i=0; i<numeros.length; i++){
            menor=numeros[i];
            for(int j=i; j<numeros.length; j++){
                if(numeros[j]<menor && orden == 'a' || numeros[j]>menor && orden == 'd'){
                    menor=numeros[j];
                    pos=j;
                }
            }
            if(numeros[i]!= menor){
                aux=numeros[i];
                numeros[i]=menor;
                numeros[pos]=aux;
            }
        }
        for(int i=0; i<numeros.length; i++)
            System.out.println(numeros[i]);
    }
    
    //1c)
    public static void ordenarNumeros3(){
        int numeros[]={-1,-1,-1}; // -1 significa que no hay dato
        char orden=' '; // ' ' significa que no hay dato
        
        if(orden == ' ' && numeros[0] == -1 && numeros[1] == -1 && numeros[2] == -1)
            ordenarNumeros2();
        else
            ordenarNumeros(numeros[0], numeros[1], numeros[2], orden);
        
    }
    
    //2a)
    public static void sumaNumerosArchivo(String ruta, char operacion) throws IOException{
        Path archivotxt=Paths.get(ruta);
        int suma=0,prod=1;
        
        for(String numero: Files.readAllLines(archivotxt)){
            if(operacion == 's')
                suma+=Integer.parseInt(numero);
            if(operacion == 'm'){
                prod*=Integer.parseInt(numero);
            }
        }
        if(operacion == 's')
            System.out.println("la suma da "+suma);
        if(operacion == 'm')
            System.out.println("el producto da "+prod);
    }
    
    //3)
    public static void codificadorDecodificador(int desplazamiento, char deco) throws IOException{ // d= decodificar c=codificar
        int pos=0;
        char abecedario[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',' '};
        String rutaEntrada = "entrada.txt";
        String rutaSalida = "salida.txt";
        String cadena="";
        
        Path entrada = Paths.get(rutaEntrada);
        
        for(String linea: Files.readAllLines(entrada)) //leo la linea del archivo y la guardo en la cadena
            cadena = linea;
        
        char vector[]=new char[cadena.length()];
        vector=cadena.toCharArray(); //paso la cadena al vector para trabajarlo
        
        for(int i=0;i<vector.length ;i++){ //encuentro la letra en el vector abecedario y guardo la posicion en la que se encuentra
           for(int j=0;j<abecedario.length;j++){
               if(vector[i]==abecedario[j])
                   pos=j;
           }
           if(deco == 'c'){
               if(pos+desplazamiento < abecedario.length)
                    vector[i]=abecedario[pos+desplazamiento];
               else
                    vector[i]=abecedario[pos+desplazamiento-abecedario.length];
           }
           if(deco == 'd'){
               if(pos-desplazamiento >= 0)
                    vector[i]=abecedario[pos-desplazamiento];
               else
                    vector[i]=abecedario[pos-desplazamiento+abecedario.length];
           }
               
        }
        cadena=String.valueOf(vector); //paso el vector de nuevo a la cadena
        Files.writeString(Paths.get(rutaSalida ), cadena ); //guardo la cadena en el archivo
        
        System.out.println("la codificacion/decodificacion se realizo correctamente");
    }
}
