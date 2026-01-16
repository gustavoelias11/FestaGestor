package service;

import model.Cliente;
import repository.ClienteRepository;

import java.util.List;

public class CadastraClienteService {
    private ClienteRepository repository = new ClienteRepository();

    public void cadastrar(Cliente cliente) {
        repository.salvar(cliente);
    }

    public List<Cliente> listarTodosClientes() {
        return repository.buscarClientes();
    }
}
