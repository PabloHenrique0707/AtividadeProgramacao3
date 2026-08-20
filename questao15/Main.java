public class Main {

    public static void main(String[] args) {

        ComandosExemplo comandos = new ComandosExemplo();

        RegistroComandos<ComandosExemplo> registro =
                new RegistroComandos<>();

        registro.registrar(comandos);

        Resultado<Integer> soma =
                ExecutorComandos.executar(
                        registro,
                        comandos,
                        "somar",
                        10,
                        5
                );

        System.out.println("Soma: " + soma);

        Resultado<Integer> multiplicacao =
                ExecutorComandos.executar(
                        registro,
                        comandos,
                        "multiplicar",
                        10,
                        5
                );

        System.out.println("Multiplicacao: " + multiplicacao);

        Resultado<String> saudacao =
                ExecutorComandos.executar(
                        registro,
                        comandos,
                        "saudar",
                        "Jubileu"
                );

        System.out.println("Saudacao: " + saudacao);
    }
}
