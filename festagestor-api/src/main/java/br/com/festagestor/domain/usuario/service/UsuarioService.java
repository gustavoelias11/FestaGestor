package br.com.festagestor.domain.usuario.service;

import br.com.festagestor.domain.shared.exception.IdNaoEncontradoException;
import br.com.festagestor.domain.usuario.dto.DadosCadastroUsuario;
import br.com.festagestor.domain.usuario.dto.DadosListagemUsuario;
import br.com.festagestor.domain.usuario.model.Usuario;
import br.com.festagestor.domain.usuario.repository.PerfilRepository;
import br.com.festagestor.domain.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, PerfilRepository perfilRepository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DadosListagemUsuario cadastrar(DadosCadastroUsuario dados) {
        var perfil = perfilRepository.findById(1L).orElseThrow(() -> new IdNaoEncontradoException("Perfil", 1L));
        var senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuarioCadastrado = new Usuario(dados, senhaCriptografada, perfil);
        repository.save(usuarioCadastrado);
        return new DadosListagemUsuario(usuarioCadastrado);
    }
}
