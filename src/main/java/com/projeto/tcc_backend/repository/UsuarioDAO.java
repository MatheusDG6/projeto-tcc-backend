/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.tcc_backend.repository;

import com.projeto.tcc_backend.model.UsuarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mathe
 */
@Repository
public class UsuarioDAO {
    
    public void cadastrar(UsuarioBean usuario) {
          try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;

            stmt = conn.prepareStatement("INSERT INTO cadastro (nome, email, senha) VALUES (?,?,?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas == 0) {
                throw new SQLException("Falha na atualização - Nenhuma linha foi afetada");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public UsuarioBean login(String nome, String email, String senha) {
        UsuarioBean usuarios = new UsuarioBean();
        ResultSet rs = null;
        
        try{
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE nome = ? AND email = ? AND senha = ?");
            
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {
                usuarios.setNome(rs.getString("nome"));
                usuarios.setEmail(rs.getString("email"));
                usuarios.setSenha(rs.getString("senha"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}
