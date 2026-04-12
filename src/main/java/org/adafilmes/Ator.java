package org.adafilmes;

import java.time.LocalDate;

public class Ator extends Pessoa {
    double cache;

    public Ator(String nome, LocalDate dataNascimento, String nacionalidade, double cache) {
        super(nome,dataNascimento,nacionalidade);
        this.cache = cache;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }
}
