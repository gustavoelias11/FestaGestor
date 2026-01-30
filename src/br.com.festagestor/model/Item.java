package model;

public abstract class Item {
    private int quantidadeEstoque;
    private int quantidadeDisponivel;
    private String descricao;
    private double preco;

    public Item(int quantidadeEstoque, String descricao, double preco) {
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeDisponivel = quantidadeEstoque;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
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

    @Override
    public String toString() {
        return "Item : " + descricao + ", Preço: " + preco;
    }

    public void reservarItem(int quantidade) {
        if(quantidade <= this.quantidadeDisponivel) {
            this.quantidadeDisponivel -= quantidade;
        } else {
            System.out.println("Erro: não há estoque suficiente");
        }
    }

    public void devolverItem(int quantidade) {
        this.quantidadeDisponivel += quantidade;
    }
}
