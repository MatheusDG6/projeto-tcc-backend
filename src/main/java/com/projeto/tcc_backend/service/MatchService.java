/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.MatchProfissionalDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.repository.MatchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author mathe
 */
@Service
public class MatchService {
    
    @Autowired
    private MatchRepository repository;
    
     public void cadastrarMatch(MatchProfissionalDTO match, UsuarioDTO usuario) {

        if (usuario == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Usuário não identificado"
            );
        }

        if (usuario.getId_usuario() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "ID do usuário não identificado"
            );
        }

        if (!"CLIENTE".equals(usuario.getRole()) && !"EMPREGADOR".equals(usuario.getRole())) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(403),
                    "Apenas clientes e empregadores podem solicitar Match"
            );
        }

        if (match.getId_profissao() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "Profissão não informada"
            );
        }

        match.setId_usuario(usuario.getId_usuario());
        match.setStatus("PENDENTE");
        repository.cadastrarMatch(match);
    }
    
    public List<MatchProfissionalDTO> listarSolicitacoesProfissional(Integer id_usuario) {

        if (id_usuario == null) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Usuário não informado"
            );
        }

        return repository.listarSolicitacoesProfissional(id_usuario);
    }
    
    public void aceitarMatch(Integer id_match, UsuarioDTO usuario) {

        if (usuario == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Usuário não identificado"
            );
        }

        if (usuario.getId_usuario() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "ID do usuário não identificado"
            );
        }

        if (!"PROFISSIONAL".equals(usuario.getRole())) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(403),
                    "Apenas profissionais podem aceitar Match"
            );
        }

        if (id_match == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "Match não informado"
            );
        }

        repository.aceitarMatch(id_match, usuario.getId_usuario()
        );
    }
    
    public void recusarMatch(Integer id_match, UsuarioDTO usuario) {

        if (usuario == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Usuário não identificado"
            );
        }

        if (usuario.getId_usuario() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "ID do usuário não identificado"
            );
        }

        if (!"PROFISSIONAL".equals(usuario.getRole())) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(403),
                    "Apenas profissionais podem recusar Match"
            );
        }

        if (id_match == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "Match não informado"
            );
        }

        repository.recusarMatch(id_match, usuario.getId_usuario()
        );
    }
}