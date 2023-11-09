/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase3;

import java.util.Scanner;

/**
 *
 * @author Chicho
 */
public class Clase3 {

    public static void main(String[] args) {
        
        String cadena="hola que tal";
        char letra='a';
        int numeros[]={8,9,4};
        int orden=1, cont=0, aux, pos=0, num, desplazamiento=2; //1=ascendente 2=descendente
        char abecedario[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',' '};
        char vector[]=new char[cadena.length()];

        // 1a)
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) == letra)
                cont++;
        }
        System.out.println("la letra aparece "+cont+" veces");

        // 1b)
        for(int i=0; i<numeros.length; i++){
            num=numeros[i];
            for(int j=i; j<numeros.length; j++){
                if(numeros[j]<num && orden == 1 || numeros[j]>num && orden == 2){
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
        for(int i=0; i<numeros.length;i++)
            System.out.println(numeros[i]);

        // 1c)
        num=5;
        aux=0;
        for(int i=0;i<numeros.length;i++){
            if(numeros[i]>num)
                aux+=numeros[i];
        }
        System.out.println("la suma total es: "+aux);

        // 2)
        vector=cadena.toCharArray();

        for(int i=0;i<vector.length ;i++){
           for(int j=0;j<abecedario.length;j++){
               if(vector[i]==abecedario[j])
                   pos=j;
           }
           if(pos+desplazamiento < abecedario.length)
               vector[i]=abecedario[pos+desplazamiento];
           else
               vector[i]=abecedario[pos+desplazamiento-abecedario.length];    
        }
        cadena=String.valueOf(vector);
        System.out.println(cadena);
    }
}