package dados;

import other.Produto;

public class Item {

    private Produto produto;
    private double preco;
    private double quantidade;
    //private ProdutoArray produtosArray = new ProdutoArray();

    // Construtor privado para forçar o uso do método fábrica
    private Item(Produto produto, double quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = produto.getPreco() * quantidade;
    }

    // Método fábrica para criar um novo Item
    public static Item criarItem(Produto produto, double quantidade) {
        if (quantidade <= 0) {
            System.out.println("Valor ou valores inválidos");
            return null; // Retorna null se a quantidade for inválida
        }

        return new Item(produto, quantidade); // Cria e retorna um novo objeto Item
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public double getQuantidade() {
        return quantidade;
    }

}

