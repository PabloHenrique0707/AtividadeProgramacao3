package Exercicio10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Inspecao {

    public static void inspecionarClasse(String nomeClasse) throws ClassNotFoundException {
        Class<?> clazz = Class.forName(nomeClasse);

        System.out.println("==================================================");
        System.out.println("INSPEÇÃO DA CLASSE: " + clazz.getName());
        System.out.println("==================================================");

        System.out.println("\n--- CONSTRUTORES ---");
        Constructor<?>[] construtores = clazz.getDeclaredConstructors();
        for (Constructor<?> c : construtores) {
            System.out.println("  " + c);
        }

        System.out.println("\n--- ATRIBUTOS ---");
        Field[] campos = clazz.getDeclaredFields();
        for (Field f : campos) {
            String visibilidade = Modifier.isPublic(f.getModifiers()) ? "[PÚBLICO]" : "[PRIVADO/PROTEGIDO]";
            System.out.println("  " + visibilidade + " " + f.getType().getSimpleName() + " " + f.getName());
        }

        System.out.println("\n--- MÉTODOS ---");
        Method[] metodos = clazz.getDeclaredMethods();
        for (Method m : metodos) {
            if (!m.isSynthetic()) {
                String visibilidade = Modifier.isPublic(m.getModifiers()) ? "[PÚBLICO]" : "[PRIVADO/PROTEGIDO]";
                System.out.println("  " + visibilidade + " " + m.getReturnType().getSimpleName() + " " + m.getName() + "()");
            }
        }
    }
}
