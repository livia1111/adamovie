package org.adafilmes;

import java.time.LocalDate;

public class Ator extends Pessoa {
    double cache;

    public Ator(Long id, String nome, LocalDate dataNascimento, String nacionalidade, double cache) {
        super(id,nome,dataNascimento,nacionalidade);
        this.cache = cache;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }
}
