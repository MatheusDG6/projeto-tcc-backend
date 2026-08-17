/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import com.projeto.tcc_backend.model.MatchProfissionalDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.service.MatchService;
import com.projeto.tcc_backend.service.TokenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
 
    @GetMapping("/solicitacoes")
    public List<MatchProfissionalDTO> listarSolicitacoes(
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token não informado"
            );
        }

        String token = authorization.substring(7);

        if (!tokenService.validarToken(token)) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token inválido ou expirado"
            );
        }

        UsuarioDTO usuario = tokenService.extrairClaim(token);

        if (usuario == null || usuario.getId_usuario() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Usuário não identificado"
            );
        }

        if ("PROFISSIONAL".equals(usuario.getRole())) {

            return service.listarSolicitacoesProfissional(
                    usuario.getId_usuario()
            );
        }

        if ("CLIENTE".equals(usuario.getRole())
                || "EMPREGADOR".equals(usuario.getRole())) {

            return service.listarMatchesAceitosSolicitante(
                    usuario.getId_usuario()
            );
        }

        throw new ResponseStatusException(
                HttpStatusCode.valueOf(403),
                "Tipo de usuário não permitido"
        );
    }
    
    @PutMapping("/{id_match}/aceitar")
    public String aceitarMatch(
            @PathVariable Integer id_match,
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token não informado"
            );
        }

        String token = authorization.substring(7);

        if (!tokenService.validarToken(token)) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token inválido ou expirado"
            );
        }

        UsuarioDTO usuario = tokenService.extrairClaim(token);
        service.aceitarMatch(id_match, usuario);
        return "Match aceito com sucesso!";
    }
    
    @PutMapping("/{id_match}/recusar")
    public String recusarMatch(
            @PathVariable Integer id_match,
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token não informado"
            );
        }

        String token = authorization.substring(7);

        if (!tokenService.validarToken(token)) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token inválido ou expirado"
            );
        }

        UsuarioDTO usuario = tokenService.extrairClaim(token);
        service.recusarMatch(id_match, usuario);
        return "Match recusado com sucesso!";
    }
    
    @GetMapping("/aceitos")
    public List<MatchProfissionalDTO> listarMatchesAceitos(
            @RequestHeader("Authorization") String authorization) {

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token não informado"
            );
        }

        String token = authorization.substring(7);

        if (!tokenService.validarToken(token)) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Token inválido ou expirado"
            );
        }

        UsuarioDTO usuario = tokenService.extrairClaim(token);

        if (usuario == null || usuario.getId_usuario() == null) {
            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(401),
                    "Usuário não identificado"
            );
        }

        if (!"PROFISSIONAL".equals(usuario.getRole())
                && !"CLIENTE".equals(usuario.getRole())
                && !"EMPREGADOR".equals(usuario.getRole())) {

            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(403),
                    "Tipo de usuário não permitido"
            );
        }

        return service.listarMatchesAceitos(
                usuario.getId_usuario(),
                usuario.getRole()
        );
    }
}