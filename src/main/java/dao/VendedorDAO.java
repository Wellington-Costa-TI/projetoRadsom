package dao;

import connection.ConnectionFactory;
import entity.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    public void insert(Vendedor vendedor){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.vendedor(nome, senha)VALUES(?, ?)");

            stmt.setString(1,vendedor.getNome());
            stmt.setString(2,vendedor.getSenha());

            stmt.executeUpdate();

            System.out.println("Vendedor cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

    public Boolean logar (Vendedor vendedor){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Boolean check = Boolean.FALSE;
        try {
            stmt = conn.prepareStatement("select * from und_3.vendedor as v where v.nome like ? and v.senha like ?");
            stmt.setString(1,vendedor.getNome());
            stmt.setString(2,vendedor.getSenha());

            resultSet = stmt.executeQuery();

            if (resultSet.next()){
               check = Boolean.TRUE;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt,resultSet);
        }

        return check;
    }
}
