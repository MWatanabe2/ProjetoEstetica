/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * *
 * Criação da classe que conecta o projeto ao banco.
 *
 * @author GABRIEL
 */
public class ConnectionFactory {

    private static final EntityManagerFactory FACTORY
            = Persistence.createEntityManagerFactory("Estetica");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
