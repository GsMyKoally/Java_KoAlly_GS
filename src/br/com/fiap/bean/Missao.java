package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

public class Missao {

    //  ATRIBUTOS   //

    private String nomeMissao;
    private String destino;
    private int duracaoPrevistaDias;
    private Status_Missao status;
    private List<Astronauta> tripulacao = new ArrayList<>();

    //  GETTERS/SETTERS //

    public String getNomeMissao() {
        return nomeMissao;
    }

    public void setNomeMissao(String nomeMissao) {
        this.nomeMissao = nomeMissao;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracaoPrevistaDias() {
        return duracaoPrevistaDias;
    }

    public void setDuracaoPrevistaDias(int duracaoPrevistaDias) {
        this.duracaoPrevistaDias = duracaoPrevistaDias;
    }

    public Status_Missao getStatus() {
        return status;
    }

    public void setStatus(Status_Missao status) {
        this.status = status;
    }

    public List<Astronauta> getTripulacao() {
        return tripulacao;
    }

    public void setTripulacao(List<Astronauta> tripulacao) {
        this.tripulacao = tripulacao;
    }

    //  CONSTRUTOR  //

    public Missao(){}

    public Missao(String nomeMissao, String destino, int duracaoPrevistaDias, List<Astronauta> tripulacao){
        setNomeMissao(nomeMissao);
        setDestino(destino);
        setDuracaoPrevistaDias(duracaoPrevistaDias);
        setStatus(Status_Missao.PLANEJADA);
        setTripulacao(tripulacao);
    }

    //  MÉTODOS //

    public void adicionarTripulante(Astronauta astronauta){
        this.tripulacao.add(astronauta);
    }

    public void iniciarMissao(){
        setStatus(Status_Missao.EM_ANDAMENTO);
    }

    public String exibirDetalhesMissao(){
        StringBuilder nomesDaTripulacao = new StringBuilder();
        for (int i = 0; i < this.tripulacao.toArray().length; i++) {

            if( i == this.tripulacao.toArray().length - 1){
                nomesDaTripulacao.append(this.tripulacao.get(i).getNome()).append(".");
            }else{
                nomesDaTripulacao.append(this.tripulacao.get(i).getNome()).append(", ");
            }
        }
        return String.format("""
                Missão: %s
                Destino: %s
                Duração Prevista: %d
                Status Atual: %s
                Tripulação:
                %s
                """, getNomeMissao(), getDestino(), getDuracaoPrevistaDias(), getStatus(), nomesDaTripulacao);
    }
}
