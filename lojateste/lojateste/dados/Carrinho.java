package dados;

public class Carrinho {

    private Item[] carrinho = new Item[100];

    public Item[] getCarrinho() {
        return carrinho;
    }

    public boolean adicionaCarrinho(Item item) {

        for (int i = 0; i < carrinho.length; i++) {
            if (carrinho[i] != null) {
                if (item.getProduto() == carrinho[i].getProduto()) {
                    double quant = carrinho[i].getQuantidade();
                    carrinho[i].setQuantidade(quant + item.getQuantidade());
                    System.out.println("Codigo repetido. A quantidade dos produtos será somada.");
                    return true;
                }
            }
        }

        for (int i = 0; i < carrinho.length; i++) {
            if (carrinho[i] == null) {
                carrinho[i] = item;
                return true;
            }
        }
        return false;
    }

    public double totalCarrinho() {
        double total = 0;
        for (int i = 0; i < carrinho.length; i++) {
            if (carrinho[i] != null) {
                total = total + carrinho[i].getPreco();
            }
        }
        return total;
    }
}
