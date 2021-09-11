package service;

import dao.TelefoneDAO;
import entity.Telefone;

public class TelefoneService {
    private TelefoneDAO telefoneDAO;

    public TelefoneService() {
        this.telefoneDAO = new TelefoneDAO();
    }

    public void cadastrar(Telefone telefone){
        this.telefoneDAO.insert(telefone);
    }
}
