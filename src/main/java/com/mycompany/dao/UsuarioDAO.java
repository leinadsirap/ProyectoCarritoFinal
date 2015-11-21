/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;


import com.mycompany.model.Usuario;
import java.sql.PreparedStatement;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO extends DAO{
    public void registrar (Usuario user) throws Exception{
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO usuario (codigo,nomUsuario,clave) values(?,?,?)");
            st.setInt(1, user.getCodigo());
            st.setString(2, user.getNomUsuario());
            st.setString(3, user.getClave());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
    }
    
}
