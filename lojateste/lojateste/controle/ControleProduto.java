package controle;

import other.Produto;
import dados.ProdutoArray;
import view.ViewProduto;

public class ControleProduto {
	private ProdutoArray repoProduto;
	private ViewProduto viewProduto;
	private Produto produto = new Produto();

	public ControleProduto() {
		repoProduto = new ProdutoArray();
		viewProduto = new ViewProduto();
	}

	public boolean add() {
		// chamar a (tela/view) leitura de produto
		Produto p = viewProduto.add();
		if (p != null && repoProduto.buscar(p.getNome()) == null) {
			if (repoProduto.add(p)) {
				System.out.println("Produto adicionado ao vetor com sucesso!");
				return true;
			}
		}
		viewProduto.print("ERRO! Operação não concluída ");
		return false;
	}

	public void excluir() {
		// listar
		viewProduto.listar();
		// ler o codigo
		int codigo = viewProduto.lerCodigo();
		// executar a exclusao
		if (repoProduto.excluir(codigo))
			viewProduto.print("Produto excluido com sucesso");
		else
			viewProduto.print("Falha em excluir produto");
	}

	public void alterar() {
		// listar
		viewProduto.listar();
		// ler codigo do produto a ser alterado
		int codigo = viewProduto.lerCodigo();
		// buscar o produto
		Produto p = repoProduto.buscar(codigo);
		if (p == null) {
			viewProduto.print("ERRO! Código inexistente");
		} else {
			// alterar os dados do produto
			Produto produtoAlterado = viewProduto.alteracao(p);
			if (repoProduto.buscar(produtoAlterado.getNome()) != null)
				viewProduto.print("Erro! Nome ja existe");
			else {
				// alterar (efetivar a alteracao)
				if (repoProduto.alterar(produtoAlterado))
					viewProduto.print(
							"Dados do produto alterados com sucesso");
				else
					viewProduto.print("Operacao nao concluida");
			}
		}

	}

	public void listar() {
		Produto[] produtos = repoProduto.listar();
		viewProduto.listar(produtos);
	}

	public void listarEmOrdem() {
		Produto[] produtos = repoProduto.listarAlfabetico();
		viewProduto.listar(produtos);
	}

	public void listarExcluidos() {
		Produto[] produtos = repoProduto.listar();
		viewProduto.listarExcluidos(produtos);
	}

	public void buscar(String nome) {
		repoProduto.buscar(nome);
	}

	public void buscar(int codigo) {
		repoProduto.buscar(codigo);
	}

	public void listarVendas() {
		repoProduto.listarVendas();
	}

	public void listarVendasDia() {
		repoProduto.listarVendasDia();
	}

	public void buscarVenda(int codigo) {
		repoProduto.buscarVenda(codigo);
	}

}
