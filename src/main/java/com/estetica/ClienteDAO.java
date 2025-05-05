/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estetica;

import java.util.List;
import javax.persistence.EntityManager;

/**
 * *
 * Criação da classe ClienteDAO
 *
 */
public class ClienteDAO {

    private final EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    /**
     * *
     * Insere um cliente.
     *
     * @param cliente
     */
    public void inserirCliente(Cliente cliente) {
        em.persist(cliente);
    }

    /**
     * *
     * Remove um cliente.
     *
     * @param cliente
     */
    public void apagar(Cliente cliente) {
        cliente = em.merge(cliente);
        em.remove(cliente);
    }

    /**
     * *
     * Exibe um cliente pelo código.
     *
     * @param codigo
     * @return Cliente.
     */
    public Cliente exibirPorCodigo(int codigo) {
        return em.find(Cliente.class, codigo);
    }

    /**
     * *
     * Exibe todos os clientes cadastrados.
     *
     * @return clientes cadastrados.
     */
    public List<Cliente> exibirClientes() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }
public long contarClientes() {
    String jpql = "SELECT COUNT(c) FROM Cliente c";
    return em.createQuery(jpql, Long.class).getSingleResult();
}
    /**
     * *
     * Exibe um cliente pelo seu nome.
     *
     * @param busca Cliente nome.
     * @return Cliente.
     */
    public List<Cliente> exibirPorNome(String busca) {
        String jpql = "SELECT c FROM Cliente c WHERE c.nome = :busca";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("busca", busca)
                .getResultList();
    }
}
