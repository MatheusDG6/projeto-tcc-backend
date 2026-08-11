/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.model.UserRequestDTO;
import com.projeto.tcc_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author mathe
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;
    
    @Autowired
    private TokenService tokenService;
    
    public void cadastrar(UsuarioDTO usuario) {
         String mensagem = "";
     
        if(usuario.getNome().equals("")) {
            mensagem = "Nome não preenchido";
        } else if(usuario.getEmail().equals("")) {
            mensagem = "Email não preenchido";
        } else if(usuario.getSenha().equals("")) {
            mensagem = "Senha não preenchida";
        } else if(usuario.getRole().equals("")) {
            usuario.setRole("CLIENTE");
        }

        if(!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        repository.cadastrar(usuario);
    }
    
    public String login(UserRequestDTO usuario) {
        
       String mensagem = "";
        if(usuario.getEmail().equals("")) {
            mensagem = "Email não preenchido";
        } else if (usuario.getSenha().equals("")) {
            mensagem = "Senha não preenchida";
        }
        if(!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }
        UsuarioDTO dadosLogado = repository.login(usuario.getEmail(), usuario.getSenha());
        return tokenService.gerarToken(dadosLogado.getEmail(), dadosLogado.getSenha()); 
    }
}