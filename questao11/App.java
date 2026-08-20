package Exercicio11;

public class App {
    public static void main(String[] args) {
        try {
            Object texto = Criador.criarInstanciaComArgumento("java.lang.String", "Reflection Java", String.class);

            Object resultado = Criador.executarMetodo(texto, "toUpperCase");

            System.out.println("Texto original: " + texto);
            System.out.println("Resultado via Reflection (toUpperCase): " + resultado);

        } catch (Exception e) {
            System.out.println("Erro na execução dinâmica: " + e.getMessage());
        }
    }
}
