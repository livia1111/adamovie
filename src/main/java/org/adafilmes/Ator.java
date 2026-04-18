package org.adafilmes;

public class Ator extends Pessoa {

    public Ator(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Ator: " + getNome();
    }
}
