package service;

import dao.ProdutoDAO;
import entity.Produto;

import java.util.List;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        this.produtoDAO = new ProdutoDAO();
    }

    public void cadastrar(Produto produto){
        this.produtoDAO.insert(produto);
    }

    public List<Produto> listaProdutosPorDescrição(String descricao){
        return this.produtoDAO.findByDescricaoAndHasEstoque(descricao);
    }

}
