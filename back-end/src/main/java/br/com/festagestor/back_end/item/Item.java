package br.com.festagestor.back_end.item;

import jakarta.persistence.*; // <-- Import necessário
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "itens")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private BigDecimal valor;
    private String responsavel;
}
