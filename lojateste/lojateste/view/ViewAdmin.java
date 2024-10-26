package view;

import java.util.Scanner;

public class ViewAdmin {
    private Scanner scn;

    public ViewAdmin() {
        scn = new Scanner(System.in);
    }

    public int menuPrincipal() {

        System.out.println();
        System.out.println("[- MODULO ADMINISTRADOR -]");
        System.out.println("0 - Sair");
        System.out.println("1 - Inserir Produto");
        System.out.println("2- Excluir Produto");
        System.out.println("3- Alterar Produto");
        System.out.println("4- Listar Todos Produtos");
        System.out.println("5- Listar Todos Produtos Em Ordem Alfabética");
        System.out.println("6- Listar Todas as Vendas");
        System.out.println("7- Listar as Vendas de um Determinado Dia");
        System.out.println("8- Listar Produtos Excluidos");
        return scn.nextInt();
    }
}
