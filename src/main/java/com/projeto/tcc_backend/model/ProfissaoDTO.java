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
    private String profissao;
    private String telefone;
    private String descricao;
    private String forma_pagamento;
    private String cidade;
    private String estado;
    private Integer id_usuario;
    private Integer id_profissao;

    public ProfissaoDTO() {
    }

    public ProfissaoDTO(String profissao, String telefone, String descricao, String forma_pagamento, String cidade, String estado, Integer id_usuario, Integer id_profissao) {
        this.profissao = profissao;
        this.telefone = telefone;
        this.descricao = descricao;
        this.forma_pagamento = forma_pagamento;
        this.cidade = cidade;
        this.estado = estado;
        this.id_usuario = id_usuario;
        this.id_profissao = id_profissao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_profissao() {
        return id_profissao;
    }

    public void setId_profissao(Integer id_profissao) {
        this.id_profissao = id_profissao;
    }
}