package Exercicio08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Funcionario implements Comparable<Funcionario> {
    private String nome;
    private double salario;
    private String setor;

    public Funcionario(String nome, double salario, String setor) {
        this.nome = nome;
        this.salario = salario;
        this.setor = setor;
    }

    @Override
    public int compareTo(Funcionario outro) {
        return this.nome.compareTo(outro.nome);
    }

    public double getSalario() {
        return salario;
    }

    public String getSetor() {
        return setor;
    }


    public void executarOrdenacao() {
        Comparator<Funcionario> salarioCrescente = Comparator.comparingDouble(Funcionario::getSalario);
        Comparator<Funcionario> salarioDecrescente = salarioCrescente.reversed();
        Comparator<Funcionario> porSetor = Comparator.comparing(Funcionario::getSetor);

        List<Funcionario> funcionarios = new ArrayList<>();
        Collections.sort(funcionarios);
        funcionarios.sort(salarioCrescente);
        funcionarios.sort(salarioDecrescente);
        funcionarios.sort(porSetor);
    }
}
