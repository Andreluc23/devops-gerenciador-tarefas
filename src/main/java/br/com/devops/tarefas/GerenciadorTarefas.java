package br.com.devops.tarefas;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public Tarefa adicionar(String descricao) {
        if (descricao == null) {
            throw new IllegalArgumentException("A descricao nao pode estar vazia.");
        }
        Tarefa tarefa = new Tarefa(proximoId++, descricao.trim());
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listar() {
        return List.copyOf(tarefas);
    }

    public boolean concluir(int id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId() == id) {
                tarefa.concluir();
                return true;
            }
        }
        return false;
    }

    public boolean excluir(int id) {
        return tarefas.removeIf(tarefa -> tarefa.getId() == id);
    }
}
