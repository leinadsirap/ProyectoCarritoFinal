/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dao.ProductoDAO;
import com.mycompany.dao.UsuarioDAO;
import com.mycompany.model.Producto;
import com.mycompany.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean

@ViewScoped
public class ProductoBean {
    private Producto producto = new Producto();
   
    private List<Producto> lstProducto;

    public List<Producto> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(List<Producto> lstProducto) {
        this.lstProducto = lstProducto;
    }

  
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public void registrar() throws Exception{
        
        ProductoDAO dao;
        UsuarioDAO daos;
        try {
            dao = new ProductoDAO();
           
            dao.registrar(producto);
          
            
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void listar() throws Exception{
        
        ProductoDAO dao;
      
        try {
            dao = new ProductoDAO();
      
            lstProducto = dao.listar();
          
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void leerID(Producto pro) throws Exception{
          ProductoDAO dao;
          Producto temp;
        try {
            dao = new ProductoDAO();
      
           temp = dao.leerId(pro);
          if(temp != null){
              this.producto = temp;
          }
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar() throws Exception{
        
        ProductoDAO dao;
        
        try {
            dao = new ProductoDAO();
          
            dao.modificar(producto);
            this.listar();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
       public void eliminar(Producto pro) throws Exception{
        
        ProductoDAO dao;
        
        try {
            dao = new ProductoDAO();
          
            dao.eliminar(pro);
            this.listar();
            
        } catch (Exception e) {
            throw e;
        }
    }
}
