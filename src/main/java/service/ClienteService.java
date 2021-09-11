package service;

import dao.ClienteDAO;
import dao.EnderecoDAO;
import entity.Cliente;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }

    public void cadastrar(Cliente cliente){
        this.clienteDAO.insert(cliente);
    }

    public Cliente findByCpf(String cpf){
       return this.clienteDAO.findByCpf(cpf);
    }
}
