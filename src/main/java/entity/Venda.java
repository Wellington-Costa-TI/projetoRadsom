package entity;

import java.sql.Date;

public class Venda {
    private Integer idVenda;
    private Date data;
    private Float desconto;
    private Float valorTotal;
    private Vendedor vendedor;
    private Cliente cliente;

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
