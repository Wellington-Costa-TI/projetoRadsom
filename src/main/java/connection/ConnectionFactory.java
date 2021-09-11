package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/und_3";
    private static final String USER ="root";
    private static final String PASS ="201331mysql";

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);

        } catch (ClassNotFoundException | SQLException e) {
           throw new RuntimeException("Erro na conexão: ", e);
        }
    }

    public static void closeConnection(Connection conn){

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException throwables) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, throwables);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt){

        closeConnection(conn);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException throwables) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, throwables);
        }
    }

    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet resultSet){

        closeConnection(conn, stmt);

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException throwables) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null, throwables);
        }
    }
}
