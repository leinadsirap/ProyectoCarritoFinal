/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class DAO {
    
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try {
             String url = "jdbc:postgresql://localhost:5432/" ;
            Class.forName("org.postgresql.Driver");
           
           // cn = DriverManager.getConnection("jdbc:postgresql://aretico.com:5432/software_2?user=grupo5_5&password=ERdqsWM_UW");
            
         //   cn = DriverManager.getConnection("jdbc:postgresql://aretico.com:5432/software_2", "grupo5_5", "ERdqsWM_UW");
            cn = DriverManager.getConnection(url, "postgres", "nachom1");
        } catch (Exception e) {
            throw e;
        }
    }
    public void Cerrar() throws Exception{
        try {
               if (cn != null){
            if (cn.isClosed() == false){
                cn.close();
            }
        }
        } catch (Exception e) {
            throw e;
        }
     
    }
}
