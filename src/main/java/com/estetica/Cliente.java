package com.estetica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * *
 * Criação da classe Cliente e das variáveis codigo,nome,telefone,dataConsulta.
 *
 * @author GABRIEL
 */
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nome;
    private String telefone;
    private LocalDateTime dataConsulta;
    
    
    public Cliente(){  
       
    }
    
    /**
     * *
     * Criação do constructor da classe cliente.
     *
     * 
     * @param nome
     * @param telefone
     * @param dataConsulta
     */
    public Cliente(String nome, String telefone, LocalDateTime dataConsulta) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataConsulta = dataConsulta;
    }
    
    /**
     * *
     * Criação do get codigo.
     *
     * @return Retorna o codigo do cliente.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * *
     * Define o codigo do cliente.
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * *
     * Criação do get nome.
     *
     * @return Retorna o nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * *
     * Define o nome do cliente.
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * *
     *
     * @return Retorna o telefone do cliente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * *
     * Criação do Set Telefone.
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * *
     * Criação do get DataConsulta
     *
     * @return Retorna a data da consulta do cliente.
     */
    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    /**
     * *
     * Define a data da consulta do cliente.
     *
     * @param dataConsulta
     */
    public void setDataConsulta(LocalDateTime dataConsulta) {  
        this.dataConsulta = dataConsulta;
    }

    /**
     * *
     * Uma representação em String do objeto Cliente.
     *
     * @return Retorna uma representação em String do objeto Cliente.
     */
    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Telefone: " + telefone + ", Data da Consulta: " + dataConsulta;
    }
}
