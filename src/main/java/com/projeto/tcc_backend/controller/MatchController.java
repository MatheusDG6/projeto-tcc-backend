/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import com.projeto.tcc_backend.model.MatchProfissionalDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.service.MatchService;
import com.projeto.tcc_backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mathe
 */
@RestController
@RequestMapping("/match")
public class MatchController {
    
    @Autowired
    private MatchService service;
            
    @Autowired
    private TokenService tokenService;
    
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String cadastrarMatch(@RequestBody MatchProfissionalDTO match,
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            return "Token não informado";
        }
      
        String token = authorization.substring(7);
      
        if (!tokenService.validarToken(token)) {
            return "Token inválido ou expirado";
        }
        
        UsuarioDTO usuario = tokenService.extrairClaim(token);
        
        service.cadastrarMatch(match, usuario);
        return "Solicitação de Match enviada com sucesso!";
    }
}
