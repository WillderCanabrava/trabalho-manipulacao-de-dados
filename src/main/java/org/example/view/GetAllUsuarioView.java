package org.example.view;

import org.example.dao.UsuarioDao;
import org.example.model.Usuario;

import java.sql.SQLException;
import java.util.List;

public class GetAllUsuarioView {

    public static void main(String[] args) {
            try {
                UsuarioDao dao = new UsuarioDao();
                List<Usuario> usuarios = dao.getAll();
                for (Usuario usuario : usuarios) {
                    System.out.println(usuario.getNome() + ", " + usuario.getCpf() + ", " + usuario.getEmail() + ", " + usuario.getTelefone());
                }
                dao.fecharConexao();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }


