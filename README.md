# Gerenciador de Tarefas

Aplicação de terminal desenvolvida em Java puro para praticar programação orientada a objetos.

## Funcionalidades

- Cadastrar e listar tarefas.
- Buscar tarefas por ID.
- Concluir e excluir tarefas.
- Tratar entradas inválidas.

Os dados ficam em memória e são perdidos ao encerrar o programa.

## Tecnologias

Java 21, Collections, LocalDate e Scanner. Sem frameworks ou dependências externas.

## Estrutura

```text
src/tarefas/
├── Main.java
├── model/
│   ├── Tarefa.java
│   └── StatusTarefa.java
├── service/
│   └── GerenciadorDeTarefas.java
└── ui/
    └── Menu.java
```

## Como executar

Com o JDK 21 instalado, abra o projeto no IntelliJ IDEA, configure o SDK e execute o método `main` da classe `Main`.

## Conceitos praticados

Encapsulamento, construtores, enums, coleções, separação de responsabilidades e tratamento de exceções.

## Licença

Consulte o arquivo [LICENSE](LICENSE).