

import java.lang.reflect.Method;

public class ExecutorComandos {

    public static <T> Resultado<T> executar(
            RegistroComandos<?> registro,
            Object objeto,
            String nome,
            Object... parametros) {

        try {

            Method metodo = registro.buscar(nome);

            if (metodo == null) {
                throw new RuntimeException("Comando não encontrado: " + nome);
            }

            Class<?>[] tipos = metodo.getParameterTypes();

            if (tipos.length != parametros.length) {
                throw new RuntimeException(
                        "Quantidade de parâmetros inválida."
                );
            }

            for (int i = 0; i < tipos.length; i++) {

                if (!tipos[i].isInstance(parametros[i])
                        && !(tipos[i] == int.class && parametros[i] instanceof Integer)) {

                    throw new RuntimeException(
                            "Tipo de parâmetro inválido."
                    );
                }
            }

            Object resultado = metodo.invoke(objeto, parametros);

            return new Resultado<>((T) resultado);

        } catch (Exception e) {

            throw new RuntimeException(e.getMessage());
        }
    }
}
