package questao4;

public class DescontoClientePremium implements Desconto {

    @Override
    public double calcular(double valor) {
        return valor * 0.90;
    }
}