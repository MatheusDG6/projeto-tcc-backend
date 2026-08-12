/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.UserRequestDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.repository.ProfissaoRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class TokenService {
    
    @Value("${api.security.token.secret}")
    private String secret;
   
    private ProfissaoRepository repository;
   
    UserRequestDTO userRequest = new UserRequestDTO();
   
    public SecretKey getKeySign() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
   
    public String gerarToken(UsuarioDTO usuario) {
        if (usuario == null
                || usuario.getEmail() == null
                || usuario.getEmail().equals("")
                || usuario.getSenha() == null
                || usuario.getSenha().equals("")) {

            throw new ResponseStatusException(
                    HttpStatusCode.valueOf(400),
                    "Um ou mais campos faltantes"
            );
        }
        System.out.println("Email:" + email);
        System.out.println("ID: " + usuario.getId_usuario());
        
        return Jwts.builder()
               .subject(usuario.getEmail())
               .claim("id_usuario", usuario.getId_usuario())
               .claim("nome", usuario.getNome())
               .claim("email", email)
               .claim("role", usuario.getRole())
 
               .issuedAt(new Date())
               .expiration(new Date(System.currentTimeMillis() + 3000000))
               .signWith(this.getKeySign())
               .compact();
    }
    public UsuarioDTO extrairClaim(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(this.getKeySign())
                .build()
                .parseSignedClaims(token)
                .getPayload();
       
        UsuarioDTO user = new UsuarioDTO();
        user.setId_usuario(claims.get("id_usuario", Integer.class));
        user.setNome(claims.get("nome", String.class));
        user.setEmail(claims.get("email", String.class));
        user.setRole(claims.get("role", String.class));

        return user;
    }
   
    public boolean validarToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getKeySign())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }   
    }
}