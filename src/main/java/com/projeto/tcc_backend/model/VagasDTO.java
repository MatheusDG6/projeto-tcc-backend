/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.model;

/**
 *
 * @author Aluno
 */
public class VagasDTO {
    private int id_vaga;
    private String titulo;
    private String descricao;
    private Double salario;
    private String cidade;
    private String estado;
    private String status;

    public VagasDTO() {
    }

    public VagasDTO(int id_vaga, String titulo, String descricao, Double salario, String cidade, String estado, String status) {
        this.id_vaga = id_vaga;
        this.titulo = titulo;
        this.descricao = descricao;
        this.salario = salario;
        this.cidade = cidade;
        this.estado = estado;
        this.status = status;
    }

    public int getId_vaga() {
        return id_vaga;
    }

    public void setId_vaga(int id_vaga) {
        this.id_vaga = id_vaga;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
