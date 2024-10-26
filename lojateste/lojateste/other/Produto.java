package other;

public class Produto {

	int codigo;
	String nome;
	double preco;
	double estoque;
	boolean excluido;

	public Produto() {
	}

	public Produto(String nome, double preco, double estoque) {
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.excluido = false;
	}

	public Produto(Produto outro) {
		if (outro != null) {
			this.codigo = outro.codigo;
			this.nome = outro.nome;
			this.preco = outro.preco;
			this.estoque = outro.estoque;
			this.excluido = outro.excluido;
		}
	}

	public Produto criarProduto(String nome, double preco, double estoque) {
		boolean confirmacao = true;

		// Verificar se o preço é válido
		if (preco <= 0) {
			confirmacao = false;
		}

		// Verificar se a quantidade em estoque é válida
		if (estoque < 0) {
			confirmacao = false;
		}

		// Se todas as verificações passarem, cria um novo Produto
		if (confirmacao) {
			return new Produto(nome, preco, estoque);
		} else {
			System.out.println("Valor ou valores inválidos");
			return null; // Retorna null se os valores forem inválidos
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public boolean setNome(String nome) {
		if ((nome != null) && (nome.length() > 2)) {
			this.nome = nome;
			return true;
		}
		return false;
	}

	public double getPreco() {
		return preco;
	}

	public boolean setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco;
			return true;
		}
		return false;
	}

	public double getEstoque() {
		return estoque;
	}

	public boolean setEstoque(double estoque) {
		if (estoque > 0) {
			this.estoque = estoque;
			return true;
		}
		return false;
	}

	public boolean getExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}
}
