/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import com.projeto.tcc_backend.model.ProfissoesDTO;
import com.projeto.tcc_backend.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Aluno
 */
@RestController
@RequestMapping("")
public class ProfissionalController {
    
    @Autowired
    private ProfissionalService service;
    
    @PostMapping("/cadastrar")
    public String cadastrarProfissao(@RequestBody ProfissoesDTO profissoes) {
        service.cadastrarProfissao(profissoes);
        return "Cadastro da profissão feito com sucesso!";
    }
}
