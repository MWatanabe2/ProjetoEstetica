/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import java.util.Scanner;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class SelectOne {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        EntityManager em = ConnectionFactory.getEntityManager();
        System.out.println("Código: ");
        var codigo = teclado.nextInt();
        ClienteDAO dao = new ClienteDAO(em);
        em.getTransaction().begin();
        Cliente p1 = dao.exibirPorCodigo(codigo);
        em.getTransaction().commit();
        em.close();
        
        if(p1 != null){
            System.out.println(p1);
        }else{
            System.out.println("Produto não encontrado");
        }
        
    }  
}
