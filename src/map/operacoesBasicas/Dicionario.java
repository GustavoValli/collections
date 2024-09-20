package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {

    private Map<String, String> dicionario;

    public Dicionario() {
        this.dicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionario.isEmpty()) {
            dicionario.remove(palavra);
        }
    }

    public void exibirPalavras() {
        System.out.println(dicionario);
    }

    public String pesquisarPorPalavra(String palavra) {
        String palavraPesquisada = null;
        if (!dicionario.isEmpty()) {
            palavraPesquisada = dicionario.get(palavra);
        }
        return palavraPesquisada;
    }

    public static void main(String[] args) {

        Dicionario dic = new Dicionario();

        dic.adicionarPalavra("Abacaxi", "É uma fruta");
        dic.adicionarPalavra("Abacaxi", "Não é uma fruta");
        dic.adicionarPalavra("Melancia", "É uma fruta");
        dic.adicionarPalavra("Arroz", "É um grão");
        dic.adicionarPalavra("Carro", "É um automóvel");

        dic.exibirPalavras();

        dic.removerPalavra("Abacaxi");
        dic.exibirPalavras();

        System.out.println("Pesquisa da palavra Melancia: " + dic.pesquisarPorPalavra("Melancia"));
    }
}
