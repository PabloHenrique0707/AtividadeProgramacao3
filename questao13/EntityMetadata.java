import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EntityMetadata {

    public static String getTableName(Class<?> clazz) {
        if (clazz.isAnnotationPresent(Tabela.class)) {
            Tabela t = clazz.getAnnotation(Tabela.class);
            if (!t.nome().isEmpty()) return t.nome();
        }
        return clazz.getSimpleName().toLowerCase();
    }

    public static Field getIdField(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                return field;
            }
        }
        throw new RuntimeException("Campo @Id não encontrado na classe " + clazz.getName());
    }

    public static List<Field> getColumnFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Coluna.class) || field.isAnnotationPresent(Id.class)) {
                field.setAccessible(true);
                fields.add(field);
            }
        }
        return fields;
    }

    public static String getColumnName(Field field) {
        if (field.isAnnotationPresent(Coluna.class)) {
            Coluna c = field.getAnnotation(Coluna.class);
            if (!c.nome().isEmpty()) return c.nome();
        }
        return field.getName();
    }
}