import java.lang.reflect.Field;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("=== TESTANDO MINI ORM (GENERICS + REFLECTION) ===\n");

        try {
            // 1. Instanciando uma entidade anotada
            Produto produto = new Produto(101, "Teclado Mecanico", 250.00);

            // 2. Testando extração de metadados por Reflection
            System.out.println("--- 1. METADADOS DA ENTIDADE ---");
            String nomeTabela = EntityMetadata.getTableName(Produto.class);
            Field campoId = EntityMetadata.getIdField(Produto.class);
            List<Field> colunas = EntityMetadata.getColumnFields(Produto.class);

            System.out.println("Tabela Mapeada: " + nomeTabela);
            System.out.println("Campo ID: " + campoId.getName() + " (Coluna DB: " + EntityMetadata.getColumnName(campoId) + ")");
            System.out.println("Colunas Mapeadas:");
            for (Field f : colunas) {
                System.out.println("  - " + f.getName() + " -> " + EntityMetadata.getColumnName(f));
            }

            // 3. Simulação da geração de SQLs dinâmicos via Reflection
            System.out.println("\n--- 2. COMANDOS SQL GERADOS DINAMICAMENTE ---");
            
            // Simulação INSERT
            StringBuilder sqlInsert = new StringBuilder("INSERT INTO ").append(nomeTabela).append(" (");
            StringBuilder valores = new StringBuilder("VALUES (");
            for (int i = 0; i < colunas.size(); i++) {
                Field f = colunas.get(i);
                sqlInsert.append(EntityMetadata.getColumnName(f));
                valores.append("'").append(f.get(produto)).append("'");
                if (i < colunas.size() - 1) {
                    sqlInsert.append(", ");
                    valores.append(", ");
                }
            }
            sqlInsert.append(") ").append(valores).append(");");
            System.out.println("SQL INSERT: " + sqlInsert);

            // Simulação SELECT (findById)
            String sqlSelect = "SELECT * FROM " + nomeTabela + " WHERE " + EntityMetadata.getColumnName(campoId) + " = " + produto.getId() + ";";
            System.out.println("SQL SELECT: " + sqlSelect);

            // Simulação DELETE
            String sqlDelete = "DELETE FROM " + nomeTabela + " WHERE " + EntityMetadata.getColumnName(campoId) + " = " + produto.getId() + ";";
            System.out.println("SQL DELETE: " + sqlDelete);

            System.out.println("\n--- 3. TESTE CONCLUÍDO COM SUCESSO! ---");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}