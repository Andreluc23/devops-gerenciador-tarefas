package br.com.devops.tarefas;

public class Tarefa {
    private final int id;
    private final String descricao;
    private boolean concluida;

    public Tarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public boolean isConcluida() { return concluida; }
    public void concluir() { concluida = true; }
}
