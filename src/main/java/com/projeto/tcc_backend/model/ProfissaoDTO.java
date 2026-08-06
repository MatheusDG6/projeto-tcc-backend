/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.model;

/**
 *
 * @author Aluno
 */
public class ProfissaoDTO {
    private Integer profissao;
    private String titulo;
    private String telefone;
    private String descricao;
    private Double valor_hora;
    private String forma_pagamento;
    private String cidade;
    private String estado;

    public ProfissaoDTO() {
    }

    public ProfissaoDTO(Integer profissao, String titulo, String telefone, String descricao, Double valor_hora, String forma_pagamento, String cidade, String estado) {
        this.profissao = profissao;
        this.titulo = titulo;
        this.telefone = telefone;
        this.descricao = descricao;
        this.valor_hora = valor_hora;
        this.forma_pagamento = forma_pagamento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public int getProfissao() {
        return profissao;
    }

    public void setProfissao(Integer profissao) {
        this.profissao = profissao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
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