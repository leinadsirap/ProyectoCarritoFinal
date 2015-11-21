/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.model.Persona;
import com.mycompany.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class PersonaDAO extends DAO{
    public void registrar (Persona per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO persona (codigo,nombre,sexo) values(?,?,?)");
            st.setInt(1, per.getCodigo());
            st.setString(2, per.getNombre());
            st.setString(3, per.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
    public List<Persona> listar() throws Exception{
        
        List<Persona> lista;
        ResultSet rs;
         
            
        try {
               this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT codigo, nombre, sexo FROM Persona");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                Usuario user = new Usuario();
                per.setCodigo(rs.getInt("codigo"));
                per.setNombre(rs.getString("nombre"));
                per.setSexo(rs.getString("sexo"));
               
                
                lista.add(per);
             
            }   
        } catch (Exception e) {
            throw  e;
        }finally{
            this.Cerrar();
        }
        return  lista;
    }
    
    public Persona leerId(Persona per) throws Exception{
        
        Persona pers = null;
        ResultSet rs;
         try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo,nombre,sexo FROM Persona Where codigo = ?");
            st.setInt(1, per.getCodigo());
   
           rs = st.executeQuery();
           while(rs.next()){
               pers = new Persona();
               pers.setCodigo(rs.getInt("Codigo"));
               pers.setNombre(rs.getString("nombre"));
               pers.setSexo(rs.getString("sexo"));
           }
               
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
         return pers;
    }
    
     public void modificar (Persona per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Persona SET codigo = ?, nombre = ?, sexo = ? WHERE codigo = ? ");
            st.setInt(1, per.getCodigo());
            st.setString(2, per.getNombre());
            st.setString(3, per.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
     
         public void eliminar (Persona per) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM Persona WHERE codigo = ? ");
            st.setInt(1, per.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
     
     
    
}
