package view;

import java.util.Scanner;

import dados.ProdutoArray;
import other.Produto;
//import controle.SistemaAlterado;

public class ViewProduto {
	private Scanner scn;

	private int tamCod = 10; // tamanho das colunas
	private int tamNom = 10;
	private int tamPre = 10;
	private int tamEsto = 10;

	public ViewProduto() {
		scn = new Scanner(System.in);
	}

	public Produto add() {
		System.out.println();
		System.out.println(" [- Inserir produto -]");
		Produto p = lerProduto();
		return p;
	}

	Produto lerProduto() {

		Produto p = new Produto();
		ProdutoArray produtoArray = new ProdutoArray();
		System.out.print("Nome: ");
		boolean confirm = false;
		String nome = scn.nextLine();

		while (!confirm) {
			if (produtoArray.buscar(nome) == null) {
				p.setNome(nome);
				confirm = true;
			} else {
				System.out.println("Nome já existe");
				System.out.print("Nome: ");
				nome = scn.nextLine();
			}

		}

		System.out.print("Preço: ");
		double preco = scn.nextDouble();
		while (!(p.setPreco(preco))) {
			System.out.print("ERRO! Preço inválido, reescreva: ");
			preco = scn.nextDouble();
		}

		System.out.print("Quant. Estoque: ");
		int estoque = scn.nextInt();
		while (!(p.setEstoque(estoque))) {
			System.out.print("ERRO! Estoque inválido, reescreva: ");
			estoque = scn.nextInt();
		}
		scn.nextLine();
		return p;
	}

	public void print(String msg) {
		System.out.println(msg);
	}

	public void listar(Produto[] produtos) {
		System.out.println("[- Lista de produtos -]");
		System.out.printf(
				"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre + "s%-"
						+ tamEsto + "s\n",
				"CÓDIGO", "NOME", "PREÇO", "ESTOQUE");

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getExcluido() == false) {
					System.out.printf(
							"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre
									+ "s%-" + tamEsto + "s\n",
							produtos[i].getCodigo(), produtos[i].getNome(),
							produtos[i].getPreco(), produtos[i].getEstoque());

				}
			}
		}
	}

	public void listarExcluidos(Produto[] produtos) {
		System.out.println("[- Lista de produtos Excluidos -]");
		System.out.printf(
				"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre + "s%-"
						+ tamEsto + "s\n",
				"CÓDIGO", "NOME", "PREÇO", "ESTOQUE");

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getExcluido()) {
					System.out.printf(
							"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre
									+ "s%-" + tamEsto + "s\n",
							produtos[i].getCodigo(), produtos[i].getNome(),
							produtos[i].getPreco(), produtos[i].getEstoque());

				}
			}

		}
	}

	public void listarExcluidos() {
		System.out.println("[- Lista de produtos -]");
		System.out.printf(
				"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre + "s%-"
						+ tamEsto + "s\n",
				"CÓDIGO", "NOME", "PREÇO", "ESTOQUE");

		for (int i = 0; i < ProdutoArray.getInstance().length; i++) {
			if (ProdutoArray.getInstance()[i] != null) {
				if (ProdutoArray.getInstance()[i].getExcluido()) {
					System.out.printf(
							"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre
									+ "s%-" + tamEsto + "s\n",
							ProdutoArray.getInstance()[i].getCodigo(), ProdutoArray.getInstance()[i].getNome(),
							ProdutoArray.getInstance()[i].getPreco(), ProdutoArray.getInstance()[i].getEstoque());

				}
			}
		}
	}

	public void listar() {
		System.out.println("[- Lista de produtos -]");
		System.out.printf(
				"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre + "s%-"
						+ tamEsto + "s\n",
				"CÓDIGO", "NOME", "PREÇO", "ESTOQUE");

		for (int i = 0; i < ProdutoArray.getInstance().length; i++) {
			if (ProdutoArray.getInstance()[i] != null) {
				if (!ProdutoArray.getInstance()[i].getExcluido()) {
					System.out.printf(
							"%-" + tamCod + "s%-" + tamNom + "s%-" + tamPre
									+ "s%-" + tamEsto + "s\n",
							ProdutoArray.getInstance()[i].getCodigo(), ProdutoArray.getInstance()[i].getNome(),
							ProdutoArray.getInstance()[i].getPreco(), ProdutoArray.getInstance()[i].getEstoque());

				}
			}
		}
	}

	public int lerCodigo() {
		System.out.print("Digite o codigo: ");
		return scn.nextInt();
	}

	public Produto alteracao(Produto p) {

		boolean continuar = true;

		while (continuar) {
			System.out.println();
			System.out.println("[O que deseja alterar?]");
			System.out.println("1- Nome do produto");
			System.out.println("2- Preço do produto");
			System.out.println("3- Estoque do produto");
			System.out.println();
			int opcao = scn.nextInt();
			System.out.println();

			if (opcao == 1) {
				System.out.print("Novo nome: ");
				scn.nextLine();
				String nome = scn.nextLine();
				while (!(p.setNome(nome))) {
					nome = scn.nextLine();
				}
			} else {
				if (opcao == 2) {
					System.out.println();
					System.out.print("Novo preço: ");
					double preco = scn.nextDouble();
					while (!(p.setPreco(preco))) {
						System.out.println(
								"ERRO! Preço inválido, reescreva: ");
						preco = scn.nextDouble();
					}
				} else {
					if (opcao == 3) {
						System.out.println();
						System.out.print("Novo estoque: ");
						int estoque = scn.nextInt();
						while (!(p.setEstoque(estoque))) {
							System.out.println(
									"ERRO! Estoque inválido, reescreva: ");
							estoque = scn.nextInt();
						}
					} else {
						System.out.println("ERRO! Opção inválida");
						return null;
					} // fim else 3
				} // fim else 2
			} // fim else 1

			System.out.println();
			System.out.println("0- Sair");
			System.out.println("1- Alterar outra informação");
			opcao = scn.nextInt();
			if (opcao == 0)
				continuar = false;

		} // fim while

		return p;
	}

}
