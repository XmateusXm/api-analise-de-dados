package service;

import java.util.List;
import java.util.Scanner;
import model.Municipio;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu(List<Municipio> municipios) {
        int opcao;

        do {
            System.out.println("\n===== MENU MUNICÍPIOS IBGE =====");
            System.out.println("1 - Listar todos os municípios");
            System.out.println("2 - Buscar município por nome");
            System.out.println("3 - Filtrar municípios por UF");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> listarTodos(municipios);
                case 2 -> buscarPorNome(municipios);
                case 3 -> filtrarPorUF(municipios);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    private void listarTodos(List<Municipio> municipios) {
        System.out.println("\n--- Lista de Municípios ---");
        municipios.forEach(m ->
                System.out.println(m.getNome() + " - " + m.getUf())
        );
    }

    private void buscarPorNome(List<Municipio> municipios) {
        System.out.print("Digite o nome do município: ");
        String nome = scanner.nextLine().toLowerCase();

        municipios.stream()
                .filter(m -> m.getNome().toLowerCase().contains(nome))
                .forEach(m -> System.out.println(m.getNome() + " - " + m.getUf()));
    }

    private void filtrarPorUF(List<Municipio> municipios) {
        System.out.print("Digite a UF (ex: SP, RJ, MG): ");
        String uf = scanner.nextLine().toUpperCase();

        municipios.stream()
                .filter(m -> m.getUf().equalsIgnoreCase(uf))
                .forEach(m -> System.out.println(m.getNome() + " - " + m.getUf()));
    }
}
