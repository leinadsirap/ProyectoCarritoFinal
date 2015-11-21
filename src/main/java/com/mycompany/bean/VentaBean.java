/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.model.Carrito;
import com.mycompany.model.Producto;
import com.mycompany.model.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



@ManagedBean
@ViewScoped
public class VentaBean {
    
    
    private Venta venta = new Venta();
    private Producto producto = new Producto();
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   


    public List<Carrito> getLista() {
        return lista;
    }

    public void setLista(List<Carrito> lista) {
        this.lista = lista;
    }
    
    private List<Carrito> lista = new ArrayList();
    public Venta getVenta() {
        return venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public void agregarCarrito(){
     Carrito car = new Carrito();
      car.setCantidad(cantidad);
       car.setProducto(producto);
       this.lista.add(car);
       
    }
    
}
