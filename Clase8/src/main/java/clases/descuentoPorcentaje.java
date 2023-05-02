/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class descuentoPorcentaje extends descuento{

    public descuentoPorcentaje() {
    }
    
    public descuentoPorcentaje(float valor) {
        super(valor);
    }
    
    @Override
    public float valorFinal(float valorInicial) {
        return valorInicial - (valorInicial/100 * this.getValorDesc());
    }
}
