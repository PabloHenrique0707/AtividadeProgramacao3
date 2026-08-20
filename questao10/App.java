package Exercicio10;

public class App {
    public static void main(String[] args) {
        try {
            Inspecao.inspecionarClasse("Exercicio09.Produto");

        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro na inspeção: " + e.getMessage());
        }
    }
}
