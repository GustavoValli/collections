package set.ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunos;

    public GerenciadorAlunos() {
        this.alunos = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        alunos.add(new Aluno(nome, matricula, media));
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        if (!alunos.isEmpty()) {
            for (Aluno a : alunos) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunos.remove(alunoParaRemover);
        }
    }

    public void exibirAlunosPorNome() {
        Set<Aluno> alunosPorNome = new TreeSet<>(alunos);
        if (!alunos.isEmpty()) {
            System.out.println(alunosPorNome);
        }
    }

    public void exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new CompararNota());
        if (!alunos.isEmpty()) {
            alunosPorNota.addAll(alunos);
            System.out.println(alunosPorNota);
        }
    }

    public void exibirAlunos() {
        System.out.println(alunos);
    }

    @Override
    public String toString() {
        return "GerenciadorAlunos{" +
                "alunos=" + alunos +
                '}';
    }

    public static void main(String[] args) {

        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("José", 12345L, 8.3);
        gerenciadorAlunos.adicionarAluno("Maria", 12345L, 9.0);
        gerenciadorAlunos.adicionarAluno("Mariana", 678910L, 7.2);
        gerenciadorAlunos.adicionarAluno("Claudio", 478911L, 7.5);

        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.removerAluno(12345L);
        gerenciadorAlunos.exibirAlunos();

        gerenciadorAlunos.exibirAlunosPorNome();
        gerenciadorAlunos.exibirAlunosPorNota();
    }
}
