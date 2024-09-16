package list.operacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> items;

    public CarrinhoDeCompras() {
        this.items = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        items.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();
        if (!items.isEmpty()) {
            for (Item i : items) {
                if (nome.equalsIgnoreCase(i.getNome())) {
                    itemsParaRemover.add(i);
                }
            }
        }
        items.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;
        if (!items.isEmpty()) {
            for (Item i : items) {
                valorTotal += i.getPreco() * i.getQuantidade();
            }
        }
        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(items);
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "items=" + items +
                '}';
    }

    public static void main(String[] args) {

        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Sabonete", 2.50, 4);
        carrinhoDeCompras.adicionarItem("Sabonete", 4.30, 2);
        carrinhoDeCompras.adicionarItem("Papel higienico", 16.00, 1);
        carrinhoDeCompras.adicionarItem("Detergente", 3.20, 2);

        carrinhoDeCompras.exibirItens();

        carrinhoDeCompras.removerItem("Sabonete");

        carrinhoDeCompras.exibirItens();

        System.out.println("Valor total: " + carrinhoDeCompras.calcularValorTotal());
    }
}
