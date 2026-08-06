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
public class MatchVaga {
    private Integer id_match;
    private LocalDateTime data_match;
    private String status;

    public MatchVaga() {
    }

    public MatchVaga(Integer id_match, LocalDateTime data_match, String status) {
        this.id_match = id_match;
        this.data_match = data_match;
        this.status = status;
    }

    public int getId_match() {
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
    
    
}
