package questao14;

public class Pedido {

    @Inject
    private Notificacao notificacao;

    public void finalizar() {
        System.out.println("Pedido finalizado.");

        notificacao.enviarNotificacao();
    }
}