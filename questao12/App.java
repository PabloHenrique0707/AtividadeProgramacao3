package Exercicio12;

public class App {
    public static void main(String[] args) {
        try {
            Produto produto = new Produto(101L, "Teclado Mecânico", 250.00);

            String sql = GeradorSqlInsert.gerarInsert(produto);

            System.out.println("SQL Gerado com sucesso:");
            System.out.println(sql);

        } catch (Exception e) {
            System.out.println("Erro ao gerar o SQL: " + e.getMessage());
        }
    }
}
