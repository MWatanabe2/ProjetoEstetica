package com.estetica;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;

/**
 * *
 * Criação da classe Sistema
 *
 */
public class Sistema {

    private Scanner teclado;

    /**
     * *
     * Criação do Scanner
     */
    public Sistema() {
        teclado = new Scanner(System.in);
    }

    /**
     * *
     * Solicita ao usuário os dados do cliente (nome, telefone, data da consulta
     * e hora da consulta).
     */
    public void inserirCliente() {
        EntityManager em = ConnectionFactory.getEntityManager();
        System.out.println("CADASTRO DE CLIENTE");
        System.out.println();
        System.out.println("Nome: ");
        var nome = teclado.nextLine();
        System.out.println("Telefone: ");
        var telefone = teclado.nextLine();
        System.out.println("Dia da Consulta: ");
        var dia = teclado.nextLine();
        System.out.println("Mês da Consulta: ");
        var mes = teclado.nextLine();
        System.out.println("Hora da Consulta: ");
        var hora = teclado.nextLine();
        System.out.println("Minuto da Consulta: ");
        var min = teclado.nextLine();

        DataConsulta data = new DataConsulta();
        Cliente cliente = new Cliente(nome, telefone, data.gerarData(dia, mes, hora, min));

        /**
         * *Adiciona a conta ao conjunto de contas Exibe uma mensagem indicando
         * que o cliente foi cadastrado.
         */
        ClienteDAO dao = new ClienteDAO(em);

        em.getTransaction().begin();//Iniciando uma transação com o BD
        dao.inserirCliente(cliente);//Cadastrando o cliente no BD
        em.getTransaction().commit();//Confirmando a operação

        em.close();//Encerra a conexão com o BD

    }

    /**
     * *
     * Exibe os clientes
     */
    public void exibirClientes() {
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        List<Cliente> lista;

        lista = dao.exibirClientes();

        //foreach
        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }
    }

    /**
     * *
     * Exibe os clientes pelo código.
     */
    public void exibirPorCodigo() {
        EntityManager em = ConnectionFactory.getEntityManager();
        System.out.println("Código: ");
        var codigo = teclado.nextInt();
        ClienteDAO dao = new ClienteDAO(em);
        em.getTransaction().begin();
        Cliente p1 = dao.exibirPorCodigo(codigo);
        em.getTransaction().commit();
        em.close();

        if (p1 != null) {
            System.out.println(p1);
        } else {
            System.out.println("Produto não encontrado");
        }

    }

    /**
     * *
     * Exibe os clientes pelo nome.
     */
    public void exibirPorNome() {
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        System.out.println("Nome: ");
        var nome = teclado.nextLine();
        List<Cliente> lista = dao.exibirPorNome(nome);

        for (Cliente cliente : lista) {
            System.out.println(cliente);
        }

    }

    /**
     * *
     * Exclui um cliente existente.
     */
    public void apagar() {
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        long totalClientes = dao.contarClientes();

        if (totalClientes == 0) {
            System.out.println("Não é possível excluir o último cliente cadastrado.");
        } else {
            System.out.println("Código: ");
            var codigo = teclado.nextInt();
            Cliente p1 = dao.exibirPorCodigo(codigo);

            if (p1 != null) {
                em.getTransaction().begin();
                dao.apagar(p1);
                em.getTransaction().commit();
                em.close();
                System.out.println("Cliente excluído com sucesso.");
                // Redefinir código dos clientes
                redefinirCodigoClientes();
            } else {
                System.out.println("Cliente não encontrado.");
            }
        }
    }

    private void redefinirCodigoClientes() {
        EntityManager em = ConnectionFactory.getEntityManager();
        ClienteDAO dao = new ClienteDAO(em);
        List<Cliente> clientes = dao.exibirClientes();
        em.getTransaction().begin();

        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            // Redefinir código do cliente para (i + 1)
            cliente.setCodigo(i + 1);
            dao.inserirCliente(cliente);
        }

        em.getTransaction().commit();
        em.close();
        System.out.println("Código dos clientes redefinido.");
    }
}
