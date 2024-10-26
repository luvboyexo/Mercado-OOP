package controle;

import dados.ProdutoArray;
import dados.Usuario;
import view.*;
import java.util.Scanner;

public class SistemaAlterado {
    private ControleProduto controleProduto;
    private ProdutoArray produtoArray;
    private ViewAtendente viewAtendente;
    private ViewAdmin viewAdmin;
    private ViewMenu viewMenu;
    private ViewProduto viewProduto;
    private Usuario usuario;
    private Scanner scn = new Scanner(System.in);

    private static SistemaAlterado instance; // armazenar o (unico) objeto Sistema

    private SistemaAlterado() {
        controleProduto = new ControleProduto();
        produtoArray = new ProdutoArray();
        viewAtendente = new ViewAtendente();
        viewProduto = new ViewProduto();
        viewAdmin = new ViewAdmin();
        viewMenu = new ViewMenu();
        usuario = new Usuario();
        produtoArray.init();
    }

    // singleton
    public static SistemaAlterado getInstance() {
        if (instance == null)
            return new SistemaAlterado();
        return instance;
    }

    public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println();
    }

    public void iniciar() {
        // init(sistema);
        int opcao;
        boolean confirmacaoLogin = false;
        opcao = viewMenu.menuInicial();
        while (confirmacaoLogin != true) {
            if (opcao == 0) {
                System.out.println("[Sistema Desligado]");
                break;
            }
            if (opcao == 1) {
                if (usuario.login()) {
                    System.out.println(usuario.getTipo());
                    if (usuario.getTipo() == 1) {
                        sistemaAtendente();
                    }
                    if (usuario.getTipo() == 2) {
                        sistemaAdmin();
                    }
                }
            }
            if (opcao == 2) {
                usuario.cadastro();
            }
            opcao = viewMenu.menuInicial();
        }

    }

    public void sistemaAdmin() {
        int opcao = viewAdmin.menuPrincipal();
        do {
            switch (opcao) {
                case 0: // sair
                    break;

                case 1: // inserir produto
                    addProduto();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 2: // excluir produto
                    excluirProduto();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 3: // alterar produto
                    alterarProduto();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 4: // listar produtos
                    viewProduto.listar();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 5: // listar em ordem alfabetica
                    listarProdutosEmOrdem();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 6: // listar vendas
                    listarVendas();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 7: // listar vendas do dia
                    listarVendasDia();
                    opcao = viewAdmin.menuPrincipal();
                    break;

                case 8: // listar produtos excluidos
                    viewProduto.listarExcluidos();
                    opcao = viewAdmin.menuPrincipal();
                    break;

            }

        } while (opcao != 0);
    }

    public void sistemaAtendente() {
        int opcao = viewAtendente.menuPrincipal();
        do {
            switch (opcao) {
                case 0: // sair
                    opcao = 0;
                    break;

                case 1: // adicionar produto ao carrinho
                    viewAtendente.adicionarCarrinho();
                    opcao = viewAtendente.menuPrincipal();
                    break;

                case 2: // buscar produto
                    System.out.println("Escreva o codigo do produto: ");
                    buscarProdutoCodigo();
                    opcao = viewAtendente.menuPrincipal();
                    break;

                case 3: // listar todos os produtos
                    viewProduto.listar();
                    opcao = viewAtendente.menuPrincipal();
                    break;

                case 4: // listar todos os produtos em ordem alfabetica
                    listarProdutosEmOrdem();
                    opcao = viewAtendente.menuPrincipal();
                    break;

            }

        } while (opcao != 0);
    }

    public void listarVendas() {
        controleProduto.listarVendas();
    }

    public void listarVendasDia() {
        controleProduto.listarVendasDia();
    }

    public void listarExcluidos() {
        controleProduto.listarExcluidos();
    }

    public void addProduto() {
        controleProduto.add();
    }

    public void alterarProduto() {
        controleProduto.alterar();
    }

    public void buscarProdutoNome() {
        controleProduto.buscar(scn.nextLine());
    }

    public void buscarProdutoCodigo() {
        controleProduto.buscar(scn.nextInt());
    }

    public void excluirProduto() {
        controleProduto.excluir();
    }

    public void listarProdutos() {
        controleProduto.listar();
    }

    public void listarProdutosEmOrdem() {
        controleProduto.listarEmOrdem();
    }

}
