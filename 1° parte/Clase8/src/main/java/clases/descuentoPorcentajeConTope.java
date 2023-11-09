/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class descuentoPorcentajeConTope extends descuento{
    float tope;

    public descuentoPorcentajeConTope() {
    }

    public descuentoPorcentajeConTope(float valor) {
        super(valor);
        this.tope = 70; //tope fijo
    }
    
    @Override
    public float valorFinal(float valorInicial){
        if(valorInicial/100 * this.getValorDesc() > tope)
            return valorInicial - tope;
        else
            return valorInicial - (valorInicial/100 * this.getValorDesc());
    }
}
