/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.model;

/**
 *
 * @author Aluno
 */
public class EmpregadorDTO {
    private Integer id_empregador;
    private String nome_empresa;
    private String telefone;
    private String cnpj;
    private String cidade;
    private String estado;

    public EmpregadorDTO() {
    }

    public EmpregadorDTO(Integer id_empregador, String nome_empresa, String telefone, String cnpj, String cidade, String estado) {
        this.id_empregador = id_empregador;
        this.nome_empresa = nome_empresa;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getId_empregador() {
        return id_empregador;
    }

    public void setId_empregador(Integer id_empregador) {
        this.id_empregador = id_empregador;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
