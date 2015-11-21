/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProductoDAO extends DAO{
    public void registrar (Producto pro) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO producto (codigo,nombre,precio) values(?,?,?)");
            st.setInt(1, pro.getCodigo());
            st.setString(2, pro.getNombre());
            st.setInt(3, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Producto> listar() throws Exception{
        
        List<Producto> lista;
        ResultSet rs;
         
            
        try {
               this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT codigo, nombre, precio FROM Producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Producto per = new Producto();
        
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setPrecio(rs.getInt("precio"));
               
                
                lista.add(per);
             
            }   
        } catch (Exception e) {
            throw  e;
        }finally{
            this.Cerrar();
        }
        return  lista;
    }
    
    public Producto leerId(Producto per) throws Exception{
        
        Producto pers = null;
        ResultSet rs;
         try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo,nombre,precio FROM Producto Where codigo = ?");
            st.setInt(1, per.getCodigo());
   
           rs = st.executeQuery();
           while(rs.next()){
               pers = new Producto();
               pers.setCodigo(rs.getInt("Codigo"));
               pers.setNombre(rs.getString("nombre"));
               pers.setPrecio(rs.getInt("precio"));
           }
               
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
         return pers;
    }
    
     public void modificar (Producto pro) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Producto SET codigo = ?, nombre = ?, precio = ? WHERE codigo = ? ");
            st.setInt(1, pro.getCodigo());
            st.setString(2, pro.getNombre());
            st.setInt(3, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
     
         public void eliminar (Producto per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Producto WHERE codigo = ? ");
            st.setInt(1, per.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
     
     
    
}
