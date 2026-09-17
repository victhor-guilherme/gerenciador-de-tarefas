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
}