package questao14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Container {

    public <T> T criar(Class<T> classe) {

        try {

            // Cria o objeto
            Constructor<T> construtor = classe.getDeclaredConstructor();
            T objeto = construtor.newInstance();

            // Procura os atributos da classe
            Field[] campos = classe.getDeclaredFields();

            for (Field campo : campos) {

                // Verifica se o atributo possui @Inject
                if (campo.isAnnotationPresent(Inject.class)) {

                    // Cria a dependência
                    Object dependencia = criar(campo.getType());

                    // Permite acessar atributo privado
                    campo.setAccessible(true);

                    // Coloca a dependência dentro do objeto
                    campo.set(objeto, dependencia);
                }
            }

            return objeto;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Não foi possível criar a dependência: "
                            + classe.getSimpleName()
            );
        }
    }
}