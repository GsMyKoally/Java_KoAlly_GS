package br.com.fiap.bean;

import java.time.LocalDateTime;

public class SessaoMental implements Analisavel{
    //Criando atributos
    private int idSessao;
    private LocalDateTime data = LocalDateTime.now();
    private int nivelHumor;
    private String sentimentoRelatado;
    private String recomendacao;
    private Astronauta astronauta;

    //Criando construtores
    public SessaoMental(){}
    public SessaoMental(int idSessao, LocalDateTime data, int nivelHumor, String sentimentoRelatado, String recomendacao, Astronauta astronauta) {
        this.idSessao = idSessao;
        this.data = data;
        this.nivelHumor = nivelHumor;
        this.sentimentoRelatado = sentimentoRelatado;
        this.recomendacao = recomendacao;
        this.astronauta = astronauta;
    }

    //Criando getters e setters
    public int getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getNivelHumor() {
        return nivelHumor;
    }
    public void setNivelHumor(int nivelHumor) {
        this.nivelHumor = nivelHumor;
    }

    public String getSentimentoRelatado() {
        return sentimentoRelatado;
    }
    public void setSentimentoRelatado(String sentimentoRelatado) {
        this.sentimentoRelatado = sentimentoRelatado;
    }

    public String getRecomendacao() {
        return recomendacao;
    }
    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }
    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }

    //Criando e importando metodos da classe
    public void avaliarHumor(int nivelHumor, String sentimento){
        this.nivelHumor = nivelHumor;
        this.sentimentoRelatado = sentimento;
        try {
            if (nivelHumor >= 1 && nivelHumor <= 3) {
                recomendacao = "critico";
            }
            else if(nivelHumor >= 4 && nivelHumor <=6){
                recomendacao = "atencao";
            }
            else if (nivelHumor >= 7 && nivelHumor <= 10){
                recomendacao = "estavel";
            }
            else {
                throw new Exception("ERRO: Nível fora dos parâmetros! Coloque de 1-10.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String gerarRecomendacao(){
        try {
            if (nivelHumor >= 1 && nivelHumor <= 3){
                return recomendacao = "Contato imediato com a Terra e exercício de respiração guiada.";
            }
            else if(nivelHumor >= 4 && nivelHumor <=6){
                return recomendacao = "Pausa de 30 minutos e sessão de relaxamento.";
            }
            else if (nivelHumor >= 7 && nivelHumor <= 10){
                return recomendacao = "Continue assim! Atividade recreativa sugerida.";
            }
            else {
                throw new Exception("ERRO: Sistema foi incapaz de gerar recomendação!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recomendacao;
    }

    public String exibirResumoSessao(){
        return String.format("ID.Sessão: %d\nData da sessão: %s\nAstronauta: %s\nNível de humor: %d\nSentimento relatado:\n-%s\nRecomendação: %s",
                getIdSessao(),getData(),getAstronauta().getNome(),getNivelHumor(),getSentimentoRelatado(),getRecomendacao());
    }

    public String analisar(){
        return "Estado emocional da sessão " + idSessao + ": " + recomendacao;
    }

    public String gerarRelatorio(){
        return exibirResumoSessao();
    }
}
