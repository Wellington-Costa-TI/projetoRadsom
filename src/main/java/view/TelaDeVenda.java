package view;

import entity.Cliente;
import entity.Vendedor;
import service.ClienteService;

import java.util.Scanner;

public class TelaDeVenda {

    public void exibir(Vendedor logado){
        Scanner scan = new Scanner(System.in);
        ClienteService clienteService = new ClienteService();
        CadastroCliente cadastroCliente =  new CadastroCliente();
        Cliente cliente = new Cliente();
        String cpf;
        System.out.println("Digite o cpf do Cliente");
             cpf = scan.nextLine();
        if(clienteService.findByCpf(cpf) == null){
            cadastroCliente.cadastrar();
            cliente = clienteService.findByCpf(cliente.getCpf());
        }


    }
}
