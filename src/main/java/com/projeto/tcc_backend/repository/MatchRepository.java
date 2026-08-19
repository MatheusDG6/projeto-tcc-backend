/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.MatchProfissionalDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO match_profissional (data_match, status, id_usuario, id_profissao) VALUES (NOW(), ?, ?, ?)");
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
    
    public List<MatchProfissionalDTO> listarSolicitacoesProfissional(Integer id_usuario) {
        List<MatchProfissionalDTO> lista = new ArrayList<>();

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT m.id_match, "
                    + "m.data_match, "
                    + "m.status, "
                    + "m.id_usuario, "
                    + "m.id_profissao, "
                    + "u.nome AS nome_solicitante, "
                    + "u.email AS email_solicitante "
                    + "FROM match_profissional m "
                    + "INNER JOIN profissoes p "
                    + "ON m.id_profissao = p.id_profissao "
                    + "INNER JOIN usuario u "
                    + "ON m.id_usuario = u.id_usuario "
                    + "WHERE p.id_usuario = ? "
                    + "AND m.status IN ('PENDENTE', 'ACEITO')"
            );

            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MatchProfissionalDTO match = new MatchProfissionalDTO();
                match.setId_match(rs.getInt("id_match"));
                match.setData_match(rs.getTimestamp("data_match").toLocalDateTime());
                match.setStatus(rs.getString("status"));
                match.setId_usuario(rs.getInt("id_usuario"));
                match.setId_profissao(rs.getInt("id_profissao"));
                match.setNome_solicitante(rs.getString("nome_solicitante"));
                match.setEmail_solicitante(rs.getString("email_solicitante"));

                lista.add(match);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public void aceitarMatch(Integer id_match, Integer id_usuario) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE match_profissional m "
                    + "INNER JOIN profissoes p "
                    + "ON m.id_profissao = p.id_profissao "
                    + "SET m.status = 'ACEITO' "
                    + "WHERE m.id_match = ? "
                    + "AND p.id_usuario = ? "
                    + "AND m.status = 'PENDENTE'"
            );

            stmt.setInt(1, id_match);
            stmt.setInt(2, id_usuario);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException(
                        "Match não encontrado, não pertence ao profissional "
                        + "ou já foi respondido."
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao aceitar Match.");
        }
    }
    
    public void recusarMatch(Integer id_match, Integer id_usuario) {
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE match_profissional m "
                    + "INNER JOIN profissoes p "
                    + "ON m.id_profissao = p.id_profissao "
                    + "SET m.status = 'RECUSADO' "
                    + "WHERE m.id_match = ? "
                    + "AND p.id_usuario = ? "
                    + "AND m.status = 'PENDENTE'"
            );

            stmt.setInt(1, id_match);
            stmt.setInt(2, id_usuario);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                throw new SQLException(
                        "Match não encontrado, não pertence ao profissional "
                        + "ou já foi respondido."
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao recusar Match.");
        }
    }
    
    public List<MatchProfissionalDTO> listarMatchesAceitos(Integer id_usuario) {
        List<MatchProfissionalDTO> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT m.id_match, "
                    + "m.data_match, "
                    + "m.status, "
                    + "m.id_usuario, "
                    + "m.id_profissao, "
                    + "u.nome AS nome_solicitante, "
                    + "u.email AS email_solicitante "
                    + "FROM match_profissional m "
                    + "INNER JOIN profissoes p "
                    + "ON m.id_profissao = p.id_profissao "
                    + "INNER JOIN usuario u "
                    + "ON m.id_usuario = u.id_usuario "
                    + "WHERE p.id_usuario = ? "
                    + "AND m.status = 'ACEITO'"
            );

            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MatchProfissionalDTO match = new MatchProfissionalDTO();
                match.setId_match(rs.getInt("id_match"));
                match.setData_match(rs.getTimestamp("data_match").toLocalDateTime());
                match.setStatus(rs.getString("status"));
                match.setId_usuario(rs.getInt("id_usuario"));
                match.setId_profissao(rs.getInt("id_profissao"));
                match.setNome_solicitante(rs.getString("nome_solicitante"));
                match.setEmail_solicitante(rs.getString("email_solicitante"));

                lista.add(match);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public List<MatchProfissionalDTO> listarMatchesAceitosSolicitante(Integer id_usuario) {
        List<MatchProfissionalDTO> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT m.id_match, "
                    + "m.data_match, "
                    + "m.status, "
                    + "m.id_usuario, "
                    + "m.id_profissao, "
                    + "u.nome AS nome_usuario, "
                    + "u.email AS email_usuario "
                    + "FROM match_profissional m "
                    + "INNER JOIN profissoes p "
                    + "ON m.id_profissao = p.id_profissao "
                    + "INNER JOIN usuario u "
                    + "ON p.id_usuario = u.id_usuario "
                    + "WHERE m.id_usuario = ? "
                    + "AND m.status IN ('PENDENTE','ACEITO')"
            );

            stmt.setInt(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MatchProfissionalDTO match = new MatchProfissionalDTO();
                match.setId_match(rs.getInt("id_match"));
                match.setData_match(rs.getTimestamp("data_match").toLocalDateTime());
                match.setStatus(rs.getString("status"));
                match.setId_usuario(rs.getInt("id_usuario"));
                match.setId_profissao(rs.getInt("id_profissao"));
                match.setNome_usuario(rs.getString("nome_usuario"));
                match.setEmail_usuario(rs.getString("email_usuario"));

                lista.add(match);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}