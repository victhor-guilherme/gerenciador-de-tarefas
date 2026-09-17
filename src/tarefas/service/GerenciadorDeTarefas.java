package tarefas.service;

import tarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeTarefas {

    private final List<Tarefa> tarefas = new ArrayList<>();

    public Tarefa cadastrarTarefa(String titulo, String descricao) {
        Tarefa tarefa = new Tarefa(titulo, descricao);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    public Tarefa buscarTarefaPorId(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }

        throw new IllegalArgumentException(
                "Nenhuma tarefa encontrada com o ID: " + id
        );
    }

    public void concluirTarefa(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        tarefa.concluir();
    }

    public void excluirTarefa(int id) {
        Tarefa tarefa = buscarTarefaPorId(id);
        tarefas.remove(tarefa);
    }
}