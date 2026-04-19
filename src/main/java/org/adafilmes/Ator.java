package org.adafilmes;

/**
 * Representa um ator, que é uma especialização de Pessoa.
 *
 * @author Julia Kelly Silva Kishi
 */
public class Ator extends Pessoa {

    /**
     * Construtor da classe Ator.
     * @param nome O nome do ator.
     */
    public Ator(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Ator: " + getNome();
    }
}
