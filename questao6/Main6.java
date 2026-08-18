package questao6;

public class Main6 {

    public static void main(String[] args) {

        // Repositório de clientes
        Repositorio<Cliente> clientes = new Repositorio<>();

        clientes.adicionar(new Cliente("João"));
        clientes.adicionar(new Cliente("Maria"));

        System.out.println("Clientes:");
        System.out.println(clientes.listar());

        System.out.println("Primeiro cliente:");
        System.out.println(clientes.consultar(0));


        // Repositório de produtos
        Repositorio<Produto> produtos = new Repositorio<>();

        produtos.adicionar(new Produto("Arroz"));
        produtos.adicionar(new Produto("Feijão"));

        System.out.println("\nProdutos:");
        System.out.println(produtos.listar());


        // Repositório de pedidos
        Repositorio<Pedido> pedidos = new Repositorio<>();

        pedidos.adicionar(new Pedido(1));
        pedidos.adicionar(new Pedido(2));

        System.out.println("\nPedidos:");
        System.out.println(pedidos.listar());


        // Testando remoção
        clientes.remover(0);

        System.out.println("\nClientes depois da remoção:");
        System.out.println(clientes.listar());
    }
}