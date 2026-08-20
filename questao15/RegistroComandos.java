import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegistroComandos<T> {

    private Map<String, Method> comandos = new HashMap<>();

    public void registrar(T objeto) {

        Method[] metodos = objeto.getClass().getDeclaredMethods();

        for (Method metodo : metodos) {

            if (metodo.isAnnotationPresent(Command.class)) {

                Command anotacao = metodo.getAnnotation(Command.class);

                comandos.put(anotacao.value(), metodo);
            }
        }
    }

    public Method buscar(String nome) {

        return comandos.get(nome);
    }
}
