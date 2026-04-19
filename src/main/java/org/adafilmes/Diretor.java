package org.adafilmes;

/**
 * Representa um diretor, que é uma especialização de Pessoa.
 *
 * @author Julia Kelly Silva Kishi
 */
public class Diretor extends Pessoa {

    /**
     * Construtor da classe Diretor.
     * @param nome O nome do diretor.
     */
    public Diretor(String nome) {
        super(nome);
    }

    @Override
    public String toString() {
        return "Diretor: " + getNome();
    }
}
