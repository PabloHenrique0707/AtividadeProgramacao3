import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Pagamento> pagamentos = new ArrayList<>();

        pagamentos.add(new CartaoCredito(100.0, "1234567812345678"));
        pagamentos.add(new Pix(50.0, "pablo@email.com"));
        pagamentos.add(new Boleto(200.0, "12345678901234567890123456789012345678901234567"));

        System.out.println("--- PROCESSANDO PAGAMENTOS ---");
        for (Pagamento p : pagamentos) {
            p.processar();
        }
    }
}
