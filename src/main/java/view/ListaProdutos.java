package view;

import entity.Produto;
import service.ProdutoService;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutos {

    public void exibir(String descricao){
        ProdutoService produtoService = new ProdutoService();
        List<Produto> produtos = new ArrayList<>();
        produtos = produtoService.listaProdutosPorDescrição(descricao);
        if (!produtos.isEmpty()|| produtos != null) {
            for (Produto p : produtos) {
                System.out.println("\n|--------------------------------");
                System.out.println("ID: "+p.getIdProduto());
                System.out.println(p.getDescricao());
                System.out.println(p.getModelo());
                System.out.println(p.getMarca());
                System.out.println(p.getValor());
                System.out.println(p.getQuantidade());
                System.out.println("|--------------------------------\n");
            }
        }else{
            System.out.println("Nenhum produto encontrado com essa descrição");
        }
    }
}
