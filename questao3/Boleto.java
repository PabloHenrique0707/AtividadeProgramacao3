public class Boleto extends Pagamento {
    private String codigoBarra;

    public Boleto(double valor, String codigoBarra) {
        super(valor);
        this.codigoBarra = codigoBarra;
    }

    @Override
    public boolean validar() {
        return codigoBarra != null && codigoBarra.length() == 47;
    }

    @Override
    public double calcularTaxa() {
        return 2.0; // Taxa fixa de R$ 2,00
    }

    @Override
    public void processar() {
        if (validar()) {
            System.out.println("Boleto gerado com sucesso! Total: R$ " + getValorTotal());
        } else {
            System.out.println("Código de barras do boleto inválido.");
        }
    }
}