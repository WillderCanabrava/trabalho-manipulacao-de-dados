package org.example;


import org.example.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try {
            Connection conexao = ConnectionFactory.getConnection();
            System.out.println("Conexão realizada com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
    }
}
