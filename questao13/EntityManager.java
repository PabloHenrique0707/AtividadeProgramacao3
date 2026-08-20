import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;
import java.util.StringJoiner;

public class EntityManager<T> {

    private final Class<T> entityClass;
    private final Connection connection;

    public EntityManager(Class<T> entityClass, Connection connection) {
        this.entityClass = entityClass;
        this.connection = connection;
    }

    public void save(T entity) throws Exception {
        String tableName = EntityMetadata.getTableName(entityClass);
        List<Field> fields = EntityMetadata.getColumnFields(entityClass);

        StringJoiner columns = new StringJoiner(", ");
        StringJoiner placeholders = new StringJoiner(", ");

        for (Field f : fields) {
            columns.add(EntityMetadata.getColumnName(f));
            placeholders.add("?");
        }

        String sql = "INSERT INTO " + tableName + " (" + columns + ") VALUES (" + placeholders + ")";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            int i = 1;
            for (Field f : fields) {
                stmt.setObject(i++, f.get(entity));
            }
            stmt.executeUpdate();
        }
    }

    public T findById(Object id) throws Exception {
        String tableName = EntityMetadata.getTableName(entityClass);
        Field idField = EntityMetadata.getIdField(entityClass);
        String idColumnName = EntityMetadata.getColumnName(idField);

        String sql = "SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                T obj = entityClass.getDeclaredConstructor().newInstance();
                for (Field f : EntityMetadata.getColumnFields(entityClass)) {
                    String colName = EntityMetadata.getColumnName(f);
                    Object val = rs.getObject(colName);
                    f.set(obj, val);
                }
                return obj;
            }
        }
        return null;
    }

    public void delete(Object id) throws Exception {
        String tableName = EntityMetadata.getTableName(entityClass);
        Field idField = EntityMetadata.getIdField(entityClass);
        String idColumnName = EntityMetadata.getColumnName(idField);

        String sql = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }
    }
}