package org.adafilmes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public Catalogo() {
        this.filmes = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void cadastrarAtor(Ator ator) {
        atores.add(ator);
    }

    public void cadastrarDiretor(Diretor diretor) {
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
        return filmes.stream()
                .filter(f -> f.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
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
