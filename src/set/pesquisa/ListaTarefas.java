package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefas;

    public ListaTarefas() {
        this.tarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefas.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaRemovida = new Tarefa(descricao);
        if (!tarefas.isEmpty()) {
            if (tarefas.contains(tarefaRemovida)) {
                tarefas.remove(tarefaRemovida);
            }
        }
    }

    public void exibirTarefas() {
        if (!tarefas.isEmpty()) {
            System.out.println(tarefas);
        }
    }

    public int contarTarefas() {
        int contador = 0;
        if (!tarefas.isEmpty()) {
            contador = tarefas.size();
        }
        return contador;
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefas.isEmpty()) {
            for (Tarefa t : tarefas) {
                if (t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefas.isEmpty()) {
            for (Tarefa t : tarefas) {
                if (!t.isConcluida()) {
                    tarefasConcluidas.add(t);
                }
            }
        }
        return tarefasConcluidas;
    }

    public void marcarTarefaConcluida(String descricao) {
        if (!tarefas.isEmpty()) {
            for (Tarefa t : tarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(true);
                }
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        if (!tarefas.isEmpty()) {
            for (Tarefa t : tarefas) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluida(false);
                }
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefas.clear();
    }

    public static void main(String[] args) {

        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.adicionarTarefa("Lavar a louça");
        listaTarefas.adicionarTarefa("Lavar a roupa");
        listaTarefas.adicionarTarefa("Lavar a roupa");
        listaTarefas.adicionarTarefa("Estender a roupa");

        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();

        listaTarefas.removerTarefa("Lavar a roupa");

        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();

        listaTarefas.marcarTarefaConcluida("Lavar a louça");

        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();

        listaTarefas.limparListaTarefas();

        System.out.println(listaTarefas.contarTarefas());
        listaTarefas.exibirTarefas();
    }
}
