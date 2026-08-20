package Exercicio09;

import java.util.ArrayList;
import java.util.List;

public class Validador<T> {
    private List<Regra<T>> regras = new ArrayList<>();

    public void adicionarRegra(Regra<T> regra) {
        regras.add(regra);
    }

    public List<String> validar(T objeto) {
        List<String> erros = new ArrayList<>();
        for (Regra<T> regra : regras) {
            String erro = regra.validar(objeto);
            if (erro != null) {
                erros.add(erro);
            }
        }
        return erros;
    }
}