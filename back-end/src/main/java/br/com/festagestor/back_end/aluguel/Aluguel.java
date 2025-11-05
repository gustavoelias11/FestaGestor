package br.com.festagestor.back_end.aluguel;

import br.com.festagestor.back_end.cliente.Cliente;
import br.com.festagestor.back_end.item.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "alugueis")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDaFesta;
    private String status;
    private BigDecimal valorTotal;

    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Item> itensDaFesta;
}
