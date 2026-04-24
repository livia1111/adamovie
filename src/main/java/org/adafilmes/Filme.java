/*
@author Livia
*/
package org.adafilmes;

import org.adafilmes.utils.FormatarData;
import org.adafilmes.utils.FormatarOrcamento;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um filme com informações de produção e elenco.
 * 
 * A classe Filme armazena dados essenciais de um filme incluindo identificador,
 * nome, data de lançamento, orçamento, descrição, diretor e elenco de atores.
 * Permite gerenciar as informações do filme através de getters, setters e métodos
 * auxiliares para manipulação do elenco.
 * 
 * @author Livia

 */
public class Filme {
    
    /** Identificador único do filme */
    private int id;
    
    /** Nome ou título do filme */
    private String nome;
    
    /** Data de lançamento do filme no formato de String */
    private String dataLancamento;
    
    /** Orçamento destinado à produção do filme */
    private String orcamento;
    
    /** Descrição ou sinopse do filme */
    private String descricao;
    
    /** Diretor responsável pela produção do filme */
    private Diretor diretor;
    
    /** Lista de atores que compõem o elenco do filme */
    private List<Ator> elenco;

    /**
     * Construtor para criar um novo objeto Filme.
     * 
     * Inicializa um filme com os dados básicos obrigatórios.
     * A lista de elenco é inicializada como vazia e pode ser preenchida
     * através do metodo {@link #adicionarAtor(Ator)}.
     * 
     * @param id Identificador único do filme
     * @param nome Nome ou título do filme
     * @param dataLancamento Data de lançamento do filme
     * @param orcamento Orçamento da produção do filme
     * @param descricao Descrição ou sinopse do filme
     * 
     * @throws IllegalArgumentException se o id for menor ou igual a zero
     */
    public Filme(int id, String nome, String dataLancamento, String orcamento, String descricao) {
        this.id = id;
        this.nome = nome;
        this.dataLancamento = FormatarData.formatoBR(dataLancamento);
        this.orcamento = FormatarOrcamento.formatarMoeda(orcamento);
        this.descricao = descricao;
        this.elenco = new ArrayList<>();
    }

    /**
     * Obtém o identificador único do filme.
     * 
     * @return o id do filme
     */
    public int getId() {
        return id;
    }

    /**
     * Obtém o nome ou título do filme.
     * 
     * @return o nome do filme
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome ou título do filme.
     * 
     * @param nome o novo nome do filme
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a data de lançamento do filme.
     * 
     * @return a data de lançamento do filme em formato de String
     */
    public String getDataLancamento() {
        return dataLancamento;
    }

    /**
     * Define a data de lançamento do filme.
     * 
     * @param dataLancamento a nova data de lançamento do filme
     */
    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    /**
     * Obtém o orçamento da produção do filme.
     * 
     * @return o orçamento do filme em valor float
     */
    public String getOrcamento() {
        return orcamento;
    }

    /**
     * Define o orçamento da produção do filme.
     * 
     * @param orcamento o novo orçamento do filme
     */
    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    /**
     * Obtém a descrição ou sinopse do filme.
     * 
     * @return a descrição do filme
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição ou sinopse do filme.
     * 
     * @param descricao a nova descrição do filme
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o diretor do filme.
     * 
     * @return o objeto Diretor responsável pelo filme, ou null se não houver diretor atribuído
     */
    public Diretor getDiretor() {
        return diretor;
    }

    /**
     * Define o diretor do filme.
     * 
     * @param diretor o novo diretor do filme
     */
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    /**
     * Obtém a lista de atores do elenco do filme.
     * 
     * @return uma List contendo todos os atores do elenco
     */
    public List<Ator> getElenco() {
        return elenco;
    }

    /**
     * Adiciona um ator ao elenco do filme.
     * 
     * O ator é adicionado ao final da lista de elenco.
     * Permite construir o elenco de forma incremental.
     * 
     * @param ator o ator a ser adicionado ao elenco
     * 
     * @throws NullPointerException se o ator for null
     * 
     * @see #getElenco()
     */
    public void adicionarAtor(Ator ator) {
        this.elenco.add(ator);
    }

    /**
     * Retorna uma representação em String do objeto Filme.
     * 
     * Exibe todas as informações do filme de forma formatada,
     * incluindo id, nome, data de lançamento, orçamento, descrição,
     * nome do diretor (ou "Nenhum" se não houver) e lista de atores.
     * 
     * @return uma String contendo as informações formatadas do filme
     */
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
