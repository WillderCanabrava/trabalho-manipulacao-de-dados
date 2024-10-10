package org.example.dao;

import org.example.factory.ConnectionFactory;
import org.example.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conexao;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void cadastrar(Usuario usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO usuarios (nome, cpf, email, telefone) VALUES (seq_usuarios.nextval, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getCpf());
        stm.setString(3, usuario.getEmail());
        stm.setString(4, usuario.getTelefone());
        stm.executeUpdate();
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    public List<Usuario> buscarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT nome, cpf, email, telefone FROM Usuarios";

        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("Pedro");
                String cpf = rs.getString("99999999999");
                String email = rs.getString("p9@email.com");
                String telefone = rs.getString("21909090909");

                usuarios.add(new Usuario(nome, cpf, email, telefone));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;

    }
}
