/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Érico de Souza Loewe
 */
public class DbConnection {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    private static EntityManager em = emf.createEntityManager();
    
    public static void conectar() {
        em = emf.createEntityManager();
    }

    public static void desconectar() {
        em.close();
    }
    
    public static EntityManager getEntityManager() {
        return em;
    }
}
