/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.service;

import com.projeto.tcc_backend.model.UsuarioBean;
import com.projeto.tcc_backend.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mathe
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioDAO repository;
    
    public void cadastrar(UsuarioBean usuario) {
        repository.cadastrar(usuario);
    }
}