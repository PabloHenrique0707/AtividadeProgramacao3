package Exercicio07;

import java.util.List;

public class Numeros {

    public static double soma(List<? extends Number> numeros) {
        double total = 0;
        for (Number n : numeros) {
            total += n.doubleValue();
        }
        return total;
    }


    public static double media(List<? extends Number> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            return 0;
        }
        return soma(numeros) / numeros.size();
    }


    public static void adicionarNumeros(List<? super Integer> numeros) {
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
    }

    public static <T extends Comparable<T>> T maior(List<T> valores) {
        if (valores == null || valores.isEmpty()) {
            return null;
        }
        T maior = valores.get(0);
        for (T valor : valores) {
            if (valor.compareTo(maior) > 0) {
                maior = valor;
            }
        }
        return maior;
    }
}

