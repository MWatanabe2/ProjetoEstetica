/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class Delete {
    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getEntityManager();
        Cliente p1 = new Cliente();
        
        p1.setCodigo(1);
        ClienteDAO dao = new ClienteDAO(em);
        em.getTransaction().begin();
        dao.apagar(p1);
        em.getTransaction().commit();
        em.close();        
    }
}
