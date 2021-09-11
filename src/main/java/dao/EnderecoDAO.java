package dao;

import connection.ConnectionFactory;
import entity.Cliente;
import entity.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDAO {
    public void insert(Endereco endereco){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.endereco (logradouro, numero, cep, cidade, bairro, complemento,id_cliente) VALUES(?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1,endereco.getLogradouro());
            stmt.setString(2,endereco.getNumero());
            stmt.setString(3,endereco.getCep());
            stmt.setString(4,endereco.getCidade());
            stmt.setString(5,endereco.getBairro());
            stmt.setString(6,endereco.getComplemento());
            stmt.setInt(7,endereco.getCliente().getIdCliente());

            stmt.executeUpdate();

            System.out.println("Endereço cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

    public Endereco findById(Integer idEndereco){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Endereco endereco = new Endereco();
        try {
            stmt = conn.prepareStatement("SELECT * FROM und_3.endereco e WHERE e.id_endereco = ?");
            stmt.setInt(1,idEndereco);

            resultSet = stmt.executeQuery();

            if (resultSet.next()){
                endereco.setIdEndereco(resultSet.getInt("id_endereco"));
                endereco.setLogradouro(resultSet.getNString("logradouro"));
                endereco.setBairro(resultSet.getNString("bairro"));
                endereco.setCep(resultSet.getNString("cep"));
                endereco.setComplemento(resultSet.getNString("complemento"));
                endereco.setNumero(resultSet.getNString("numero"));
                return endereco;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt,resultSet);
        }

        return null;
    }

}
