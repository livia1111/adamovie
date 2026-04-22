package org.adafilmes;

import org.adafilmes.utils.EfeitoTexto;

import static org.adafilmes.utils.FonteCores.*;
import static org.adafilmes.utils.LimparConsole.limparConsole;

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
                limparConsole(500);
                System.out.println(VERMELHO + "Opção inválida!!\nDigite um número." + RESET);
                System.out.println("\nPress Enter para voltar ao menu inicial...");
                scanner.nextLine();
                limparConsole(1000);
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
                limparConsole(1000);
                pesquisarFilme();
                break;
            case 7:
                limparConsole(1000);
                listarFilmes();
                break;
            case 0:
                EfeitoTexto.escrever("\nEncerrando a aplicação...", 70);
                limparConsole();
                break;
            default:
                limparConsole(500);
                System.out.println(VERMELHO+"Opção inválida!!"+RESET);
                System.out.println("\nPress Enter para voltar ao menu inicial...");
                scanner.nextLine();
                limparConsole(1000);
        }
    }

    /**
     * Realiza o cadastro de um novo filme solicitando os dados via console.
     * 
     * @author Afranio C
     */
    private static void cadastrarFilme() {
        limparConsole(500);
        System.out.println("------------------------");
        System.out.println("    CADASTRO DE FILME   ");
        System.out.println("------------------------\n");
        System.out.print("Nome do Filme: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String data = scanner.nextLine();
        System.out.print("Orçamento: ");
        String orcamento = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        Filme filme = new Filme(proximoFilmeId++, nome, data, orcamento, descricao);
        catalogo.adicionarFilmeAoCatalogo(filme);

        limparConsole(500);
        System.out.println(VERDE+"Filme cadastrado com sucesso! ID: " + (proximoFilmeId - 1)+RESET);
        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
    }

    /**
     * Realiza o cadastro de um novo ator.
     * 
     * @author Afranio C
     */
    private static void cadastrarAtor() {
        limparConsole(500);
        System.out.println("------------------------");
        System.out.println("    CADASTRO DE ATOR    ");
        System.out.println("------------------------\n");
        System.out.print("Nome do Ator: ");
        String nome = scanner.nextLine();

        Ator ator = new Ator(nome);
        catalogo.adicionarAtorAoCatalogo(ator);

        limparConsole(500);
        System.out.println(VERDE+"Ator cadastrado com sucesso!"+RESET);
        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
    }

    /**
     * Realiza o cadastro de um novo diretor.
     * 
     * @author Afranio C
     */
    private static void cadastrarDiretor() {
        limparConsole(500);
        System.out.println("------------------------");
        System.out.println("   CADASTRO DE DIRETOR  ");
        System.out.println("------------------------\n");
        System.out.print("Nome do Diretor: ");
        String nome = scanner.nextLine();
        Diretor diretor = new Diretor(nome);
        catalogo.adicionarDiretorAoCatalogo(diretor);

        limparConsole(500);
        System.out.println(VERDE+"Diretor cadastrado com sucesso!"+RESET);
        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
    }

    /**
     * Permite associar um diretor cadastrado a um filme através do ID do filme.
     * 
     * @author Afranio C
     */
    private static void associarDiretor() {
        limparConsole(500);
        System.out.println("-------------------------");
        System.out.println("  ASSOCIAR DIRETOR/FILME  ");
        System.out.println("-------------------------\n");

        List<Filme> filmes = catalogo.getFilmes();
        System.out.println("FILMES CADASTRADOS");
        for (Filme f : filmes) {
            System.out.println(f.getId() + " - " + f.getNome());
        }
        System.out.println("-------------------------");
        System.out.print("\nID do Filme: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id < 0 || id >= filmes.size()) {
            limparConsole(500);
            System.out.println(VERMELHO+"ID inválido."+RESET);
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        List<Diretor> diretores = catalogo.getDiretores();
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }

        for (int i = 0; i < diretores.size(); i++) {
            System.out.println(i + ". " + diretores.get(i).getNome());
        }
        System.out.print("\nEscolha o Diretor:");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= diretores.size()) {
            limparConsole(1000);
            System.out.println(VERMELHO+"Índice inválido."+RESET);
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        catalogo.associarDiretorFilme(id, diretores.get(index));
        limparConsole(500);
        System.out.println(VERDE+"Diretor associado!"+RESET);
        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
    }

    /**
     * Permite associar um ator cadastrado a um filme através do ID do filme.
     *
     * @author Afranio C
     */
    private static void associarAtor() {
        limparConsole(500);
        System.out.println("-------------------------");
        System.out.println("   ASSOCIAR ATOR/FILME   ");
        System.out.println("-------------------------\n");

        List<Filme> filmes = catalogo.getFilmes();
        System.out.println("FILMES CADASTRADOS");
        for (Filme f : filmes) {
            System.out.println(f.getId() + " - " + f.getNome());
        }
        System.out.println("-------------------------");

        System.out.print("\nID do Filme: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (id < 0 || id >= filmes.size()) {
            limparConsole(500);
            System.out.println(VERMELHO+"ID inválido."+RESET);
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        List<Ator> atores = catalogo.getAtores();
        if (atores.isEmpty()) {
            limparConsole(1000);
            System.out.println("Nenhum ator cadastrado.");
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        for (int i = 0; i < atores.size(); i++) {
            System.out.println(i + ". " + atores.get(i).getNome());
        }
        System.out.print("\nEscolha o Ator: ");
        int index = Integer.parseInt(scanner.nextLine());

        if (index < 0 || index >= atores.size()) {
            limparConsole(1000);
            System.out.println(VERMELHO+"Índice inválido."+RESET);
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        catalogo.associarAtorFilme(id, atores.get(index));
        limparConsole(500);
        System.out.println(VERDE+"Ator associado!"+RESET);
        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);

    }

    /**
     * Pesquisa filmes por nome e exibe os resultados encontrados.
     * 
     * @author Afranio C
     */
    private static void pesquisarFilme() {
        System.out.println("------------------------");
        System.out.println("   PESQUISA DE FILMES   ");
        System.out.println("------------------------\n");

        System.out.print("Digite o nome do filme: ");
        String nome = scanner.nextLine();

        limparConsole(500);
        System.out.println("-------------------------");
        System.out.println("  RESULTADO DA PESQUISA  ");
        System.out.println("-------------------------\n");
        List<Filme> resultados = catalogo.buscarFilmePorNome(nome);
        if (resultados.isEmpty()) {
            System.out.println("Nenhum filme encontrado.");
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }
        for (Filme filme : resultados) {
            System.out.println(filme);
        }

        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
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
        System.out.println("------------------------");
        System.out.println("   CATÁLOGO DE FILMES   ");
        System.out.println("------------------------\n");
        for (Filme f : filmes) {
            System.out.println(f.getId() + " - " + f.getNome());
            System.out.println("------------------------");
        }

        System.out.print("\nEscolha um filme para ver os detalhes: ");
        int escolhaFilme = Integer.parseInt(scanner.nextLine());

        if (escolhaFilme < 0 || escolhaFilme >= filmes.size()) {
            System.out.println(VERMELHO+"\nID de filme inválido."+RESET);
            System.out.println("\nPress Enter para voltar ao menu inicial...");
            scanner.nextLine();
            limparConsole(1000);
            return;
        }

        limparConsole(1000);
        System.out.println(filmes.get(escolhaFilme));

        System.out.println("\nPress Enter para voltar ao menu inicial...");
        scanner.nextLine();
        limparConsole(1000);
    }
}
