package tarefas.model;
import java.time.LocalDate;

public class Tarefa {

    private static int contadorId = 0;
    private final int id;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private final LocalDate dataCriacao;
    private LocalDate dataConclusao;

    public Tarefa(String titulo, String descricao){
        if(titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo não pode inicializar vazio ou nulo.");
        }else{
            this.titulo = titulo;
        }
        this.descricao = descricao;
        this.status = StatusTarefa.PENDENTE;
        this.id = ++contadorId;
        this.dataCriacao = LocalDate.now();
        this.dataConclusao = null;
        System.out.println("Sua tarefa: " + this.titulo + " foi criada e está PENDENTE.\nData de criação da tarefa - " + dataCriacao);
    }

    public void iniciar() {
        if (this.status == StatusTarefa.CANCELADA || this.status == StatusTarefa.CONCLUIDA) {
            throw new IllegalStateException("Não é possível iniciar essa tarefa pois ela já foi cancelada ou concluída.");
        } else {
            this.status = StatusTarefa.EM_ANDAMENTO;
            System.out.println("Tarefa: " + this.titulo + " em andamento.");
        }
    }

    public void concluir() {
        if (this.status == StatusTarefa.CANCELADA) {
            throw new IllegalArgumentException("Tarefa não pode ser concluída pois ela já foi cancelada.");
        } else {
            this.status = StatusTarefa.CONCLUIDA;
            this.dataConclusao = LocalDate.now();
            System.out.println("Sua tarefa: " + this.titulo + " foi concluída.");
            System.out.println("Data de conclusão: " + this.dataConclusao);
        }
    }

    public void cancelar() {
        if (this.status == StatusTarefa.CONCLUIDA) {
            throw new IllegalArgumentException("Tarefa não pode ser cancelada pois ela já foi concluída.");
        } else {
            this.status = StatusTarefa.CANCELADA;
            System.out.println("Tarefa: " + this.titulo + " cancelada.");
        }
    }

    public void editarTitulo(String titulo){
            if (titulo == null || titulo.isBlank()) {
                throw new IllegalArgumentException(
                        "Título não pode ser nulo, vazio ou conter apenas espaços."
                );
            }
            this.titulo = titulo;
    }

    public void editarDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void exibirDetalhes(){
        System.out.println("→ Titulo da tarefa: " + this.titulo);
        System.out.println("→ ID da tarefa: " + this.id);
        System.out.println("→ Descrição da tarefa: " + this.descricao);
        System.out.println("→ Status da tarefa: " + this.status);
        System.out.println("→ Data de criação da tarefa: " + this.dataCriacao);
        if(dataConclusao == null){
            System.out.println("→ Data de conclusão: tarefa não foi concluída.");
        }else{
            System.out.println("→ Data de conclusão da tarefa: " + this.dataConclusao);
        }
    }
}
