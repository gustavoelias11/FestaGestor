package model;

public class Decoracao extends Item{
    private String tema;

    public Decoracao(int quantidadeEstoque, String descricao, double preco, String tema) {
        super(quantidadeEstoque, descricao, preco);
        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tema: " + tema;
    }
}
