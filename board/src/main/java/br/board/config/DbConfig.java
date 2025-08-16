package br.board.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    private final static String url = "jdbc:mysql://localhost/Board_Project";
    private final static String user = "root";
    private final static String password = "fab08052005?";

    public static final Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password);
    }
}
