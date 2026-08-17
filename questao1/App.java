public class App {
    public static void main(String[] args) {
        Autor autor = new Autor("Machado de Assis");
        Livro livro1 = new Livro("Dom Casmurro", autor);
        Livro livro2 = new Livro("Memórias Póstumas", autor);
        Usuario usuario = new Usuario("Carlos");

        try {
            Emprestimo emp1 = new Emprestimo(livro1, usuario);
            System.out.println("Empréstimo 1 de '" + livro1.getTitulo() + "' realizado com sucesso!");

            Emprestimo emp2 = new Emprestimo(livro2, usuario);
            System.out.println("Empréstimo 2 de '" + livro2.getTitulo() + "' realizado com sucesso!");

            // Tentativa de emprestar o mesmo livro indisponível (vai cair no catch)
            new Emprestimo(livro1, usuario);

        } catch (IllegalArgumentException e) {
            System.out.println("Regra de negócio acionada: " + e.getMessage());
        }
    }
}