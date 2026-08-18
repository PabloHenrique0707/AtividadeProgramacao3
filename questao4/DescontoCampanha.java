package questao4;

public class DescontoCampanha implements Desconto {

    @Override
    public double calcular(double valor) {
        return valor * 0.95;
    }
}