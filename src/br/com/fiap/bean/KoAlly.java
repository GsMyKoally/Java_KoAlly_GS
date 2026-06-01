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

    //  GETTERS/SETTERS //

    public Missao getMissaoAtual() {
        return missaoAtual;
    }

    //  MÉTODOS //

    public SessaoMental iniciarSessaoMental(Astronauta astronauta){
        SessaoMental sess = new SessaoMental();
        sess.setAstronauta(astronauta);
        return sess;
    }

    public Alerta emitirAlerta(Tipo_Alerta tipo, String desc, Gravidade_Alerta grav){
        return new Alerta(tipo,desc,grav);
    }

    public String analisarEstadoTripulacao(){
        return "";
    }


}
