package dao;

import connection.ConnectionFactory;
import entity.Cliente;
import entity.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void insert(Cliente cliente){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.cliente (nome, email, cpf) VALUES(?, ?, ?)");

            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getEmail());
            stmt.setString(3,cliente.getCpf());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

    public Cliente findByCpf (String cpf){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Cliente cliente = new Cliente();
        EnderecoDAO enderecoDAO =  new EnderecoDAO();
        try {
            stmt = conn.prepareStatement("SELECT * FROM und_3.cliente c WHERE c.cpf LIKE ?");
            stmt.setString(1,cpf);

            resultSet = stmt.executeQuery();

            if (resultSet.next()){
               cliente.setIdCliente(resultSet.getInt("id_cliente"));
               cliente.setCpf(resultSet.getNString("cpf"));
               cliente.setEmail(resultSet.getNString("email"));
               return cliente;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt,resultSet);
        }

        return null;
    }
}
