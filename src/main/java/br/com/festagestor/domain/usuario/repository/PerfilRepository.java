package br.com.festagestor.domain.usuario.repository;

import br.com.festagestor.domain.usuario.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
