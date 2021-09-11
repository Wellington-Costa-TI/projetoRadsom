package dao;

import connection.ConnectionFactory;
import entity.Venda;
import entity.Vendedor;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class VendaDAO {

    public void insert(Venda venda){
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO und_3.venda (`data`, desconto, valor_total, id_vendedor, id_cliente) VALUES(?, ?, ?, ?, ?)");
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(formatter.format(date));
            stmt.setString(1,formatter.format(date));
            stmt.setFloat(2,venda.getDesconto());
            stmt.setFloat(3,venda.getValorTotal());
            stmt.setInt(4,venda.getVendedor().getIdVendedor());
            stmt.setInt(5,venda.getCliente().getIdCliente());

            stmt.executeUpdate();

            System.out.println("Venda cadastrado com Sucesso!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            ConnectionFactory.closeConnection(conn,stmt);
        }
    }

}
