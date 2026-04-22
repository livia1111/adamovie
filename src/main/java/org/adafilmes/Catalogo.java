package org.adafilmes;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe responsável por armazenar e gerenciar os filmes,
 * atores e diretores do catálogo.
 * Também permite realizar buscas e associações entre as entidades.
 *
 * @author Thiago de Almeida Pereira
 * @version 1.1
 */


public class Catalogo {
    private final List<Filme> filmes;
    private final List<Ator> atores;
    private final List<Diretor> diretores;

    public Catalogo() {
        this.filmes = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
        carregarDadosIniciais();
    }
    //Metodo pra carregar massa de teste
    @SuppressWarnings("InsertLiteralUnderscores")
    private void carregarDadosIniciais() {
        if (!filmes.isEmpty() || !atores.isEmpty() || !diretores.isEmpty()) {
            return;
        }

        // =========================
        // DIRETORES
        // =========================
        Diretor christopherNolan = cadastrarDiretor("Christopher Nolan");
        Diretor wachowskis = cadastrarDiretor("Lilly e Lana Wachowski");
        Diretor jamesCameron = cadastrarDiretor("James Cameron");
        Diretor ridleyScott = cadastrarDiretor("Ridley Scott");

        // =========================
        // ATORES
        // =========================

        // A Origem
        Ator leonardoDiCaprio = cadastrarAtor("Leonardo DiCaprio");
        Ator kenWatanabe = cadastrarAtor("Ken Watanabe");
        Ator josephGordonLevitt = cadastrarAtor("Joseph Gordon-Levitt");
        Ator marionCotillard = cadastrarAtor("Marion Cotillard");
        Ator elliotPage = cadastrarAtor("Elliot Page");
        Ator tomHardy = cadastrarAtor("Tom Hardy");
        Ator cillianMurphy = cadastrarAtor("Cillian Murphy");
        Ator dileepRao = cadastrarAtor("Dileep Rao");
        Ator tomBerenger = cadastrarAtor("Tom Berenger");
        Ator michaelCaine = cadastrarAtor("Michael Caine");

        // Interestelar
        Ator matthewMcConaughey = cadastrarAtor("Matthew McConaughey");
        Ator anneHathaway = cadastrarAtor("Anne Hathaway");
        Ator jessicaChastain = cadastrarAtor("Jessica Chastain");
        Ator billIrwin = cadastrarAtor("Bill Irwin");
        Ator mackenzieFoy = cadastrarAtor("Mackenzie Foy");
        Ator mattDamon = cadastrarAtor("Matt Damon");
        Ator johnLithgow = cadastrarAtor("John Lithgow");
        Ator ellenBurstyn = cadastrarAtor("Ellen Burstyn");

        // Matrix
        Ator keanuReeves = cadastrarAtor("Keanu Reeves");
        Ator laurenceFishburne = cadastrarAtor("Laurence Fishburne");
        Ator carrieAnneMoss = cadastrarAtor("Carrie-Anne Moss");
        Ator hugoWeaving = cadastrarAtor("Hugo Weaving");
        Ator joePantoliano = cadastrarAtor("Joe Pantoliano");

        // Titanic
        Ator kateWinslet = cadastrarAtor("Kate Winslet");
        Ator billyZane = cadastrarAtor("Billy Zane");
        Ator kathyBates = cadastrarAtor("Kathy Bates");
        Ator francesFisher = cadastrarAtor("Frances Fisher");
        Ator gloriaStuart = cadastrarAtor("Gloria Stuart");
        Ator bernardHill = cadastrarAtor("Bernard Hill");
        Ator victorGarber = cadastrarAtor("Victor Garber");
        Ator jonathanHyde = cadastrarAtor("Jonathan Hyde");
        Ator dannyNucci = cadastrarAtor("Danny Nucci");
        Ator davidWarner = cadastrarAtor("David Warner");
        Ator billPaxton = cadastrarAtor("Bill Paxton");

        // Gladiador
        Ator russellCrowe = cadastrarAtor("Russell Crowe");
        Ator joaquinPhoenix = cadastrarAtor("Joaquin Phoenix");
        Ator connieNielsen = cadastrarAtor("Connie Nielsen");
        Ator oliverReed = cadastrarAtor("Oliver Reed");
        Ator derekJacobi = cadastrarAtor("Derek Jacobi");
        Ator djimonHounsou = cadastrarAtor("Djimon Hounsou");
        Ator richardHarris = cadastrarAtor("Richard Harris");
        Ator ralfMoller = cadastrarAtor("Ralf Möller");
        Ator johnShrapnel = cadastrarAtor("John Shrapnel");

        // =========================
        // FILMES
        // =========================

        // 1) A Origem
        Filme aOrigem = new Filme(
                0,
                "A Origem",
                "16072010",
                "160000000",
                "Um especialista em invadir sonhos recebe a missão de implantar uma ideia na mente de um herdeiro."
        );
        aOrigem.setDiretor(christopherNolan);
        adicionarElenco(
                aOrigem,
                leonardoDiCaprio,
                kenWatanabe,
                josephGordonLevitt,
                marionCotillard,
                elliotPage,
                tomHardy,
                cillianMurphy,
                dileepRao,
                tomBerenger,
                michaelCaine
        );
        adicionarFilmeAoCatalogo(aOrigem);

        // 2) Interestelar
        Filme interestelar = new Filme(
                1,
                "Interestelar",
                "07112014",
                "165000000",
                "Em um futuro de escassez na Terra, astronautas atravessam um buraco de minhoca em busca de um novo lar para a humanidade."
        );
        interestelar.setDiretor(christopherNolan);
        adicionarElenco(
                interestelar,
                matthewMcConaughey,
                anneHathaway,
                jessicaChastain,
                billIrwin,
                mackenzieFoy,
                mattDamon,
                johnLithgow,
                ellenBurstyn,
                michaelCaine
        );
        adicionarFilmeAoCatalogo(interestelar);

        // 3) Matrix
        Filme matrix = new Filme(
                2,
                "Matrix",
                "31031999",
                "63000000",
                "Um hacker descobre que a realidade é uma simulação criada por máquinas e passa a lutar contra esse sistema."
        );
        matrix.setDiretor(wachowskis);
        adicionarElenco(
                matrix,
                keanuReeves,
                laurenceFishburne,
                carrieAnneMoss,
                hugoWeaving,
                joePantoliano
        );
        adicionarFilmeAoCatalogo(matrix);

        // 4) Titanic
        Filme titanic = new Filme(
                3,
                "Titanic",
                "19121997",
                "200000000",
                "Um romance entre passageiros de classes sociais diferentes se desenvolve durante a viagem inaugural do RMS Titanic."
        );
        titanic.setDiretor(jamesCameron);
        adicionarElenco(
                titanic,
                leonardoDiCaprio,
                kateWinslet,
                billyZane,
                kathyBates,
                francesFisher,
                gloriaStuart,
                bernardHill,
                victorGarber,
                jonathanHyde,
                dannyNucci,
                davidWarner,
                billPaxton
        );
        adicionarFilmeAoCatalogo(titanic);

        // 5) Gladiador
        Filme gladiador = new Filme(
                4,
                "Gladiador",
                "05052000",
                "103000000",
                "Após ser traído pelo novo imperador, um general romano se torna gladiador em busca de vingança."
        );
        gladiador.setDiretor(ridleyScott);
        adicionarElenco(
                gladiador,
                russellCrowe,
                joaquinPhoenix,
                connieNielsen,
                oliverReed,
                derekJacobi,
                djimonHounsou,
                richardHarris,
                ralfMoller,
                johnShrapnel
        );
        adicionarFilmeAoCatalogo(gladiador);
    }

    private Ator cadastrarAtor(String nome) {
        Ator ator = new Ator(nome);
        adicionarAtorAoCatalogo(ator);
        return ator;
    }

    private Diretor cadastrarDiretor(String nome) {
        Diretor diretor = new Diretor(nome);
        adicionarDiretorAoCatalogo(diretor);
        return diretor;
    }

    private void adicionarElenco(Filme filme, Ator... atores) {
        for (Ator ator : atores) {
            filme.adicionarAtor(ator);
        }
    }

    public void adicionarFilmeAoCatalogo(Filme filme) {
        filmes.add(filme);
    }

    public void adicionarAtorAoCatalogo(Ator ator) {
        atores.add(ator);
    }

    public void adicionarDiretorAoCatalogo(Diretor diretor) {
        diretores.add(diretor);
    }

    public void associarDiretorFilme(int filmeId, Diretor diretor) {
        for (Filme filme : filmes) {
            if (filme.getId() == filmeId) {
                filme.setDiretor(diretor);
                break;
            }
        }
    }

    public void associarAtorFilme(int filmeId, Ator ator) {
        for (Filme filme : filmes) {
            if (filme.getId() == filmeId) {
                filme.adicionarAtor(ator);
                break;
            }
        }
    }

    public List<Filme> buscarFilmePorNome(String nome) {
        List<Filme> resultados = new ArrayList<>();

        if (nome == null || nome.trim().isEmpty()) {
            return resultados;
        }

        String termoBusca = nome.trim().toLowerCase();

        for (Filme filme : filmes) {
            if (filme.getNome() != null &&
                    filme.getNome().toLowerCase().contains(termoBusca)) {
                resultados.add(filme);
            }
        }

        return resultados;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

}
