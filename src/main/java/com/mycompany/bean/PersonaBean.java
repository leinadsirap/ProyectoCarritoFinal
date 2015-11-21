/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bean;

import com.mycompany.dao.PersonaDAO;
import com.mycompany.dao.UsuarioDAO;
import com.mycompany.model.Persona;
import com.mycompany.model.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PersonaBean {
    private Persona persona = new Persona();
    private Usuario user = new Usuario();
    private List<Persona> lstPersona;

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public void registrar() throws Exception{
        
        PersonaDAO dao;
        UsuarioDAO daos;
        try {
            dao = new PersonaDAO();
            daos = new UsuarioDAO();
            dao.registrar(persona);
            daos.registrar(user);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
     public void listar() throws Exception{
        
        PersonaDAO dao;
        UsuarioDAO daos;
        try {
            dao = new PersonaDAO();
      
            lstPersona = dao.listar();
          
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void leerID(Persona per) throws Exception{
          PersonaDAO dao;
          Persona temp;
        try {
            dao = new PersonaDAO();
      
           temp = dao.leerId(per);
          if(temp != null){
              this.persona = temp;
          }
            
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar() throws Exception{
        
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
          
            dao.modificar(persona);
            this.listar();
            
        } catch (Exception e) {
            throw e;
        }
    }
    
       public void eliminar(Persona per) throws Exception{
        
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
          
            dao.eliminar(per);
            this.listar();
            
        } catch (Exception e) {
            throw e;
        }
    }
}
