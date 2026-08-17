import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Carlos", 5000.0, 1500.0));
        funcionarios.add(new Desenvolvedor("Ana", 4000.0, 800.0));
        funcionarios.add(new Estagiario("Lucas", 1200.0));

        double totalFolha = 0.0;

        System.out.println("--- FOLHA DE PAGAMENTO ---");
        for (Funcionario f : funcionarios) {
            double remuneracao = f.calcularRemuneracao();
            totalFolha += remuneracao;
            System.out.println(f.getNome() + " - Remuneração: R$ " + remuneracao);
        }

        System.out.println("--------------------------");
        System.out.println("Total da Folha: R$ " + totalFolha);
    }
}
