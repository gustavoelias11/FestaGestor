package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> listaDeClientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        listaDeClientes.add(cliente);
        System.out.println("O cliente: " + cliente + " foi cadastrado com sucesso!");
    }

    public List<Cliente> buscarClientes() {
        return listaDeClientes;
    }
}
