/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clase6;

import newpackage.calculadora;

public class Clase6 {

    public static void main(String[] args) {
        calculadora calc = new calculadora();
        
        System.out.println("1. "+calc.multiplicar(80, 3));
        System.out.println("2. "+calc.dividir(calc.sumar(150, 180), 3));
        System.out.println("3. "+calc.multiplicar(calc.restar(90, 50), 15));
        System.out.println("4. "+calc.multiplicar(calc.sumar(70, 40), 25));
/*
        1. El resultado de multiplicar 80 por 3 da 240
        2. El resultado de sumar 150 y 180, dividido por 3, da 110
        3. El resultado de restar 90 y 50, multiplicado por 15, no da 605.
        4. El resultado de sumar 70 y 40, multiplicado por 25, no da 2700.
*/
    }
}
