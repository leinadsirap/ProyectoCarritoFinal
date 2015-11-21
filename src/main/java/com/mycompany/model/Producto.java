/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;


public class Producto {
    
    private int codigo;
    private String nombre;
    private int precio;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + '}';
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
