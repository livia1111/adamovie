package org.adafilmes;

public class Diretor extends Pessoa {

    public Diretor(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Diretor: " + getNome();
    }
}
