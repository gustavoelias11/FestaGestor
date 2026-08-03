package br.com.festagestor.domain.usuario.controller;

import br.com.festagestor.domain.usuario.dto.DadosAutenticacao;
import br.com.festagestor.domain.usuario.dto.DadosTokenJWT;
import br.com.festagestor.domain.usuario.model.Usuario;
import br.com.festagestor.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        var usuarioLogado = (Usuario) authentication.getPrincipal();

        var tokenJWT = tokenService.gerarToken(usuarioLogado);

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
