package questao5;

public class Main5 {

    public static void main(String[] args) {

        Produto arroz = new Produto("Arroz", 10);
        Produto feijao = new Produto("Feijão", 8);
        Produto carne = new Produto("Carne", 30);

        ItemCarrinho item1 = new ItemCarrinho(arroz, 2);
        ItemCarrinho item2 = new ItemCarrinho(feijao, 3);
        ItemCarrinho item3 = new ItemCarrinho(carne, 1);

        Carrinho carrinho = new Carrinho();

        carrinho.adicionarItem(item1);
        carrinho.adicionarItem(item2);
        carrinho.adicionarItem(item3);

        System.out.println("Subtotal: R$ " + carrinho.calcularSubtotal());
        System.out.println("Desconto: R$ " + carrinho.calcularDesconto());
        System.out.println("Frete: R$ " + carrinho.calcularFrete());
        System.out.println("Total: R$ " + carrinho.calcularTotal());
    }
}