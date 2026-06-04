package br.com.fiap.bean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SessaoMental implements Analisavel{
    //Criando atributos
    private LocalDateTime data = LocalDateTime.now();
    private int nivelHumor;
    private String sentimentoRelatado;
    private String recomendacao;
    private Astronauta astronauta;
    private String estadoMental;


    //Criando construtores
    public SessaoMental(){}
    public SessaoMental( LocalDateTime data, int nivelHumor, String sentimentoRelatado, String recomendacao, Astronauta astronauta, String estadoMental) {
        this.data = data;
        this.nivelHumor = nivelHumor;
        this.sentimentoRelatado = sentimentoRelatado;
        this.recomendacao = recomendacao;
        this.astronauta = astronauta;
        this.estadoMental = estadoMental;
    }

    //Criando getters e setters
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
    public String getestadoMental() {
        return estadoMental;
    }
    public void setestadoMental(String estadoMental) {
        this.estadoMental = estadoMental;
    }

    //Criando e importando metodos da classe
    public void avaliarHumor(int nivelHumor, String sentimento){
        this.nivelHumor = nivelHumor;
        this.sentimentoRelatado = sentimento;
        try {
            if (nivelHumor >= 1 && nivelHumor <= 3) {
                estadoMental = "critico";
            }
            else if(nivelHumor >= 4 && nivelHumor <=6){
                estadoMental = "atencao";
            }
            else if (nivelHumor >= 7 && nivelHumor <= 10){
                estadoMental = "estavel";
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
                return recomendacao = "Recomendação: Contato imediato com a Terra e exercício de respiração guiada.";
            }
            else if(nivelHumor >= 4 && nivelHumor <=6){
                return recomendacao = "Recomendação: Pausa de 30 minutos e sessão de relaxamento.";
            }
            else if (nivelHumor >= 7 && nivelHumor <= 10){
                return recomendacao = "Recomendação: Continue assim! Atividade recreativa sugerida.";
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Data da sessão: %s\nAstronauta: %s\nNível de humor: %d\nSentimento relatado:\n-%s", getData().format(dtf),getAstronauta().getNome(),getNivelHumor(),getSentimentoRelatado());
    }

    public String analisar(){
        return "Estado emocional da sessão: " + recomendacao;
    }

    public String gerarRelatorio(){
        return exibirResumoSessao();
    }
}
