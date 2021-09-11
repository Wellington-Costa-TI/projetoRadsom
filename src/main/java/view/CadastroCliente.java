package view;

import service.ClienteService;
import service.EnderecoService;
import entity.Cliente;
import entity.Endereco;

import java.util.Scanner;

public class CadastroCliente {

    public void cadastrar(){

        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        Scanner scan = new Scanner(System.in);
        ClienteService clienteController = new ClienteService();
        EnderecoService enderecoController = new EnderecoService();
        CadastroTelefone cadastroTelefone = new CadastroTelefone();
        Boolean outroctt = Boolean.TRUE;

        System.out.println("\n###### CADASTRO DE CLIENTES #######\n");
        System.out.println("\nNome:");
        cliente.setNome(scan.nextLine());

        System.out.println("E-mail:");
        cliente.setEmail(scan.nextLine());

        System.out.println("CPF(somente números):");
        cliente.setCpf(scan.nextLine());

        System.out.println("ENDERECÇO\nLogradouro:");
        endereco.setLogradouro(scan.nextLine());

        System.out.println("Número:");
        endereco.setNumero(scan.nextLine());

        System.out.println("Bairro:");
        endereco.setBairro(scan.nextLine());

        System.out.println("Complemento:");
        endereco.setComplemento(scan.nextLine());

        System.out.println("Cidade:");
        endereco.setCidade(scan.nextLine());

        System.out.println("CEP:");
        endereco.setCep(scan.nextLine());

        clienteController.cadastrar(cliente);

        cliente.setIdCliente(clienteController.findByCpf(cliente.getCpf()).getIdCliente());
        endereco.setCliente(cliente);

        enderecoController.cadastrar(endereco);
        int resposta;
        while (outroctt){
            cadastroTelefone.exibir(cliente);
            System.out.println("Deseja cadastrar outro contato?\n (1)sim \n (2)Não ");
            resposta = scan.nextInt();

            if(resposta == 1){
                outroctt = Boolean.TRUE;
            }else{
                outroctt = Boolean.FALSE;
            }
        }


    }
}
