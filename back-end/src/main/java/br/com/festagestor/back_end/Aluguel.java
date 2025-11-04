package br.com.festagestor.back_end;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

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
