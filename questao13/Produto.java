@Tabela(nome = "produtos")
public class Produto {

    @Id
    @Coluna(nome = "id_produto")
    private Integer id;

    @Coluna
    private String nome;

    @Coluna
    private Double preco;

    public Produto() {}

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() { return id; }
    public String getNome() { return nome; }
    public Double getPreco() { return preco; }
}