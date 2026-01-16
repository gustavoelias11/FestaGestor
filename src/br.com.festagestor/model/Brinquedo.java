package model;

public class Brinquedo extends Item{
    private String tipo;
    private int capacidadeMaxima;

    public Brinquedo(int quantidadeEstoque, String descricao, double preco, String tipo, int capacidadeMaxima) {
        super(quantidadeEstoque, descricao, preco);
        this.tipo = tipo;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade Máxima: " + capacidadeMaxima;
    }
}
