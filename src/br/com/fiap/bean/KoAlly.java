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
    public void setMissaoAtual(Missao missaoAtual) {
        this.missaoAtual = missaoAtual;
    }
    public List<HistoricoSaude> getHistoricos() {
        return historicos;
    }
    public void setHistoricos(List<HistoricoSaude> historicos) {
        this.historicos = historicos;
    }
    public List<Alerta> getAlertasAtivos() {
        return alertasAtivos;
    }
    public void setAlertasAtivos(List<Alerta> alertasAtivos) {
        this.alertasAtivos = alertasAtivos;
    }


    //  MÉTODOS //

    public SessaoMental iniciarSessaoMental(Astronauta astronauta){
        SessaoMental sess = new SessaoMental();
        sess.setAstronauta(astronauta);
        return sess;
    }

    public Alerta emitirAlerta(Tipo_Alerta tipo, String desc, Gravidade_Alerta grav) {
        Alerta alerta = new Alerta(tipo, desc, grav);
        alertasAtivos.add(alerta);
        return alerta;
    }

    public String analisarEstadoTripulacao() {
        String relatorio = "=== ANÁLISE DO ESTADO DA TRIPULAÇÃO ===\n";
        int astronautasEmAtencao = 0;

        for (HistoricoSaude historico : historicos) {
            double media = historico.calcularMediaHumor();
            String nome = historico.getAstronauta().getNome();

            relatorio += "Astronauta: " + nome + "\n";
            relatorio += "Média de humor: " + String.format("%.2f", media) + "\n";

            if (media < 5.0 && historico.getTotalSessoes() > 0) {
                relatorio += "Status: NECESSITA DE ACOMPANHAMENTO\n";
                astronautasEmAtencao++;
            } else if (historico.getTotalSessoes() == 0) {
                relatorio += "Status: Sem sessões registradas\n";
            } else {
                relatorio += "Status: Estável\n";
            }
            relatorio += "------------------------\n";
        }

        relatorio += "\nTotal de astronautas em atenção: " + astronautasEmAtencao;

        return relatorio;
    }

    public String exibirPainelGeral(){
        String tripulacao = "";
        for (int i = 0; i < historicos.size(); i++){
            tripulacao += "Astronauta:" + historicos.get(i).getAstronauta().getNome() + "\n";
            tripulacao += historicos.get(i).analisar() + "\n";
        }

        return String.format("""
                Missão: %s
                Status: %s
                Tripulante e seu estado de saúde: \n%s
                """, getMissaoAtual().getNomeMissao(), getMissaoAtual().getStatus(), tripulacao);
    }

}
