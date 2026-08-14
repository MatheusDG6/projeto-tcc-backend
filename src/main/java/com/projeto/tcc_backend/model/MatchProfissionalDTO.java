/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.model;

import java.time.LocalDateTime;

/**
 *
 * @author Aluno
 */
public class MatchProfissionalDTO {
    private Integer id_match;
    private LocalDateTime data_match;
    private String status;
    private Integer id_usuario;
    private Integer id_profissao;

    public MatchProfissionalDTO() {
    }

    public MatchProfissionalDTO(Integer id_match, LocalDateTime data_match, String status, Integer id_usuario, Integer id_profissao) {
        this.id_match = id_match;
        this.data_match = data_match;
        this.status = status;
        this.id_usuario = id_usuario;
        this.id_profissao = id_profissao;
    }

    public Integer getId_match() {
        return id_match;
    }

    public void setId_match(Integer id_match) {
        this.id_match = id_match;
    }

    public LocalDateTime getData_match() {
        return data_match;
    }

    public void setData_match(LocalDateTime data_match) {
        this.data_match = data_match;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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