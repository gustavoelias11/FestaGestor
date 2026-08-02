package br.com.festagestor.domain.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank
        String login,
        @NotBlank
        @Size(min = 8, max = 100)
        String senha
) {
}
