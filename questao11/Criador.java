package Exercicio11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Criador {

    public static Object criarInstancia(String nomeClasse) throws Exception {
        Class<?> classe = Class.forName(nomeClasse);
        Constructor<?> construtor = classe.getDeclaredConstructor();
        construtor.setAccessible(true); // Permite acesso mesmo se o construtor for privado/protegido
        return construtor.newInstance();
    }

    public static Object criarInstanciaComArgumento(String nomeClasse, Object argumento, Class<?> tipoParametro) throws Exception {
        Class<?> classe = Class.forName(nomeClasse);
        Constructor<?> construtor = classe.getDeclaredConstructor(tipoParametro);
        construtor.setAccessible(true);
        return construtor.newInstance(argumento);
    }

    public static Object executarMetodo(Object objeto, String nomeMetodo) throws Exception {
        Class<?> classe = objeto.getClass();
        Method metodo = classe.getDeclaredMethod(nomeMetodo);
        metodo.setAccessible(true);
        return metodo.invoke(objeto);
    }

    public static Object executarMetodoComParametros(Object objeto, String nomeMetodo, Object[] parametros, Class<?>[] tiposParametros) throws Exception {
        Class<?> classe = objeto.getClass();
        Method metodo = classe.getDeclaredMethod(nomeMetodo, tiposParametros);
        metodo.setAccessible(true);
        return metodo.invoke(objeto, parametros);
    }
}