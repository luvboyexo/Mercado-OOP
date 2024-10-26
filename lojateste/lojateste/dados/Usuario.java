package dados;

import view.ViewCadastro;
import view.ViewLogin;

public class Usuario {

    private String nome;
    private String senha;
    private int tipo;
    private ViewCadastro viewCadastro = new ViewCadastro();
    private ViewLogin viewLogin = new ViewLogin();

    private static Usuario[] instanceArray;

    public static Usuario[] getInstance() {
        if (instanceArray == null) {
            instanceArray = new Usuario[50];
            return instanceArray;
        } else {
            return instanceArray;
        }
    }

    private int numUsuario;

    public Usuario() {

    }

    private Usuario(String nome, String senha, int tipo) {
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public boolean existe(String nome) {
        for (int i = 0; i < numUsuario; i++) {
            if (getInstance()[i].getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Usuario usuario) {
        if (usuario != null && numUsuario < getInstance().length && !existe(usuario.getNome()) && usuario.nome != ""
                && usuario.senha != "") {
            getInstance()[numUsuario] = usuario;
            numUsuario++;
            return true;
        } else {
            return false;
        }

    }

    public void cadastro() {
        String nome = viewCadastro.nomeUsuarioCadastro();
        String senha = viewCadastro.senhaCadastro();
        int tipo = 0;
        while (tipo < 1 || tipo > 2) {
            tipo = viewCadastro.tipo();
        }

        Usuario usuario = new Usuario(nome, senha, tipo);
        // System.out.println(add(usuario));
        if (add(usuario) == true) {
            viewCadastro.mensagemSucesso();
        } else {
            viewCadastro.mensagemErro();
        }
    }

    public boolean login() {
        String nome = viewLogin.NomeUsuarioLogin();
        String senha = viewLogin.SenhaLogin();

        for (int i = 0; i < numUsuario; i++) {
            Usuario usuario = getInstance()[i];
            if (usuario.nome.equals(nome) && usuario.senha.equals(senha)) {
                viewLogin.mensagemSucesso();

                // Definindo o tipo do usuário logado
                this.tipo = usuario.getTipo();
                return true; // Login bem-sucedido
            }
        }

        viewLogin.mensagemErro();
        return false; // Login falhou
    }

}
