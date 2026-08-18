package questao6;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {

    private List<T> objetos = new ArrayList<>();

    // Criar / adicionar
    public void adicionar(T objeto) {
        objetos.add(objeto);
    }

    // Consultar
    public T consultar(int posicao) {
        return objetos.get(posicao);
    }

    // Remover
    public void remover(int posicao) {
        objetos.remove(posicao);
    }

    // Listar
    public List<T> listar() {
        return new ArrayList<>(objetos);
    }
}