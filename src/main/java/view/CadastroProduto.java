package view;

import entity.Produto;
import org.w3c.dom.ls.LSOutput;
import service.ProdutoService;

import java.util.Scanner;

public class CadastroProduto {

    public void exibir(){
        ProdutoService produtoService = new ProdutoService();
        Produto produto = new Produto();
        Scanner scan = new Scanner(System.in);

        System.out.println("##### CADASTRO DE PRODUTO #####");

        System.out.println("Descrição:");
        produto.setDescricao(scan.nextLine());

        System.out.println("Marca:");
        produto.setMarca(scan.nextLine());

        System.out.println("Modelo:");
        produto.setModelo(scan.nextLine());

        System.out.println("Valor:");
        produto.setValor(scan.nextFloat());

        System.out.println("Quantidade:");
        produto.setQuantidade(scan.nextInt());

        produtoService.cadastrar(produto);

    }


}
