package tarefas.ui;
import tarefas.model.Tarefa;
import tarefas.service.GerenciadorDeTarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;
    private final GerenciadorDeTarefas gerenciador;


    public Menu(GerenciadorDeTarefas gerenciador){
        this.scanner = new Scanner(System.in);
        this.gerenciador = gerenciador;
    }


    public void exibirOpcoes(){
        System.out.println(
                """
                        1 - Cadastrar tarefa
                        2 - Listar tarefas
                        3 - Buscar tarefa por ID
                        4- Concluir tarefa
                        5- Excluir tarefa
                        0 - Sair"""
        );
    }

    public void executar() {
        int opcao;
        do {
            exibirOpcoes();
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarTarefa();
                case 2 -> listarTarefas();
                case 3 -> buscarTarefa();
                case 4 -> concluirTarefa();
                case 5 -> excluirTarefa();
                case 0 -> System.out.println("Programa encerrado.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);}


    private void cadastrarTarefa(){

            System.out.println("Digite o título da sua tarefa: ");
            String titulo = scanner.nextLine();

            System.out.println("Digite a descrição da sua tarefa: ");
            String descricao = scanner.nextLine();

            gerenciador.cadastrarTarefa(titulo, descricao);


    }


    private void listarTarefas() {
        List<Tarefa> tarefas = gerenciador.listarTarefas();

        if (tarefas.isEmpty()) {
            System.out.println("Aviso: Nenhuma tarefa foi encontrada!");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            exibirTarefa(tarefa);
            System.out.println("--------------------");
        }
    }

    private void buscarTarefa() {
        System.out.print("Digite o ID da tarefa: ");
            int id = Integer.parseInt(scanner.nextLine());

            Tarefa tarefa = gerenciador.buscarTarefaPorId(id);
            exibirTarefa(tarefa);
        }

    private void concluirTarefa() {
        System.out.println("Digite o ID da tarefa: ");
        gerenciador.concluirTarefa(Integer.parseInt(scanner.nextLine()));
    }

    private void excluirTarefa() {
        System.out.println("Digite o ID da tarefa: ");
        gerenciador.excluirTarefa(Integer.parseInt(scanner.nextLine()));
    }

    private void exibirTarefa(Tarefa tarefa) {
        tarefa.exibirDetalhes();
    }
}
