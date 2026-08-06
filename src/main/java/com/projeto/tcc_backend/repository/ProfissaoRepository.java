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

            stmt = conn.prepareStatement("INSERT INTO profissoes (titulo, telefone, descricao, valor_hora, forma_pagamento, cidade, estado) VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, profissoes.getTitulo());
            stmt.setString(2, profissoes.getTelefone());
            stmt.setString(3, profissoes.getDescricao());
            stmt.setDouble(4, profissoes.getValor_hora());
            stmt.setString(5, profissoes.getForma_pagamento());
            stmt.setString(6, profissoes.getCidade());
            stmt.setString(7, profissoes.getEstado());
            
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização - Nenhuma linha foi afetada");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}