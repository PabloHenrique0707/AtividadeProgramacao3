package questao14;

public class Main {

    public static void main(String[] args) {

        Container container = new Container();

        Pedido pedido = container.criar(Pedido.class);

        pedido.finalizar();
    }
}