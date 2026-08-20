package Exercicio09;

import java.util.List;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class TesteValidador {
    public static void main(String[] args) {
        Produto produto = new Produto(null, -10.0);

        Validador<Produto> validador = new Validador<>();

        validador.adicionarRegra(p -> p.getNome() == null ? "Nome é obrigatório" : null);
        validador.adicionarRegra(p -> p.getPreco() <= 0 ? "Preço deve ser maior que zero" : null);

        List<String> erros = validador.validar(produto);

        for (String erro : erros) {
            System.out.println("Erro: " + erro);
        }
    }
}
