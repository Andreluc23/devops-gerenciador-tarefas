package br.com.devops.tarefas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== GERENCIADOR DE TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            String opcao = scanner.nextLine();
            switch (opcao) {
                case "1" -> {
                    System.out.print("Descricao: ");
                    try {
                        Tarefa tarefa = gerenciador.adicionar(scanner.nextLine());
                        System.out.println("Tarefa cadastrada com ID " + tarefa.getId());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "2" -> {
                    if (gerenciador.listar().isEmpty()) System.out.println("Nenhuma tarefa cadastrada.");
                    for (Tarefa tarefa : gerenciador.listar()) {
                        System.out.printf("%d - [%s] %s%n", tarefa.getId(), tarefa.isConcluida() ? "X" : " ", tarefa.getDescricao());
                    }
                }
                case "3", "4" -> {
                    System.out.print("ID da tarefa: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine());
                        boolean sucesso = opcao.equals("3") ? gerenciador.concluir(id) : gerenciador.excluir(id);
                        System.out.println(sucesso ? "Operacao realizada." : "Tarefa nao encontrada.");
                    } catch (NumberFormatException e) {
                        System.out.println("Digite um ID numerico.");
                    }
                }
                case "0" -> { System.out.println("Ate logo!"); return; }
                default -> System.out.println("Opcao invalida.");
            }
        }
    }
}
