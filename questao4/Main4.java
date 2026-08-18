package questao4;

public class Main4 {

    public static void main(String[] args) {

        double valor = 1000;

        Desconto comum = new DescontoClienteComum();
        System.out.println("Cliente comum: R$ " + comum.calcular(valor));

        Desconto premium = new DescontoClientePremium();
        System.out.println("Cliente premium: R$ " + premium.calcular(valor));

        Desconto corporativo = new DescontoCorporativo();
        System.out.println("Cliente corporativo: R$ " + corporativo.calcular(valor));

        DescontoComposto composto = new DescontoComposto();

        composto.adicionarDesconto(new DescontoClientePremium());
        composto.adicionarDesconto(new DescontoCampanha());

        System.out.println("Premium + campanha: R$ "
                + composto.calcular(valor));
    }
}