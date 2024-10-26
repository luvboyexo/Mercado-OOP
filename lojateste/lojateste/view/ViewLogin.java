package view;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scn;

    public ViewLogin() {
        scn = new Scanner(System.in);
    }

    public String NomeUsuarioLogin() {

        System.out.println();
        System.out.println("Nome de Usuario: ");
        return scn.nextLine();
    }

    public String SenhaLogin() {

        System.out.println();
        System.out.println("Senha: ");
        return scn.nextLine();
    }

    public void mensagemSucesso() {
        System.out.println("[Login realizado com sucesso!]");
    }

    public void mensagemErro() {
        System.out.println("[Falha em realizar Login]");
    }
}
