package tarefas;

import tarefas.model.Tarefa;

public class Main {
    public static void main(String[] args) {

        Tarefa estudar = new Tarefa("Estudar programação", "Estudar Java amanhã às 18h");
        System.out.println("--------------------------------");
        Tarefa academia = new Tarefa("Fazer academia", "Ir na academia amanhã ás 18h");
        System.out.println("--------------------------------");
        estudar.exibirDetalhes();
        System.out.println("--------------------------------");
        academia.exibirDetalhes();


    }
}