package model;

public abstract class Item {
    private int quantidadeEstoque;
    private String descricao;
    private double preco;

    public Item(int quantidadeEstoque, String descricao, double preco) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
