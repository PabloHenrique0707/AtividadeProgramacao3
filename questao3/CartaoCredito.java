public class CartaoCredito extends Pagamento {
    private String numeroCartao;

    public CartaoCredito(double valor, String numeroCartao) {
        super(valor);
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean validar() {
        return numeroCartao != null && numeroCartao.length() == 16;
    }

    @Override
    public double calcularTaxa() {
        return getValor() * 0.05; // 5% de taxa
    }

    @Override
    public void processar() {
        if (validar()) {
            System.out.println("Pagamento no cartão aprovado! Total: R$ " + getValorTotal());
        } else {
            System.out.println("Cartão inválido.");
        }
    }
}