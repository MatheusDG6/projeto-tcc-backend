/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import com.projeto.tcc_backend.model.UsuarioBean;
import com.projeto.tcc_backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mathe
 */
@Controller
@RequestMapping("")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioBean usuario) {
        service.cadastrar(usuario);
        return "Cadastro feito com sucesso!";
    }
}
