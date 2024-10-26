package view;

import java.util.Scanner;

public class ViewCadastro {
    private Scanner scn;

    public ViewCadastro() {
        scn = new Scanner(System.in);
    }

    public String nomeUsuarioCadastro() {

        System.out.println();
        System.out.println("Nome de Usuario: ");
        scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public String senhaCadastro() {

        System.out.println();
        System.out.println("Senha: ");
        scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public int tipo() {

        System.out.println();
        System.out.println("Tipo da Conta (1 - Atendente / 2 - Admin): ");
        scn = new Scanner(System.in);
        return scn.nextInt();
    }

    public void mensagemSucesso() {
        System.out.println("[Cadastro Realizado com Sucesso!]");
    }

    public void mensagemErro() {
        System.out.println("[Erro no cadastro: Usuario ou senha invalidos!]");

    }

}
