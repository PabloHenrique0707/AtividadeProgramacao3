package Exercicio07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Teste de Soma e Média (Upper Bounded Wildcard)
        List<Double> numeros = Arrays.asList(10.5, 20.0, 30.5);
        System.out.println("Soma: " + Numeros.soma(numeros));
        System.out.println("Média: " + Numeros.media(numeros));

        // Teste do adicionarNumeros (Lower Bounded Wildcard)
        List<Number> listaNumeros = new ArrayList<>();
        Numeros.adicionarNumeros(listaNumeros);
        System.out.println("Lista após adicionar: " + listaNumeros);

        // Teste do maior valor (Bounded Type e Comparable)
        List<String> nomes = Arrays.asList("Ana", "Carlos", "Zebra", "Bruno");
        System.out.println("Maior nome: " + Numeros.maior(nomes));
    }
}
