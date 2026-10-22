package br.com.devops.tarefas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GerenciadorTarefasTest {
    @Test
    void deveAdicionarTarefa() {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Tarefa tarefa = gerenciador.adicionar("Estudar DevOps");
        assertEquals(1, tarefa.getId());
        assertEquals("Estudar DevOps", tarefa.getDescricao());
        assertEquals(1, gerenciador.listar().size());
    }

    @Test
    void naoDeveAceitarDescricaoVazia() {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        assertThrows(IllegalArgumentException.class, () -> gerenciador.adicionar("  "));
    }

    @Test
    void deveConcluirTarefa() {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Tarefa tarefa = gerenciador.adicionar("Criar workflow");
        assertTrue(gerenciador.concluir(tarefa.getId()));
        assertTrue(tarefa.isConcluida());
    }

    @Test
    void deveExcluirTarefa() {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Tarefa tarefa = gerenciador.adicionar("Tarefa temporaria");
        assertTrue(gerenciador.excluir(tarefa.getId()));
        assertTrue(gerenciador.listar().isEmpty());
    }

    @Test
    void naoDeveConcluirTarefaInexistente() {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        assertFalse(gerenciador.concluir(999));
    }
}
