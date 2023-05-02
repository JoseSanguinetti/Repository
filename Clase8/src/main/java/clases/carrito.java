/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

public class carrito {
    private List<itemCarrito> items;
    public descuento desc;
    public char tipoDesc; // f=FIJO p=PORCENTAJE t=TOPE
    

    public carrito() {
    }  


    public carrito(descuento desc) {
        this.items = new ArrayList<itemCarrito>();
        this.desc = desc;
    }
    
    public carrito(float desc, char tipo) { //tipoDesc F=fijo P=porcentaje T=porcentaje con tope
        this.items = new ArrayList<itemCarrito>();
        switch (tipo) {
            case 'f':
                this.desc = new descuentoFijo(desc);
                break;
            case 'p':
                this.desc = new descuentoPorcentaje(desc);
                break;
            case 't':
                this.desc = new descuentoPorcentajeConTope(desc);
                break;
            default:
                break;
        }
        
        this.tipoDesc = tipo;
    }

    public List<itemCarrito> getItems() {
        return items;
    }

    public descuento getDesc() {
        return desc;
    }
    
    public char getTipoDesc() {
        return tipoDesc;
    }
    
    public void setItems(List<itemCarrito> items) {
        this.items = items;
    }

    public void setDesc(descuento desc) {
        this.desc = desc;
    }

    public void setTipoDesc(char tipoDesc) {
        this.tipoDesc = tipoDesc;
    }

    @Override
    public String toString() {
        return "carrito{" + "items=" + items + ", desc=" + desc + ", tipoDesc=" + tipoDesc + '}';
    }
    
    public float precio(){
        int acum=0;
        
        for (itemCarrito item : items) {
            acum+=item.cant*item.producto.precio;
        }
        if(desc != null)
            return desc.valorFinal(acum);
        return acum;
    }
    
    public void imprimirTicket(){
        System.out.println("Cant \tPrecio \tProducto");
        for (itemCarrito item: this.items )  {
            System.out.println(item.cant+"\t"+item.producto.precio+"\t"+item.producto.nombre);
        }
        System.out.println("Precio Total: "+precio());
    }
  
    public void agregarItem(String nombre, String precio, String cantidad){ //recibe los 3 parametros y los agrega a la lista
        items.add(new itemCarrito(new producto(nombre,Integer.parseInt(precio)), Integer.parseInt(cantidad)));
    }
}