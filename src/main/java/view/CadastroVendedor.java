package view;

import entity.Vendedor;
import service.VendedorService;

import java.util.Scanner;

public class CadastroVendedor {
    public void exibir(){
        VendedorService vendedorService = new VendedorService();
        Vendedor vendedor = new Vendedor();
        Scanner scan = new Scanner(System.in);

        System.out.println("### CADASTRO VENDEDOR ###");
        System.out.println("Nome:");
        vendedor.setNome(scan.nextLine());
        System.out.println("Senha:");
        vendedor.setSenha(scan.nextLine());

        vendedorService.cadastrar(vendedor);

    }
}
