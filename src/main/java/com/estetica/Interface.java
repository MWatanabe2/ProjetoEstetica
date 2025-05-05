package com.estetica;

import java.util.Scanner;
import javax.persistence.EntityManager;

/**
 * *
 * Criação da classe interface.
 */
public class Interface {

    private Scanner teclado;
    EntityManager em = ConnectionFactory.getEntityManager();
    ClienteDAO dao = new ClienteDAO(em);
    private Sistema cadastro;

    /**
     * *
     * Inicializa o scanner e o sistema de cadastro. Imprime uma mensagem de
     * início do cadastro de clientes.
     */
    public Interface() {
        teclado = new Scanner(System.in);
        cadastro = new Sistema();
        System.out.println("Iniciando Cadastro de Clientes...");
    }

    /**
     * *
     * Método responsável por iniciar o cadastro de clientes. Exibe o menu de
     * opções ao usuário e executa a ação selecionada. Repete o processo até que
     * o usuário escolha sair. Imprime uma mensagem de finalização do programa
     * ao sair.
     */
    public void iniciar() {
        var opcao = exibirMenu();

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    //Inserir os dados de um cliente
                    cadastro.inserirCliente();
                    break;
                case 2:
                    //Excluir os dados de um cliente
                    cadastro.apagar();
                    break;
                case 3:
                    //Exibir os dados de um cliente pelo código
                    cadastro.exibirPorCodigo();
                    break;
                case 4:
                    //Exibir os dados de todos os clientes
                    cadastro.exibirClientes();
                    break;
                case 5:
                    //Exibir os dados de um cliente pelo nome
                    cadastro.exibirPorNome();
                    break;
                case 6:
                    //sair
                    break;
            }
            proximaOpcao();
            opcao = exibirMenu();
        }
        System.out.println("Aplicação Finalizada.");
        teclado.close();
    }

    /**
     * *
     * Exibe o menu de opções para o usuário. Retorna a opção escolhida pelo
     * usuário.
     *
     * @return A opção escolhida pelo usuário.
     */
    public int exibirMenu() {
        System.out.println("ESCOLHA UMA OPÇÃO: ");
        System.out.println(" 1- Inserir um novo cliente");
        System.out.println(" 2- Excluir um cliente");
        System.out.println(" 3- Exibir por ID");
        System.out.println(" 4- Exibir os dados dos clientes");
        System.out.println(" 5- Exibir por Nome");
        System.out.println(" 6- Sair");

        return teclado.nextInt();
    }

    /**
     * *
     * Imprime uma mensagem para o usuário solicitar a próxima opção.
     */
    public void proximaOpcao() {
        System.out.println();
        System.out.println("Pressione qualquer TECLA e de ENTER para voltar ao menu principal");
        teclado.next();
    }
}
