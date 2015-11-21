/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;




public class Venta {
    
    private int codigo;
    private Persona persona;
    private int monto;

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

 
    
}
