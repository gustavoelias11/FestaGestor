package br.com.festagestor.domain.cliente.repository;

import br.com.festagestor.domain.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByAtivoTrue();

    @Query("""
    SELECT COUNT(c) FROM Cliente c WHERE c.ativo = true
    """)
    Long contaClientes();
}
