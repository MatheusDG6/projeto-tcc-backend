/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.MatchProfissionalDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mathe
 */
@Repository
public class MatchRepository {

    public void cadastrarMatch(MatchProfissionalDTO match) {

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO match_profissional (data_match, status, id_usuario, id_profissao) VALUES (NOW(), ?, ?, ?)"
            );

            stmt.setString(1, match.getStatus());
            stmt.setInt(2, match.getId_usuario());
            stmt.setInt(3, match.getId_profissao());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException(
                        "Falha na atualização - Nenhuma linha foi afetada"
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
