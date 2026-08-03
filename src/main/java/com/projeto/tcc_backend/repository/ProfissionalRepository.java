/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.ProfissoesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class ProfissionalRepository {
    
    public void cadastrarProfissao(ProfissoesDTO profissoes){
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("INSERT INTO profissoes (titulo, descricao, experiencia, valor_hora, disponibilidade) VALUES (?,?,?,?,?)");
            stmt.setString(1, profissoes.getTitulo());
            stmt.setString(2, profissoes.getDescricao());
            stmt.setString(3, profissoes.getExperiencia());
            stmt.setDouble(4, profissoes.getValor_hora());
            stmt.setString(5, profissoes.getDisponibilidade());
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização - Nenhuma linha foi afetada");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}