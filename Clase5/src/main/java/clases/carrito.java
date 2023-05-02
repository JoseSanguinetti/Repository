/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class carrito {
    public itemCarrito items[] = new itemCarrito[3] ;

    public carrito() {
    }

    public carrito(itemCarrito[] items) {
        this.items = items;
    }

    public itemCarrito[] getItems() {
        return items;
    }

    public void setItems(itemCarrito[] items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "carritoVector{" + "items=" + items + '}';
    }
    
    public int precio(){
        int acum=0;
        
        for (itemCarrito item : items) {
            acum+=item.cant*item.producto.precio;
        }
        return acum;
    }
    
    public void agregarItem(itemCarrito item, int indice) {
        this.items[indice] = item;
    }
    
    public void imprimirTicket(){
        System.out.println("Cant \tPrecio \tProducto");
        for (int i = 0; i < 3; i++) {
            System.out.println(items[i].cant+"\t"+items[i].producto.precio+"\t"+items[i].producto.nombre);
        }
        System.out.println("Precio Total: "+precio());
    }
    public itemCarrito crearItemCarrito(String nombre, String precio, String cantidad){
        // Creo un itemCarrito y lo cargo con los datos, luego lo devuelvo
        itemCarrito item = new itemCarrito(new producto(nombre,Integer.parseInt(precio)),Integer.parseInt(cantidad));

        return item;
    }
}