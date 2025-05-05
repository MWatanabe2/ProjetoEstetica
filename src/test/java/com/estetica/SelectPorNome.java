/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;

/**
 *
 * @author Usuario
 */
public class SelectPorNome {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        System.out.println("Nome: ");
        var nome = teclado.nextLine();
        List<Cliente> lista = dao.exibirPorNome(nome);
        
        for (Cliente cliente : lista) {
            System.out.println(cliente);   
        }
        
    }
}
