package map.ordenacao;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livraria;

    public LivrariaOnline() {
        this.livraria = new HashMap<>();
    }

    public void adicionarLivro(String link, String titulo, String autor, double preco) {
        livraria.put(link, new Livro(titulo, autor, preco));
    }

    public void removerLivro(String titulo) {
        List<String> linksParaRemover = new ArrayList<>();
        if (!livraria.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    linksParaRemover.add(entry.getKey());
                }
            }
            for (String s : linksParaRemover) {
                livraria.remove(s);
            }
        }
    }

    public Map<String, Livro> obterLivrosOrdenadosPorPreco() {
        List<Map.Entry<String, Livro>> ListaOrdenadaPorPreco = new ArrayList<>(livraria.entrySet());
        ListaOrdenadaPorPreco.sort(new CompararPorPreco());
        Map<String, Livro> mapOrdenadoPorPreco = new LinkedHashMap<>();

        if (!livraria.isEmpty()) {
            for (Map.Entry<String, Livro> entry : ListaOrdenadaPorPreco) {
                mapOrdenadoPorPreco.put(entry.getKey(), entry.getValue());
            }
        }

        return mapOrdenadoPorPreco;
    }

    public List<Livro> pesquisarLivrosPorAutor(String autor) {
        List<Livro> livrosDoAutor = new ArrayList<>();

        if (!livraria.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                   livrosDoAutor.add(entry.getValue());
                }
            }
        }

        return livrosDoAutor;
    }

    public Livro obterLivroMaisCaro() {
        Livro livroMaisCaro = null;
        double preco = Double.MIN_VALUE;

        if (!livraria.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if (entry.getValue().getPreco() > preco) {
                    preco = entry.getValue().getPreco();
                    livroMaisCaro = entry.getValue();
                }
            }
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato() {
        Livro livroMaisBarato = null;
        double preco = Double.MAX_VALUE;

        if (!livraria.isEmpty()) {
            for (Map.Entry<String, Livro> entry : livraria.entrySet()) {
                if (entry.getValue().getPreco() < preco) {
                    preco = entry.getValue().getPreco();
                    livroMaisBarato = entry.getValue();
                }
            }
        }

        return livroMaisBarato;
    }

    public static void main(String[] args) {

        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z","1984", "George Orwell", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun","A Revolução dos Bichos", "George Orwell", 7.05d);
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6","Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d);
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk","Malorie", "Josh Malerman", 5d);
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L","E Não Sobrou Nenhum", "Agatha Christie", 50d);
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4","Assassinato no Expresso do Oriente", "Agatha Christie", 5d);

        System.out.println("Livros ordenados por preço: " + livrariaOnline.obterLivrosOrdenadosPorPreco());
        livrariaOnline.removerLivro("Caixa de Pássaros");
        System.out.println("\nLivro mais barato: " + livrariaOnline.obterLivroMaisBarato());
        System.out.println("\nLivro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        System.out.println("\nLivros do autor George Orwell" + livrariaOnline.pesquisarLivrosPorAutor("George Orwell"));
    }
}
