/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

public class carrito {
    public itemCarrito items[] = new itemCarrito[3] ;
    public descuento desc;
    public char tipoDesc; // f=FIJO p=PORCENTAJE t=TOPE
    

    public carrito() {
    }  


    public carrito(descuento desc) {
        this.desc = desc;
    }
    
    public carrito(float desc, char tipo) { //tipoDesc F=fijo P=porcentaje T=porcentaje con tope
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
   
    public char getTipoDesc() {
        return tipoDesc;
    }

    public carrito(itemCarrito[] items) {
        this.items = items;
    }

    public itemCarrito[] getItems() {
        return items;
    }

    public descuento getDesc() {
        return desc;
    }

    public void setItems(itemCarrito[] items) {
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
        return "carritoVector{" + "items=" + items + '}';
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
        for (int i = 0; i < 3; i++) {
            System.out.println(items[i].cant+"\t"+items[i].producto.precio+"\t"+items[i].producto.nombre);
        }
        System.out.println("Precio Total: "+precio());
    }
  
    public itemCarrito crearItemCarrito(String nombre, String precio, String cantidad){ //recibe los 3 parametros y los devuelve como un itemcarrito
        // Creo un itemCarrito y lo cargo con los datos, luego lo devuelvo
        itemCarrito item = new itemCarrito(new producto(nombre,Integer.parseInt(precio)),Integer.parseInt(cantidad));

        return item;
    }
}