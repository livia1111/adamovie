package org.adafilmes;

/**
 * Representa uma pessoa no sistema.
 * Esta é uma classe abstrata que serve de base para outras categorias de pessoas.
 *
 * @author Julia Kelly Silva Kishi
 */
public abstract class Pessoa {
    private String nome;

    /**
     * Construtor da classe Pessoa.
     * @param nome O nome da pessoa.
     */
    public Pessoa(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o nome da pessoa.
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * @param nome O novo nome da pessoa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
