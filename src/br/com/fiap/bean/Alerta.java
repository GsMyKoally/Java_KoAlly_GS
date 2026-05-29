package br.com.fiap.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Alerta {

    //  ATRIBUTOS   //

    private Tipo_Alerta tipo;
    private String descricao;
    private Gravidade_Alerta nivelGravidade;
    private LocalDateTime dataHora;
    private boolean resolvido = false;

    //  GETTERS/SETTERS //

    public String getDescricao() {
        return descricao;
    }

    public Gravidade_Alerta getNivelGravidade() {
        return nivelGravidade;
    }

    public Tipo_Alerta getTipo() {
        return tipo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    //  CONSTRUTOR  //

    public Alerta(Tipo_Alerta tipo, String descricao, Gravidade_Alerta gravidade){
        this.tipo = tipo;
        this.descricao = descricao;
        this.nivelGravidade = gravidade;
        this.dataHora = LocalDateTime.now();
    }

    //  MÉTODOS //

    public void marcarResolvido(boolean status) {
        this.resolvido = status;
    }
    public String exibirAlerta(){
        return String.format("""
                Alerta!
                %s
                Tipo: %s
                Gravidade: %s
                Data de Emissão: %s
                Situação: %s
                """,getDescricao(),getTipo(),getNivelGravidade(), getDataHora(), isResolvido()? "Resolvido": "Pendente");
    }

}
