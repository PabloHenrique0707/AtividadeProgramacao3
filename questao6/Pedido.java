package questao6;

public class Pedido {

    private int numero;

    public Pedido(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Pedido: " + numero;
    }
}