package org.adafilmes;

import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema ADA Filmes.
 * Gerencia a interface de linha de comando para o cadastro e associação de filmes, atores e diretores.
 * 
 * @author Afranio C
 */
public class Main {
    private static Catalogo catalogo = new Catalogo();
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Calcula o próximo ID disponível para um filme percorrendo a lista atual.
     * Substitui o uso de Streams e Lambdas.
     * 
     * @return O próximo ID sequencial.
     * @author Afranio C
     */
    private static int calcularProximoId() {
        int maxId = 0;
        List<Filme> filmes = catalogo.getFilmes();
        for (Filme filme : filmes) {
            if (filme.getId() > maxId) {
                maxId = filme.getId();
            }
        }
        return maxId + 1;
    }

    private static int proximoFilmeId = calcularProximoId();

    /**
     * Ponto de entrada da aplicação. Inicia o loop principal do menu.
     * 
     * @param args Argumentos da linha de comando (não utilizados).
     * @author Afranio C
     */
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

    /**
     * Exibe o menu principal de opções no console.
     * 
     * @author Afranio C
     */
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

    /**
     * Encaminha a execução para a funcionalidade correspondente à opção escolhida.
     * 
     * @param opcao A opção selecionada pelo usuário.
     * @author Afranio C
     */
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

    /**
     * Realiza o cadastro de um novo filme solicitando os dados via console.
     * 
     * @author Afranio C
     */
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

    /**
     * Realiza o cadastro de um novo ator.
     * 
     * @author Afranio C
     */
    private static void cadastrarAtor() {
        System.out.print("Nome do Ator: ");
        String nome = scanner.nextLine();
        Ator ator = new Ator(nome);
        catalogo.adicionarAtorAoCatalogo(ator);
        System.out.println("Ator cadastrado com sucesso!");
    }

    /**
     * Realiza o cadastro de um novo diretor.
     * 
     * @author Afranio C
     */
    private static void cadastrarDiretor() {
        System.out.print("Nome do Diretor: ");
        String nome = scanner.nextLine();
        Diretor diretor = new Diretor(nome);
        catalogo.adicionarDiretorAoCatalogo(diretor);
        System.out.println("Diretor cadastrado com sucesso!");
    }

    /**
     * Permite associar um diretor cadastrado a um filme através do ID do filme.
     * 
     * @author Afranio C
     */
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

        if (index < 0 || index >= diretores.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        catalogo.associarDiretorFilme(id, diretores.get(index));
        System.out.println("Diretor associado!");
    }

    /**
     * Permite associar um ator cadastrado a um filme através do ID do filme.
     * 
     * @author Afranio C
     */
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

        if (index < 0 || index >= atores.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        catalogo.associarAtorFilme(id, atores.get(index));
        System.out.println("Ator associado!");
    }

    /**
     * Pesquisa filmes por nome e exibe os resultados encontrados.
     * 
     * @author Afranio C
     */
    private static void pesquisarFilme() {
        System.out.print("Digite o nome do filme: ");
        String nome = scanner.nextLine();
        List<Filme> resultados = catalogo.buscarFilmePorNome(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            return;
        }
        for (Filme filme : resultados) {
            System.out.println(filme);
        }
    }

    /**
     * Lista todos os filmes cadastrados e permite visualizar os detalhes de um filme específico.
     * 
     * @author Afranio C
     */
    private static void listarFilmes() {
        List<Filme> filmes = catalogo.getFilmes();
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        
        for (Filme f : filmes) {
            System.out.println("-------------------------");
            System.out.println(f.getId() + " - " + f.getNome());
        }
        
        System.out.print("Escolha um filme para ver os detalhes: ");
        int escolhaFilme = Integer.parseInt(scanner.nextLine());
        
        if (escolhaFilme < 1 || escolhaFilme > filmes.size()) {
            System.out.println("ID de filme inválido.");
            return;
        }
        
        System.out.println(filmes.get(escolhaFilme - 1));
    }
}