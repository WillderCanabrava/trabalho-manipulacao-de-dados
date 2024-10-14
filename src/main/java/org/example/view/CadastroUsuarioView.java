package org.example.view;

import org.example.dao.UsuarioDao;
import org.example.model.Usuario;
import java.sql.SQLException;

public class CadastroUsuarioView {

    public static void main(String[] args) {

        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = new Usuario("Arthur Coimbra", "19811982198", "arthurcoimbra@email.com", "21910101010");
            dao.insert(usuario);
            dao.fecharConexao();
            System.out.println("Usuario cadastrado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
