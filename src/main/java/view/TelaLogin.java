package view;

import entity.Vendedor;
import service.VendedorService;

import java.util.Scanner;

public class TelaLogin {

    public void exibir(){
        Boolean logado = Boolean.FALSE;
        VendedorService vendedorService = new VendedorService();
        Vendedor vendedor = new Vendedor();
        Scanner scanner = new Scanner(System.in);
        while (!logado) {

            System.out.println("Login:");
            vendedor.setNome(scanner.nextLine());
            System.out.println("Senha:");
            vendedor.setSenha(scanner.nextLine());

            logado = vendedorService.login(vendedor);
        }
    }
}
