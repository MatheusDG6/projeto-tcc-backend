/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.ProfissaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<ProfissaoDTO> listarProfissoes() {
           List<ProfissaoDTO> lista = new ArrayList<>();

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("SELECT profissao, telefone, descricao, forma_pagamento, cidade, estado, id_usuario, id_profissao FROM profissoes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ProfissaoDTO profissao = new ProfissaoDTO();

                profissao.setProfissao(rs.getString("profissao"));
                profissao.setTelefone(rs.getString("telefone"));
                profissao.setDescricao(rs.getString("descricao"));
                profissao.setForma_pagamento(rs.getString("forma_pagamento"));
                profissao.setCidade(rs.getString("cidade"));
                profissao.setEstado(rs.getString("estado"));
                profissao.setId_usuario(rs.getInt("id_usuario"));
                profissao.setId_profissao(rs.getInt("id_profissao"));
                
                lista.add(profissao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}