/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.model.UsuarioRequestDTO;
import com.projeto.tcc_backend.repository.UsuarioDAO;
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
    private UsuarioDAO repository;
    
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
    public String login(UsuarioRequestDTO usuario) {
       String mensagem = "";
        // Valida se o email foi preenchido
        if(usuario.getEmail().equals("")) {
            mensagem = "Email não preenchido";
        } else if (usuario.getSenha().equals("")) {
            // Valida se a senha foi preenchida
            mensagem = "Senha não preenchida";
        }

        // Se houver mensagem de erro, lança exceção
        if(!mensagem.equals("")) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), mensagem);
        }

        // Busca os dados do usuário autenticado
        UsuarioDTO dadosLogado = repository.login(usuario.getEmail(), usuario.getSenha());
        // Gera e retorna o token JWT
        return TokenService.gerarToken(dadosLogado); 
    }
}