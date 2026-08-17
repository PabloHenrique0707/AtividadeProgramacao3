# Atividades de Orientação a Objetos em Java

## Questão 1 — Sistema de Biblioteca
* **Justificativa das Regras de Negócio:**
  * A regra de limite de até 3 empréstimos ativos foi colocada na classe `Usuario`.
  * A verificação de disponibilidade do livro foi isolada na classe `Livro`.
  * O controle da operação fica na classe `Emprestimo`, sem deixar lógica solta no método `main`.

---

## Questão 2 — Hierarquia de Funcionários
* **Por que o polimorfismo reduz o acoplamento:**
  * O processamento da folha de pagamento depende apenas da classe abstrata `Funcionario`. 
  * Para adicionar novos cargos no futuro, basta criar novas subclasses que herdem de `Funcionario` sem precisar alterar o código principal com vários `if/else`.

---

## Questão 3 — Sistema de Pagamentos
* **Extensibilidade e Contratos:**
  * A interface `Validavel` garante o contrato de validação para qualquer forma de pagamento.
  * Como a classe `App` processa referências da classe abstrata `Pagamento`, é possível adicionar novas modalidades sem alterar o código de processamento principal.
