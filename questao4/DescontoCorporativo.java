package questao4;

public class DescontoCorporativo implements Desconto {

    @Override
    public double calcular(double valor) {
        return valor * 0.80;
    }
}