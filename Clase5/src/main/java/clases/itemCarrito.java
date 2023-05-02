/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;


public class itemCarrito {
    public producto producto;
    int cant;

    public itemCarrito() {
    }

    public itemCarrito(producto producto, int cant) {
        this.producto = producto;
        this.cant = cant;
    }

    public producto getProducto() {
        return producto;
    }

    public int getCant() {
        return cant;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public String toString() {
        return "itemCarrito{" + "producto=" + producto + ", cant=" + cant + '}';
    }
    
    
}
