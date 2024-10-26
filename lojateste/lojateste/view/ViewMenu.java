package view;

import java.util.Scanner;

public class ViewMenu {
    private Scanner scn;

    public ViewMenu() {
        scn = new Scanner(System.in);
    }

    public int menuInicial() {

        System.out.println("[Bem-Vindo!]");
        System.out.println("0 - Sair");
        System.out.println("1 - Login");
        System.out.println("2 - Cadastro");
        return scn.nextInt();
    }
}
