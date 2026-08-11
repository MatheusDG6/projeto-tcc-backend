/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import ch.qos.logback.core.CoreConstants;
import com.projeto.tcc_backend.model.ProfissaoDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.service.ProfissaoService;
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
@RequestMapping("/profissional")
public class ProfissaoController {
    
    @Autowired
    private ProfissaoService service;
    
    @PostMapping("/cadastrar")
    public String cadastrarProfissao(@RequestBody ProfissaoDTO profissoes, UsuarioDTO usuario) {
        System.out.println("aqui");
        System.out.println(usuario.getNome());
        System.out.println("aqui");
        service.cadastrarProfissao(profissoes, usuario);
           
        return "Cadastro da profissão feito com sucesso!";
    }
}
