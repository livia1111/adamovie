package org.adafilmes;

import java.time.LocalDate;
import java.util.List;

public class Filme {
    
    private String  nome;
    private LocalDate dataLancamento;
    private float orcamento;
    private Diretor diretor; //lista
    private List<Ator> atores; //lista
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataLancamento() {
        return dataLancamento;
    }
    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
    public float getOrcamento() {
        return orcamento;
    }
    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    public List<Ator> getAtores() {
        return atores;
    }
    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }
}
