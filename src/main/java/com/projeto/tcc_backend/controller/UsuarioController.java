/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.controller;

import com.projeto.tcc_backend.model.UserRequestDTO;
import com.projeto.tcc_backend.model.UsuarioDTO;
import com.projeto.tcc_backend.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tools.jackson.databind.ObjectMapper;

/**
 *
 * @author mathe
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;
    
    @PostMapping("/cadastrar")
    public String cadastrar(@RequestBody UsuarioDTO usuario) {
        service.cadastrar(usuario);
        return "Cadastro feito com sucesso!";
    }
    
    @PostMapping("/login")
    public String login(@RequestBody UserRequestDTO user) {
        /*
        try {
            String userLogged = service.login(user);

            session.setAttribute("token", userLogged);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastro realizado com sucesso");

            return "redirect:/";

        } catch (HttpStatusCodeException e) {
            String mensagemErroBackend = new ObjectMapper().readTree(e.getResponseBodyAsString()).get("message").asString();
            redirectAttributes.addFlashAttribute("mensagemErro", mensagemErroBackend);
            model.addAttribute("user", new UserRequestDTO());
            return "redirect:/login";
            
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
            return "redirect:/login";
        }
    */
        return service.login(user);
    }
}