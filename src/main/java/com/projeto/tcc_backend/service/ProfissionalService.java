/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.ProfissoesDTO;
import com.projeto.tcc_backend.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class ProfissionalService {
    
    @Autowired
    private ProfissionalRepository repository;
    
    public void cadastrarProfissao(ProfissoesDTO profissoes){
        String mensagem = "";
     
        if(profissoes.getTitulo().equals("")) {
            mensagem = "Titulo não preenchido";
        } else if(profissoes.getDescricao().equals("")) {
            mensagem = "Descrição não preenchida";
        } else if(profissoes.getExperiencia().equals("")) {
            mensagem = "Experiencia não preenchida";
        } else if(profissoes.getValor_hora().equals("")) {
            mensagem = "Valor hora não preenchida";
        } else if(profissoes.getDisponibilidade().equals("")) {
            mensagem = "Disponibilidade não preenchida";
        }
        
        if(!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        repository.cadastrarProfissao(profissoes);
    }
}
