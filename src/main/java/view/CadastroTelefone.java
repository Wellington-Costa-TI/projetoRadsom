package view;

import entity.Cliente;
import entity.Telefone;
import service.TelefoneService;

import java.util.Scanner;

public class CadastroTelefone {

    public void exibir(Cliente cliente){
        TelefoneService telefoneService = new TelefoneService();
        Telefone telefone = new Telefone();
        Scanner scan = new Scanner(System.in);

        System.out.println("TELEFONE\nDDD:");
        telefone.setDdd(scan.nextLine());

        System.out.println("Número");
        telefone.setNumero(scan.nextLine());

        telefone.setCliente(cliente);
        telefoneService.cadastrar(telefone);
    }
}
