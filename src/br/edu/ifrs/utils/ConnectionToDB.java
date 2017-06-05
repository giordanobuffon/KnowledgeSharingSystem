package br.edu.ifrs.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionToDB {

    public static Connection open() throws Exception {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/knowledge_sharing_system", "root", "2534");
        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.utils.ConnectionToDB.open] Falha ao abrir conexão com o banco de dados.");
        }
        return conn;
    }

}
