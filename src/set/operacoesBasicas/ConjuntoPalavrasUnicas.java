package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {

    private Set<String> palavras;

    public ConjuntoPalavrasUnicas() {
        this.palavras = new HashSet<>();
    }

    public void adicionarPalavra(String palavra) {
        palavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!palavras.isEmpty()) {
            if (palavras.contains(palavra)) {
                palavras.remove(palavra);
            }
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavras.isEmpty()) {
            System.out.println(palavras);
        }
    }

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas{" +
                "palavras=" + palavras +
                '}';
    }

    public static void main(String[] args) {

        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarPalavra("Cama");
        conjuntoPalavrasUnicas.adicionarPalavra("Cobertor");
        conjuntoPalavrasUnicas.adicionarPalavra("Coberta");
        conjuntoPalavrasUnicas.adicionarPalavra("Cama");
        conjuntoPalavrasUnicas.adicionarPalavra("Travesseiro");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Cama");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        System.out.println(conjuntoPalavrasUnicas.verificarPalavra("Dormir"));
    }
}
