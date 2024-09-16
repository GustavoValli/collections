package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numeros;

    public SomaNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public Integer calcularSoma() {
        Integer soma = 0;
        if (!numeros.isEmpty()) {
            for (Integer i : numeros) {
                soma += i;
            }
        }
        return soma;
    }

    public Integer encontrarMaiorNumero() {
        Integer maiorNumero = Integer.MIN_VALUE;
        if (!numeros.isEmpty()) {
            for (Integer i : numeros) {
                if (i > maiorNumero) {
                    maiorNumero = i;
                }
            }
        }
        return maiorNumero;
    }

    public Integer encontrarMenorNumero() {
        Integer menorNumero = Integer.MAX_VALUE;
        if (!numeros.isEmpty()) {
            for (Integer i : numeros) {
                if (i < menorNumero) {
                    menorNumero = i;
                }
            }
        }
        return menorNumero;
    }

    public void exibirNumeros() {
        System.out.println(numeros);
    }

    @Override
    public String toString() {
        return "SomaNumeros{" +
                "numeros=" + numeros +
                '}';
    }

    public static void main(String[] args) {

        SomaNumeros somaNumeros = new SomaNumeros();

        somaNumeros.adicionarNumero(16);
        somaNumeros.adicionarNumero(22);
        somaNumeros.adicionarNumero(43);
        somaNumeros.adicionarNumero(52);
        somaNumeros.adicionarNumero(29);

        somaNumeros.exibirNumeros();

        System.out.println("Soma total: " + somaNumeros.calcularSoma());
        System.out.println("Maior número: " + somaNumeros.encontrarMaiorNumero());
        System.out.println("Menor número: " + somaNumeros.encontrarMenorNumero());
    }
}
