package Exercicio12;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GeradorSqlInsert {

    public static String gerarInsert(Object objeto) throws Exception {
        Class<?> classe = objeto.getClass();

        if (!classe.isAnnotationPresent(Tabela.class)) {
            throw new IllegalArgumentException("A classe " + classe.getSimpleName() + " não possui a anotação @Tabela");
        }

        Tabela tabela = classe.getAnnotation(Tabela.class);
        String nomeTabela = tabela.nome();

        List<String> colunas = new ArrayList<>();
        List<String> valores = new ArrayList<>();

        for (Field campo : classe.getDeclaredFields()) {
            if (campo.isAnnotationPresent(Coluna.class)) {
                campo.setAccessible(true);

                Coluna coluna = campo.getAnnotation(Coluna.class);
                Object valor = campo.get(objeto);

                colunas.add(coluna.nome());

                if (valor instanceof String) {
                    valores.add("'" + valor + "'");
                } else if (valor == null) {
                    valores.add("NULL");
                } else {
                    valores.add(valor.toString());
                }
            }
        }

        return String.format(
                "INSERT INTO %s (%s) VALUES (%s);",
                nomeTabela,
                String.join(", ", colunas),
                String.join(", ", valores)
        );
    }
}
