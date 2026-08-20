public class ComandosExemplo {

    @Command("somar")
    public Integer somar(Integer a, Integer b) {
        return a + b;
    }

    @Command("multiplicar")
    public Integer multiplicar(Integer a, Integer b) {
        return a * b;
    }

    @Command("saudar")
    public String saudar(String nome) {
        return "Ola, " + nome + "!";
    }
}
