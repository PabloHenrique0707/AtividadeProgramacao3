public class Pix extends Pagamento {
    private String chavePix;

    public Pix(double valor, String chavePix) {
        super(valor);
        this.chavePix = chavePix;
    }

    @Override
    public boolean validar() {
        return chavePix != null && !chavePix.isBlank();
    }

    @Override
    public double calcularTaxa() {
        return 0.0; // Sem taxa
    }

    @Override
    public void processar() {
        if (validar()) {
            System.out.println("PIX realizado com sucesso! Total: R$ " + getValorTotal());
        } else {
            System.out.println("Chave PIX inválida.");
        }
    }
}