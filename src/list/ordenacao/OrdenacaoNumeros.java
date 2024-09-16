package list.ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> numeros;

    public OrdenacaoNumeros() {
        this.numeros = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeros.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        ArrayList<Integer> ordemAscendente = new ArrayList<>(numeros);
        if (!numeros.isEmpty()) {
            Collections.sort(ordemAscendente);
        }
        return ordemAscendente;
    }

    public List<Integer> ordenarDescendente() {
        ArrayList<Integer> ordemDescendente = new ArrayList<>(numeros);
        if (!numeros.isEmpty()) {
            ordemDescendente.sort(Collections.reverseOrder());
        }
        return ordemDescendente;
    }

    @Override
    public String toString() {
        return "OrdenacaoNumeros{" +
                "numeros=" + numeros +
                '}';
    }

    public static void main(String[] args) {

        OrdenacaoNumeros ordenacaoNumeros = new OrdenacaoNumeros();

        ordenacaoNumeros.adicionarNumero(23);
        ordenacaoNumeros.adicionarNumero(36);
        ordenacaoNumeros.adicionarNumero(12);
        ordenacaoNumeros.adicionarNumero(2);
        ordenacaoNumeros.adicionarNumero(67);

        System.out.println(ordenacaoNumeros);
        System.out.println(ordenacaoNumeros.ordenarAscendente());
        System.out.println(ordenacaoNumeros.ordenarDescendente());
    }

}
