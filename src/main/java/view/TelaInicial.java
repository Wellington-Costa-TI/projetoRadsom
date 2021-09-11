package view;

import service.ClienteService;
import service.ProdutoService;

import java.util.Scanner;

public class TelaInicial {

    public void exibir(){
        int escolha;
        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroProduto cadastroProduto = new CadastroProduto();
        CadastroVendedor cadastroVendedor =  new CadastroVendedor();

        Scanner scan =  new Scanner(System.in);
        System.out.println("Bem-Vindo!!!\n Digite o número da ação que você deseja fazer ");
        System.out.println("OPÇÕES");
        System.out.println("(1) CADASTRAR CLIENTE");
        System.out.println("(2) CADASTRAR PRODUTO");
        System.out.println("(3) CADASTRAR VENDEDOR");
        escolha = scan.nextInt();

        switch (escolha){
            case 1:
                System.out.println("CADASTRAR CLIENTE");
                cadastroCliente.cadastrar();
                break;
            case 2:
                System.out.println("CADASTRAR PRODUTO");
                cadastroProduto.exibir();
                break;
            case 3:
                System.out.println("(3) CADASTRAR VENDEDOR");
                cadastroVendedor.exibir();
                break;

        }
    }
}
