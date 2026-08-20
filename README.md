# Alunos: Pablo Henrique Braz, Jefferson Vitor e Caique Lucas
# Programação III 

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
 ---

## Questão 4 — Sistema de Descontos

* **Análise em Relação ao Princípio Open/Closed (SOLID):**
  * O princípio prevê que classes devem estar **abertas para extensão, mas fechadas para modificação**.
  * Utilizando o padrão *Strategy* com interfaces/composição, novas regras de desconto podem ser adicionadas criando novas classes que implementam a interface de desconto.
  * O código central do carrinho ou da venda não precisa sofrer edições nem ganhar novos `if/else` a cada nova campanha promocional criada.

---

## Questão 5 — Carrinho de Compras

* **Diferença entre Associação, Agregação e Composição no Modelo:**
  * **Associação:** É um relacionamento genérico em que objetos navegam entre si (ex: `Cliente` associado a `Carrinho`).
  * **Agregação:** Relacionamento "todo-parte" fraco, onde a parte existe independentemente do todo (ex: `Produto` existe mesmo fora de um `Carrinho`).
  * **Composição:** Relacionamento "todo-parte" forte, onde a parte depende da existência do todo (ex: `ItemCarrinho` só existe enquanto associado àquele `Carrinho` específico).

---

## Questão 6 — Cadastro Genérico

* **Problemas de uma Versão Baseada em `Object`:**
  * **Falta de Segurança de Tipos (*Type Safety*):** Permite inserir qualquer tipo de objeto por engano na mesma coleção sem erro em tempo de compilação.
  * **Necessidade de *Casts* Explícitos:** Exige converter o tipo ao recuperar elementos (`(Produto) repo.buscar(1)`), gerando código verboso.
  * **Risco de Exceções:** Aumenta a chance de erros em tempo de execução como `ClassCastException`.

---

## Questão 7 — Generics Avançados

* **A Regra PECS (*Producer Extends, Consumer Super*):**
  * **Producer Extends (`? extends T`):** Usado quando a coleção apenas **fornece/produz** dados do tipo `T` para leitura. Permite ler com segurança, mas bloqueia adição de elementos.
  * **Consumer Super (`? super T`):** Usado quando a coleção apenas **consome/recebe** dados do tipo `T` para escrita. Permite adicionar elementos do tipo `T` com segurança.

---

## Questão 8 — Sistema de Comparação

* **Ordenação Natural vs. Estratégias Externas:**
  * **Ordenação Natural (`Comparable`):** Utilizada quando a entidade possui um critério único, padrão e intrínseco de comparação (ex: `Funcionario` ordenado naturalmente por seu `nome`).
  * **Estratégias Externas (`Comparator`):** Utilizadas quando precisamos de múltiplos critérios alternativos, dinâmicos ou sob demanda (ex: ordenar por `salario` crescente, decrescente ou por `setor`) sem alterar a classe do objeto.

---

## Questão 9 — Framework Genérico de Validação

* **Como a Solução Favorece Reutilização:**
  * Separar as regras de validação em interfaces funcionais (`Regra<T>`) permite isolar verificações pontuais (ex: validar e-mail, checar limite de crédito, verificar campo nulo).
  * O `Validador<T>` desacopla a regra da entidade, permitindo reusar as mesmas lógicas para qualquer classe e encadear múltiplas regras dinamicamente.

---

## Questão 10 — Reflection — Inspeção de Classes

* **Inspeção sem Conhecimento em Tempo de Compilação:**
  * Por meio da API de Reflection (`Class<?>`), o Java consegue carregar os metadados do bytecode `.class` dinamicamente.
  * Permite que a aplicação descubra campos privados, métodos declarados, modificadores e anotações de uma classe que nem existia quando o framework foi compilado.

---

## Questão 11 — Reflection — Instanciação Dinâmica

* **Problemas de Segurança, Acoplamento e Manutenção:**
  * **Segurança:** Pode burlar o encapsulamento acessando construtores privados via `setAccessible(true)`.
  * **Manutenção e Desempenho:** Instanciação refletiva é consideravelmente mais lenta que o uso de `new` e esconde erros de compilação, lançando exceções checadas em tempo de execução (`NoSuchMethodException`, `InstantiationException`).
  * **Acoplamento Frágil:** Alterar a assinatura de um construtor quebra a invocação refletiva sem aviso prévio do compilador.

---

## Questão 12 — Reflection — Anotações Personalizadas

* **Riscos de Gerar SQL e Prevenção de SQL Injection:**
  * **Risco:** Concatenar valores diretamente na `String` do comando SQL abre brechas sérias para ataques de *SQL Injection*.
  * **Prevenção:** Em vez de concatenar valores brutos, o mecanismo deve gerar a instrução utilizando *placeholders* (`?`) e executar os comandos por meio de `PreparedStatement` passando os valores capturados via Reflection.

---

## Questão 13 — Mini ORM

* **Limitações Comparadas a um ORM Real (ex: Hibernate / JPA):**
  * **Ausência de Mapeamento de Relacionamentos:** Não possui suporte a mapeamentos complexos como `@OneToMany`, `@ManyToOne` ou estratégias de carregamento *Lazy/Eager*.
  * **Falta de Cache de Primeiro Nível:** Não rastreia o estado das entidades carregadas em memória (*dirty checking*) para sincronizar modificações automaticamente.
  * **Sem Geração de Schema (DDL) e Sem HQL/JPQL:** Não cria/altera tabelas automaticamente no banco nem possui uma linguagem de consulta abstrata para buscas com filtros avançados ou junções (`JOIN`).
