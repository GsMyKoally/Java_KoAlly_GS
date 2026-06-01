package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

public class KoAlly {

    //  ATRIBUTOS    //

    private Missao missaoAtual;
    private List<HistoricoSaude> historicos = new ArrayList<>();
    private List<Alerta> alertasAtivos = new ArrayList<>();

    //  CONSTRUTORES    //

    public KoAlly(){}

    public KoAlly(Missao missaoAtual, List<HistoricoSaude> historicos, List<Alerta> alertasAtivos){
        this.missaoAtual = missaoAtual;
        this.historicos = historicos;
        this.alertasAtivos = alertasAtivos;
    }

    //  MÉTODOS //




}
