package dados;

import java.time.LocalDateTime;

import other.Produto;
import other.Venda;

public class ProdutoArray {
	private int numinstanceArray = 0;
	private static Produto[] instanceArray;

	public static Produto[] getInstance() {
		if (instanceArray == null) {
			instanceArray = new Produto[50];
			return instanceArray;
		} else {
			return instanceArray;
		}
	}

	public void imprimirArray() {
		for (int i = 0; i < instanceArray.length; i++) {
			if (instanceArray[i] != null) {
				System.out.println(instanceArray[i].getNome());
			}
		}
	}

	public boolean add(Produto produto) {
		if (produto != null) {
			for (int i = 0; i < instanceArray.length; i++) {
				if (instanceArray[i] == null) {
					produto.setCodigo(i + 1);
					instanceArray[i] = produto;
					numinstanceArray++;
					return true;
				}
			}
		}
		return false;
	}

	public boolean alterar(Produto produto) {
		if (produto != null) {
			for (int i = 0; i < numinstanceArray; i++) {
				if (produto.getCodigo() == instanceArray[i].getCodigo()) {
					instanceArray[i] = produto;
					return true;
				}
			}
		}
		return false;
	}

	public boolean excluir(int cod) {
		for (int i = 0; i < instanceArray.length; i++) {
			if (instanceArray[i] != null && instanceArray[i].getCodigo() == cod) {
	
				// Verifica se o produto já foi vendido
				boolean foiVendido = false;
	
				for (int j = 0; j < Venda.totalVendas.length; j++) {
					if (Venda.totalVendas[j] != null) {
						for (int j2 = 0; j2 < Venda.totalVendas[j].getItensComprados().length; j2++) {
							if (Venda.totalVendas[j].getItensComprados()[j2].getProduto() == instanceArray[i]) {
								foiVendido = true;
								break;
							}
						}
					}
					if (foiVendido) {
						break;
					}
				}
	
				// Se o produto já foi vendido, marcá-lo como excluído
				if (foiVendido) {
					instanceArray[i].setExcluido(true);
				} else {
					// Se não foi vendido, remover da lista
					instanceArray[i] = null;
				}
				return true;
			}
		}
		return false;
	}
	

	public Produto buscar(int codigo) {
		for (int i = 0; i < instanceArray.length; i++) {
			if (instanceArray[i] != null) {
				if (instanceArray[i].getCodigo() == codigo) {
					System.out.println(
							"O produto de codigo " + codigo + " foi encontrado:  " + instanceArray[i].getNome());
					return instanceArray[i];
				}

			}
		}
		System.out.println("Não foi encontrado o produto de codigo: " + codigo);
		return null;
	}

	public Produto buscar(String nome) {
		if (nome != null) {
			for (int i = 0; i < numinstanceArray; i++) {
				if (instanceArray[i].getNome().equals(nome))
					return instanceArray[i];
			}
		}
		return null;
	}

	public boolean buscarBooleano(int codigo) {
		for (int i = 0; i < numinstanceArray; i++) {
			if (instanceArray[i].getCodigo() == codigo)
				return true;
		}
		return false;
	}

	public Produto[] listar() {
		Produto[] aux = new Produto[numinstanceArray];
		for (int i = 0; i < numinstanceArray; i++) {
			aux[i] = instanceArray[i]; // Não precisa criar novos objetos
		}
		return aux;
	}

	public Produto[] listarAlfabetico() {
		Produto[] instanceArrayOrdenados = getInstance();
		int count = instanceArrayOrdenados.length;

		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - 1 - i; j++) {
				if (instanceArrayOrdenados[j] != null && instanceArrayOrdenados[j + 1] != null) {
					if (instanceArrayOrdenados[j].getNome()
							.compareToIgnoreCase(instanceArrayOrdenados[j + 1].getNome()) > 0) {
						Produto temp = instanceArrayOrdenados[j];
						instanceArrayOrdenados[j] = instanceArrayOrdenados[j + 1];
						instanceArrayOrdenados[j + 1] = temp;
					}
				}
			}
		}

		return instanceArrayOrdenados;
	}

	public void listarVendas() {
		for (int i = 0; i < Venda.totalVendas.length; i++) {
			if (Venda.totalVendas[i] != null) {
				System.out.println("Codigo Da Venda: " + Venda.totalVendas[i].getCodigo());
				System.out.println("Data Da Venda: " + Venda.totalVendas[i].getDataCriacao());
				System.out.println("Valor Da Venda: " + Venda.totalVendas[i].getTotal());
				System.out.println("=================================================");
			}
		}
	}

	public void listarVendasDia() {
		for (int i = 0; i < Venda.totalVendas.length; i++) {
			int diaDeHoje = LocalDateTime.now().getDayOfMonth();
			if (Venda.totalVendas[i] != null) {
				if (diaDeHoje == Venda.totalVendas[i].getDataCriacao().getDayOfMonth()) {
					System.out.println("Codigo Da Venda: " + Venda.totalVendas[i].getCodigo());
					System.out.println("Data Da Venda: " + Venda.totalVendas[i].getDataCriacao());
					System.out.println("Valor Da Venda: " + Venda.totalVendas[i].getTotal());
					System.out.println("=================================================");
				}
			}
		}
	}

	public Venda buscarVenda(int cod) {
		for (int i = 0; i < Venda.totalVendas.length; i++) {
			if (Venda.totalVendas[i] != null) {
				if (Venda.totalVendas[i].getCodigo() == cod) {
					return Venda.totalVendas[i];
				}
			}
		}
		return null;
	}

	public void init() {
		Produto produto = new Produto();
		Produto[] produtos = getInstance();
		Produto p1 = produto.criarProduto("Fanta Lata", 4, 3);
		Produto p2 = produto.criarProduto("Manteiga", 2.5, 500);
		Produto p3 = produto.criarProduto("Agua", 6, 300);
		Produto p4 = produto.criarProduto("Iogurte Morango", 10, 200);
		Produto p5 = produto.criarProduto("Kit-Kat", 7, 700);

		if (add(p1)) {
			System.out.println("Produto 1 adicionado com sucesso.");
		}
		if (add(p2)) {
			System.out.println("Produto 2 adicionado com sucesso.");
		}
		if (add(p3)) {
			System.out.println("Produto 3 adicionado com sucesso.");
		}
		if (add(p4)) {
			System.out.println("Produto 4 adicionado com sucesso.");
		}
		if (add(p5)) {
			System.out.println("Produto 5 adicionado com sucesso.");
		}

		Item[] itensComprados = new Item[3];
		itensComprados[0] = Item.criarItem(getInstance()[3], 5);
		itensComprados[1] = Item.criarItem(getInstance()[4], 7);
		itensComprados[2] = Item.criarItem(getInstance()[2], 9);

		Venda.criarVenda(itensComprados, "Pedro");

		itensComprados = new Item[3];
		itensComprados[0] = Item.criarItem(getInstance()[1], 5);
		itensComprados[1] = Item.criarItem(getInstance()[2], 7);
		itensComprados[2] = Item.criarItem(getInstance()[3], 9);

		Venda.criarVenda(itensComprados, "Amanda");
	}
}
