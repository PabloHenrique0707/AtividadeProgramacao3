public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario) {
        if (!livro.isDisponivel()) {
            throw new IllegalArgumentException("O livro '" + livro.getTitulo() + "' já está indisponível.");
        }
        if (!usuario.podeEmprestar()) {
            throw new IllegalArgumentException("O usuário '" + usuario.getNome() + "' já possui 3 empréstimos ativos.");
        }

        this.livro = livro;
        this.usuario = usuario;
        this.ativo = true;

        this.livro.setDisponivel(false);
        this.usuario.adicionarEmprestimo(this);
    }

    public void devolver() {
        if (this.ativo) {
            this.ativo = false;
            this.livro.setDisponivel(true);
            this.usuario.removerEmprestimo(this);
        }
    }
}