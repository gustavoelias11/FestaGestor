package br.com.festagestor.domain.usuario.dto;

import br.com.festagestor.domain.usuario.model.Usuario;

public record DadosListagemUsuario(
        Long id,
        String login
) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin());
    }
}
