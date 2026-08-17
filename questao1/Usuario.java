import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Emprestimo> emprestimosAtivos;

    public Usuario(String nome) {
        this.nome = nome;
        this.emprestimosAtivos = new ArrayList<>();
    }

    public boolean podeEmprestar() {
        return emprestimosAtivos.size() < 3;
    }

    public void adicionarEmprestimo(Emprestimo e) {
        emprestimosAtivos.add(e);
    }

    public void removerEmprestimo(Emprestimo e) {
        emprestimosAtivos.remove(e);
    }

    public String getNome() {
        return nome;
    }
}
