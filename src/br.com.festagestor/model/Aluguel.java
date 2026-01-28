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

    public Aluguel(Cliente cliente, List<Item> itens, LocalDate dataFesta, String status, int idAluguel) {
        this.cliente = cliente;
        this.itens = itens;
        this.dataFesta = dataFesta;
        this.status = "Aberto";
        this.idAluguel = idAluguel;
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

    @Override
    public String toString() {
        return "Aluguel{" +
                "idAluguel=" + idAluguel +
                ", cliente=" + cliente +
                ", dataFesta=" + dataFesta +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
