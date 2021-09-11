package dao;

import connection.ConnectionFactory;
import entity.Telefone;
import entity.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelefoneDAO {

    public void insert(Telefone telefone){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.telefone (ddd, numero, id_cliente) VALUES(?, ?, ?)");

            stmt.setString(1,telefone.getDdd());
            stmt.setString(2,telefone.getNumero());
            stmt.setInt(3,telefone.getCliente().getIdCliente());

            stmt.executeUpdate();

            System.out.println("Telefone cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }
}
