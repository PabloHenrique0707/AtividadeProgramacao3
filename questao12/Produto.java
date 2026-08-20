package Exercicio12;

@Tabela(nome = "produtos")
public class Produto {

    @Coluna(nome = "id_produto")
    private Long id;

    @Coluna(nome = "nome_produto")
    private String nome;

    @Coluna(nome = "preco_unitario")
    private double preco;

    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}