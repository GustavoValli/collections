package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> palavras;

    public ContagemPalavras() {
        this.palavras = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        palavras.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!palavras.isEmpty()) {
            palavras.remove(palavra);
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(palavras);
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        Integer contador = 0;
        if (!palavras.isEmpty()) {
            for (Map.Entry<String, Integer> entry : palavras.entrySet()) {
                if (entry.getValue() > contador) {
                    contador = entry.getValue();
                    palavraMaisFrequente = entry.getKey();
                }
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {

        ContagemPalavras contagemPalavras = new ContagemPalavras();

        contagemPalavras.adicionarPalavra("Cachorro", 3);
        contagemPalavras.adicionarPalavra("Gato", 2);
        contagemPalavras.adicionarPalavra("Papagaio", 5);
        contagemPalavras.adicionarPalavra("Baleia", 3);
        contagemPalavras.adicionarPalavra("Águia", 1);

        contagemPalavras.exibirContagemPalavras();

        contagemPalavras.removerPalavra("Papagaio");
        contagemPalavras.exibirContagemPalavras();

        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());
    }
}
