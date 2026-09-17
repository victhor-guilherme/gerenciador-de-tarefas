package tarefas;

import tarefas.service.GerenciadorDeTarefas;
import tarefas.ui.Menu;

public class Main{
    public static void main(String[] args) {

        GerenciadorDeTarefas gerenciador = new GerenciadorDeTarefas();
        Menu menu = new Menu(gerenciador);
        menu.executar();

    }
}