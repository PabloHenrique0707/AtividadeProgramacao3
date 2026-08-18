package questao4;

public class DescontoClienteComum implements Desconto {

    @Override
    public double calcular(double valor) {
        return valor;
    }
}