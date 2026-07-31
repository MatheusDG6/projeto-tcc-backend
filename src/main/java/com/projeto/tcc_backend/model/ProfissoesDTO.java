/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.model;

/**
 *
 * @author Aluno
 */
public class ProfissoesDTO {
    private int profissao;
    private String titulo;
    private String descricao;
    private String experiencia;
    private Double valor_hora;
    private String disponibilidade;

    public ProfissoesDTO() {
    }

    public ProfissoesDTO(int profissao, String titulo, String descricao, String experiencia, Double valor_hora, String disponibilidade) {
        this.profissao = profissao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.experiencia = experiencia;
        this.valor_hora = valor_hora;
        this.disponibilidade = disponibilidade;
    }

    public int getProfissao() {
        return profissao;
    }

    public void setProfissao(int profissao) {
        this.profissao = profissao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public Double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
    
}
