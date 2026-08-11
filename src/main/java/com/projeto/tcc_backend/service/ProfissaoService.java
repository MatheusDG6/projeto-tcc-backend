/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.ProfissaoDTO;
import com.projeto.tcc_backend.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class ProfissaoService {
    
    @Autowired
    private ProfissaoRepository repository;
    
    public void cadastrarProfissao(ProfissaoDTO profissoes){
        String mensagem = "";
     
        if(profissoes.getProfissao().equals("")) {
            mensagem = "Profissão não preenchido";
        } else if(profissoes.getTelefone().equals("")) {
            mensagem = "Telefone não preenchida";
        } else if(profissoes.getDescricao().equals("")) {
            mensagem = "Descricao não preenchida";
        } else if(profissoes.getForma_pagamento().equals("")) {
            mensagem = "Forma pagamento não preenchida";
        } else if(profissoes.getCidade().equals("")) {
            mensagem = "Cidade não preenchida";
        } else if(profissoes.getEstado().equals("")) {
            mensagem = "Estado não preenchida";
        }
        
        if(!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        repository.cadastrarProfissao(profissoes);
    }
}
