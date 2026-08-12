/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.ProfissaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ProfissaoRepository {
    
    public void cadastrarProfissao(ProfissaoDTO profissoes){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("INSERT INTO profissoes (profissao, telefone, descricao, forma_pagamento, cidade, estado, id_usuario) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, profissoes.getProfissao());
            stmt.setString(2, profissoes.getTelefone());
            stmt.setString(3, profissoes.getDescricao());
            stmt.setString(4, profissoes.getForma_pagamento());
            stmt.setString(5, profissoes.getCidade());
            stmt.setString(6, profissoes.getEstado());
            stmt.setInt(7, profissoes.getId_usuario());
            
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização - Nenhuma linha foi afetada");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}