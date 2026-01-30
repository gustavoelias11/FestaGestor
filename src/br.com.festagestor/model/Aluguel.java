package model;

import java.time.LocalDate;
import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private List<Item> itens;
    private LocalDate dataFesta;
    private double valorTotal;
    private String status;
    private int idAluguel;
    private static int contador = 1;

    public Aluguel(Cliente cliente, List<Item> itens, LocalDate dataFesta) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataFesta = dataFesta;
        this.status = "Aberto";
        this.idAluguel = contador++;
        calcularValorTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public LocalDate getDataFesta() {
        return dataFesta;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void calcularValorTotal() {
        double soma = 0;
        for (Item itemDaVez : this.itens) {
            soma = soma + itemDaVez.getPreco();
        }

        this.valorTotal = soma;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aluguel: " +
                "ID: [" + idAluguel +
                "]" + cliente +
                ", Data da Festa: " + dataFesta +
                ", Valor Total: R$" + valorTotal
                ;
    }
}
