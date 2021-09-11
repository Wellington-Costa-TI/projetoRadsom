package dao;

import connection.ConnectionFactory;
import entity.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void insert(Produto produto){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.produto (descricao, marca, modelo, valor, cod_bar, quantidade) VALUES(?, ?, ?, ?, ?, ?)");

            stmt.setString(1,produto.getDescricao());
            stmt.setString(2,produto.getMarca());
            stmt.setString(3,produto.getModelo());
            stmt.setFloat(4,produto.getValor());
            stmt.setString(5,produto.getCodbar());
            stmt.setInt(6,produto.getQuantidade());

            stmt.executeUpdate();

            System.out.println("Produto cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

    public List<Produto> findByDescricaoAndHasEstoque(String descricao){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT * FROM und_3.produto AS p WHERE p.descricao LIKE '%"+descricao+"%' AND p.quantidade > 0");

            resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Produto produto = new Produto();

                produto.setIdProduto(resultSet.getInt("id_produto"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setMarca(resultSet.getString("marca"));
                produto.setModelo(resultSet.getString("modelo"));
                produto.setValor(resultSet.getFloat("valor"));
                produto.setQuantidade(resultSet.getInt("quantidade"));

                produtos.add(produto);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt,resultSet);
        }

        return produtos;
    }

}
