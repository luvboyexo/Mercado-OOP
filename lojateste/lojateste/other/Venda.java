package other;

import java.time.LocalDateTime;

import dados.Item;

public class Venda {
    private int codigo;
    private Item[] itensComprados;
    private double total;
    private String nomeCliente;
    private LocalDateTime dataCriacao;
    public static Venda[] totalVendas = new Venda[100];


    // Construtor privado para forçar o uso do método fábrica
    private Venda(Item[] itensComprados, String nomeCliente) {
        this.codigo = gerarCodigo();
        this.itensComprados = itensComprados;
        for (int i = 0; i < itensComprados.length; i++) {
            if (itensComprados[i] != null) {
                this.total += itensComprados[i].getPreco();
            }
        }
        this.nomeCliente = nomeCliente;
        this.dataCriacao = LocalDateTime.now();

        for (int i = 0; i < itensComprados.length; i++) {
            if (itensComprados[i] != null) {
                Produto produto = itensComprados[i].getProduto();
                double novoEstoque = produto.getEstoque() - itensComprados[i].getQuantidade();
                produto.setEstoque(novoEstoque);
            }
        }

        for (int i = 0; i < totalVendas.length; i++) {
            if (totalVendas[i] == null) {
                totalVendas[i] = this;
                System.out.println("Compra efetuada com sucesso! Total: " + this.total);
                break;
            }
        }
    }

    // Método fábrica para criar uma nova Venda
    public static Venda criarVenda(Item[] itensComprados, String nomeCliente) {
        boolean confirmacao = true;

        for (int i = 0; i < itensComprados.length; i++) {
            if (itensComprados[i] != null) {
                Produto produto = itensComprados[i].getProduto();
                if (produto != null) {
                    double estoque = produto.getEstoque() - itensComprados[i].getQuantidade();
                    if (estoque < 0) {
                        confirmacao = false;
                        System.out.println("Item esgotado: " + produto.getNome());
                        break;
                    }
                }
            }
        }

        if (confirmacao) {
            return new Venda(itensComprados, nomeCliente);
        } else {
            System.out.println("Venda não pode ser realizada devido a itens esgotados.");
            return null;
        }
    }

    static public LocalDateTime getDataHoje() {
        LocalDateTime hoje;
        hoje = LocalDateTime.now();
        return hoje;
    }

    public int getCodigo() {
        return codigo;
    }

    public Item[] getItensComprados() {
        return itensComprados;
    }

    public double getTotal() {
        return total;
    }

    public int gerarCodigo() {
        for (int i = 0; i < totalVendas.length; i++) {
            if (totalVendas[i] == null) {
                return i;
            }
        }
        return 0;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

}
