package Exercicio09;

@FunctionalInterface
public interface Regra<T> {
    String validar(T objeto);
}
