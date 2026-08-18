package questao4;

import java.util.ArrayList;
import java.util.List;

public class DescontoComposto implements Desconto {

    private List<Desconto> descontos = new ArrayList<>();

    public void adicionarDesconto(Desconto desconto) {
        descontos.add(desconto);
    }

    @Override
    public double calcular(double valor) {

        double resultado = valor;

        for (Desconto desconto : descontos) {
            resultado = desconto.calcular(resultado);
        }

        return resultado;
    }
}