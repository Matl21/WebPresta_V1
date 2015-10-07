/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Admin
 */
public class Login_ {
    EntityManagerFactory emf;
    EntityManager em;
    
    public Login_(){
    emf = Persistence.createEntityManagerFactory("WebPrestaPU");
    em = emf.createEntityManager();
    em.getTransaction().begin();
}
    public Boolean LoginExists(String user, String pass){
        try{
            Usuario u = em.createNamedQuery("Usuario.logeo", Usuario.class).setParameter("login", user).setParameter("pass", pass).getSingleResult();
            if (u != null){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }
}
