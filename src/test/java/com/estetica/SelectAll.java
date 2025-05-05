/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class SelectAll {
    public static void main(String[] args) {
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        List<Cliente> lista;
        
        lista = dao.exibirClientes();
        
        //foreach
        for(Cliente cliente : lista){
            System.out.println(cliente);
        }        
    }
}
