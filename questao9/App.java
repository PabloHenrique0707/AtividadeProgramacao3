package Exercicio09;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Corrigido para Produto (com 'o' no final)
        Produto produto = new Produto(null, -10.0);

        Validador<Produto> validador = new Validador<>();

        // A lambda retorna a mensagem de erro (ou null se estiver correto)
        validador.adicionarRegra(p -> (p.getNome() == null || p.getNome().trim().isEmpty())
                ? "O nome do produto não pode ser vazio."
                : null);

        validador.adicionarRegra(p -> p.getPreco() <= 0
                ? "O preço do produto deve ser maior que zero."
                : null);

        // Executa a validação
        List<String> erros = validador.validar(produto);

        if (erros.isEmpty()) {
            System.out.println("Produto válido!");
        } else {
            System.out.println("Erros de validação encontrados:");
            for (String erro : erros) {
                System.out.println("- " + erro);
            }
        }
    }
}
