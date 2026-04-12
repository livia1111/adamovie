package org.adafilmes;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    private String estilo;

    public Diretor(String nome, LocalDate dataNascimento, String nacionalidade, String estilo) {
        super(nome, dataNascimento, nacionalidade);
        this.estilo = estilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
