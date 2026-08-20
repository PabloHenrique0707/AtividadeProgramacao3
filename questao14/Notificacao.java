package questao14;

public class Notificacao {

    @Inject
    private ServicoEmail servicoEmail;

    public void enviarNotificacao() {
        servicoEmail.enviar("Pedido realizado com sucesso!");
    }
}