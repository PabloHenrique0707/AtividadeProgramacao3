public abstract class Pagamento implements Validavel {
    private double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract double calcularTaxa();
    public abstract void processar();

    public double getValorTotal() {
        return valor + calcularTaxa();
    }
}
