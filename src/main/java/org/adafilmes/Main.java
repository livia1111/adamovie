package org.adafilmes;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Catalogo catalogo = new Catalogo();
    private static Scanner scanner = new Scanner(System.in);
    private static int proximoFilmeId =
            catalogo.getFilmes().stream().mapToInt(Filme::getId).max().orElse(0) + 1;

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n--- ADA FILMES ---");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Cadastrar Ator");
        System.out.println("3. Cadastrar Diretor");
        System.out.println("4. Associar Diretor a um Filme");
        System.out.println("5. Associar Ator a um Filme");
        System.out.println("6. Pesquisar Filme por Nome");
        System.out.println("7. Listar Todos os Filmes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarFilme();
                break;
            case 2:
                cadastrarAtor();
                break;
            case 3:
                cadastrarDiretor();
                break;
            case 4:
                associarDiretor();
                break;
            case 5:
                associarAtor();
                break;
            case 6:
                pesquisarFilme();
                break;
            case 7:
                listarFilmes();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void cadastrarFilme() {
        System.out.print("Nome do Filme: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String data = scanner.nextLine();
        System.out.print("Orçamento: ");
        float orcamento = Float.parseFloat(scanner.nextLine());
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Filme filme = new Filme(proximoFilmeId++, nome, data, orcamento, descricao);
        catalogo.adicionarFilmeAoCatalogo(filme);
        System.out.println("Filme cadastrado com sucesso! ID: " + (proximoFilmeId - 1));
    }

    private static void cadastrarAtor() {
        System.out.print("Nome do Ator: ");
        String nome = scanner.nextLine();
        Ator ator = new Ator(nome);
        catalogo.adicionarAtorAoCatalogo(ator);
        System.out.println("Ator cadastrado com sucesso!");
    }

    private static void cadastrarDiretor() {
        System.out.print("Nome do Diretor: ");
        String nome = scanner.nextLine();
        Diretor diretor = new Diretor(nome);
        catalogo.adicionarDiretorAoCatalogo(diretor);
        System.out.println("Diretor cadastrado com sucesso!");
    }

    private static void associarDiretor() {
        System.out.print("ID do Filme: ");
        int id = Integer.parseInt(scanner.nextLine());

        List<Diretor> diretores = catalogo.getDiretores();
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }

        System.out.println("Escolha o Diretor:");
        for (int i = 0; i < diretores.size(); i++) {
            System.out.println(i + ". " + diretores.get(i).getNome());
        }
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < diretores.size()) {
            catalogo.associarDiretorFilme(id, diretores.get(index));
            System.out.println("Diretor associado!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void associarAtor() {
        System.out.print("ID do Filme: ");
        int id = Integer.parseInt(scanner.nextLine());

        List<Ator> atores = catalogo.getAtores();
        if (atores.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }

        System.out.println("Escolha o Ator:");
        for (int i = 0; i < atores.size(); i++) {
            System.out.println(i + ". " + atores.get(i).getNome());
        }
        int index = Integer.parseInt(scanner.nextLine());

        if (index >= 0 && index < atores.size()) {
            catalogo.associarAtorFilme(id, atores.get(index));
            System.out.println("Ator associado!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void pesquisarFilme() {
        System.out.print("Digite o nome do filme: ");
        String nome = scanner.nextLine();
        List<Filme> resultados = catalogo.buscarFilmePorNome(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
        } else {
            resultados.forEach(System.out::println);
        }
    }

    private static void listarFilmes() {
        List<Filme> filmes = catalogo.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
        } else {
            filmes.forEach(f -> {
                System.out.println("-------------------------");
                System.out.println(f.getId()+" - "+f.getNome());
            });
        }
        System.out.print("Escolha um filme para ver os detalhes: ");
        int escolhaFilme = scanner.nextInt();
        System.out.println(filmes.get(escolhaFilme - 1));

    }
}
