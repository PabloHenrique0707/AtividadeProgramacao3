package Exercicio10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Inspecao {

    public static void inspecionarClasse(String nomeClasse) throws Exception {

        Class<?> classe = Class.forName(nomeClasse);

        System.out.println("==========================================");
        System.out.println("Nome da Classe: " + classe.getName());
        System.out.println("Modificadores: " + Modifier.toString(classe.getModifiers()));
        System.out.println("==========================================");


        System.out.println("\n--- Atributos Declarados ---");
        for (Field campo : classe.getDeclaredFields()) {
            boolean ehPrivado = Modifier.isPrivate(campo.getModifiers());
            System.out.println("- Atributo: " + campo.getName()
                    + " | Tipo: " + campo.getType().getSimpleName()
                    + (ehPrivado ? " [PRIVADO]" : ""));
        }


        System.out.println("\n--- Construtores ---");
        for (Constructor<?> construtor : classe.getDeclaredConstructors()) {
            System.out.println("- Construtor: " + construtor.getName()
                    + " | Qtd Parâmetros: " + construtor.getParameterCount());
        }


        System.out.println("\n--- Métodos Declarados ---");
        for (Method metodo : classe.getDeclaredMethods()) {
            boolean ehPublico = Modifier.isPublic(metodo.getModifiers());
            System.out.println("- Método: " + metodo.getName()
                    + " | Retorno: " + metodo.getReturnType().getSimpleName()
                    + " | " + (ehPublico ? "[PÚBLICO]" : "[DECLARADO/NÃO-PÚBLICO]"));
        }
    }
}
