package dao;

import connection.ConnectionFactory;
import entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemDAO {
    public void insert(Item item){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.item (quantidade, subtotal, id_venda, id_produto) VALUES(?, ?, ?, ?");

            stmt.setInt(1,item.getQuantidade());
            stmt.setFloat(2,item.getSubTotal());
            stmt.setInt(3,item.getVenda().getIdVenda());
            stmt.setInt(4,item.getProduto().getIdProduto());

            stmt.executeUpdate();

            System.out.println("item cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

}
