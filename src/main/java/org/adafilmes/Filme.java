package org.adafilmes;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private int id;
    private String nome;
    private String dataLancamento;
    private float orcamento;
    private String descricao;
    private Diretor diretor;
    private List<Ator> elenco;

    public Filme(int id, String nome, String dataLancamento, float orcamento, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        this.elenco = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    public List<Ator> getElenco() {
        return elenco;
    }

    public void adicionarAtor(Ator ator) {
        this.elenco.add(ator);
    }

    @Override
    public String toString() {
        return "ID: " + id + 
               "\nFilme: " + nome + 
               "\nLançamento: " + dataLancamento + 
               "\nOrçamento: " + orcamento + 
               "\nDescrição: " + descricao + 
               "\nDiretor: " + (diretor != null ? diretor.getNome() : "Nenhum") + 
               "\nElenco: " + elenco;
    }
}
