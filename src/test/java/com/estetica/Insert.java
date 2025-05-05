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
public class Insert {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        EntityManager em = ConnectionFactory.getEntityManager();
        System.out.println("CADASTRO DE CLIENTE");
        System.out.println();
        System.out.println("Nome: ");
        var nome = teclado.nextLine();
        System.out.println("Telefone: ");
        var telefone = teclado.nextLine();
        System.out.println("Data da Consulta: ");
        var dia = teclado.nextLine();
        System.out.println("Mês da Consulta: ");
        var mes = teclado.nextLine();
        System.out.println("Hora da Consulta: ");
        var hora = teclado.nextLine();
        System.out.println("Minuto da Consulta: ");
        var min = teclado.nextLine();

        DataConsulta data = new DataConsulta();
        Cliente cli = new Cliente(nome, telefone, data.gerarData(dia, mes, hora, min));

        /**
         * *Adiciona a conta ao conjunto de contas Exibe uma mensagem indicando
         * que o cliente foi cadastrado.
         */
        System.out.println("Cliente Cadastrado!");
        ClienteDAO dao = new ClienteDAO(em);
        
        em.getTransaction().begin();//Iniciando uma transação com o BD
        dao.inserirCliente(cli);//Cadastrando o produto no BD
        em.getTransaction().commit();//Confirmando a operação
        
        em.close();//Encerra a conexão com o BD
        
    }
}
