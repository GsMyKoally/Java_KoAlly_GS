package br.com.fiap.bean;

import java.util.List;

public class HistoricoSaude implements Analisavel{
    //Criando atributos
    private List<SessaoMental> sessoes;
    private int totalSessoes;
    private Astronauta astronauta;

    //Criando construtores
    public HistoricoSaude(){}
    public HistoricoSaude(List<SessaoMental> sessoes, int totalSessoes, Astronauta astronauta) {
        this.sessoes = sessoes;
        this.totalSessoes = totalSessoes;
        this.astronauta = astronauta;
    }

    //Criando getters e setters
    public List<SessaoMental> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<SessaoMental> sessoes) {
        this.sessoes = sessoes;
    }

    public int getTotalSessoes() {
        return totalSessoes;
    }

    public void setTotalSessoes(int totalSessoes) {
        this.totalSessoes = totalSessoes;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }


    //Criando e importando metodos da classe
    public void adicionarSessao(SessaoMental sessao){
        sessoes.add(sessao);
        totalSessoes++;
    }

    public double calcularMediaHumor(){
        double soma = 0;
        for(int i = 0; i < sessoes.size(); i++){
            soma += sessoes.get(i).getNivelHumor();
        }
        if (totalSessoes == 0){
            return 0;
        }
        else {
            return soma / totalSessoes;
        }
    }

    public String exibirRelatorioCompleto(){
        String relatorio = "==== RELATÓRIO COMPLETO DE SESSÕES ====\n";
        for (int i = 0; i < totalSessoes; i++){
            relatorio += sessoes.get(i).exibirResumoSessao() + "\n----------------\n";
        }
        return relatorio;
    }

    public String exibirRelatorioCompleto(int ultimas){
        String relatorio = "==== RELATÓRIO COMPLETO DAS " + ultimas + " ÚLTIMAS SESSÕES ====\n";
        int indice = totalSessoes - ultimas;
        if (indice < 0){
            indice = 0;
        }
        for (int i = indice; i < totalSessoes; i++){
            relatorio += sessoes.get(i).exibirResumoSessao() + "\n----------------\n";
        }
        return relatorio;
    }

    public String analisar() {
        double media = calcularMediaHumor();
        if (media < 5.0){
            return "Atenção: O astronauta precisa de acompanhamento.";
        }
        else {
            return "O astronauta está estável.";
        }
    }

    public String gerarRelatorio() {
        return exibirRelatorioCompleto();
    }
}
