package service;

import dao.EnderecoDAO;
import entity.Endereco;

public class EnderecoService {

    public void cadastrar(Endereco endereco){
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        enderecoDAO.insert(endereco);
    }
}
