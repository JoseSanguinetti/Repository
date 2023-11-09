/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public abstract class descuento {
    private float valor;

    public descuento() {
    }

    public descuento(float valor) {
        this.valor = valor;
    }
    
    public float getValorDesc() {
        return valor;
    }

    public void setValorDesc(float valor) {
        this.valor = valor;
    }
    
    public abstract float valorFinal(float valorInicial);
}
