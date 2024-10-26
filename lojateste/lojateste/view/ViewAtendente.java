package view;

import java.util.Scanner;

import other.Produto;
import other.Venda;
import dados.*;

public class ViewAtendente {
    private Scanner scn;
    private ProdutoArray produtos = new ProdutoArray();
    private Carrinho carrinho = new Carrinho();

    public ViewAtendente() {
        scn = new Scanner(System.in);
    }

    public int menuPrincipal() {

        System.out.println("[- MODULO ATENDENTE -]");
        System.out.println("0 - Sair");
        System.out.println("1 - Adicionar Produto ao Carrinho");
        System.out.println("2- Buscar Produto");
        System.out.println("3- Listar Todos Produtos");
        System.out.println("4- Listar Todos Produtos Em Ordem Alfabética");
        return scn.nextInt();
    }

    public void adicionarCarrinho() {
        int cod;
        int simnao;
        String nome;
        boolean sairCarrinho = false;
        System.out.println("Escreva seu nome: ");
        nome = scn.nextLine();
        nome = scn.nextLine();

        while (!sairCarrinho) {
            System.out.println("Escreva o código do produto: ");
            cod = scn.nextInt();

            // Usar o produto já instanciado no escopo externo
            Produto produto = produtos.buscar(cod);

            if (produto == null) {
                System.out.println("[ERRO! Produto inválido!]");
                break;
            }

            System.out.println("Escreva a Quantidade: ");
            double quantidade = scn.nextDouble();
            Item item = Item.criarItem(produto, quantidade);
            carrinho.adicionaCarrinho(item);
            

            System.out.println("[Produto adicionado ao carrinho com sucesso!]");

            System.out.println("Deseja adicionar mais itens? (1 - Sim, 0 - Não): ");
            simnao = scn.nextInt();
            if (simnao == 0) {
                Venda.criarVenda(carrinho.getCarrinho(), nome);
                System.out.println("[Venda realizada com sucesso!]");
                sairCarrinho = true;
            }
        }
    }
}