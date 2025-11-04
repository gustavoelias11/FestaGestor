package br.com.festagestor.back_end;

import jakarta.persistence.*; // <-- Import necessário
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
}
