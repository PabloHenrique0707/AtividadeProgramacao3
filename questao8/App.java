package Exercicio08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Carlos", 5000.0, "TI"));
        funcionarios.add(new Funcionario("Ana", 3500.0, "RH"));
        funcionarios.add(new Funcionario("Bruno", 7000.0, "TI"));

        Collections.sort(funcionarios);
        System.out.println("--- Ordenado por Nome (Natural) ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getSalario() + " - " + f.getSetor());
        }

        Comparator<Funcionario> porSalarioDecrescente = Comparator.comparingDouble(Funcionario::getSalario).reversed();
        funcionarios.sort(porSalarioDecrescente);
        System.out.println("\n--- Ordenado por Salário Decrescente ---");
        for (Funcionario f : funcionarios) {
            System.out.println(f.getNome() + " - " + f.getSalario() + " - " + f.getSetor());
        }
    }
}