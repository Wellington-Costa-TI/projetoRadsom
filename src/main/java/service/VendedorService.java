package service;

import dao.VendedorDAO;
import entity.Vendedor;

public class VendedorService {
    VendedorDAO vendedorDAO;

    public VendedorService() {
        this.vendedorDAO = new VendedorDAO();;
    }

    public Boolean login(Vendedor vendedor){
        return this.vendedorDAO.logar(vendedor);
    }

    public void cadastrar(Vendedor vendedor){
        this.vendedorDAO.insert(vendedor);
    }
}
