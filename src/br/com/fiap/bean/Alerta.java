package br.com.fiap.bean;

import java.time.LocalDate;

public class Alerta {

    private Tipo_Alerta tipo;
    private String descricao;
    private Gravidade_Alerta nivelGravidade;
    private LocalDate dataHora;
    private boolean resolvido = false;

    public String getDescricao() {
        return descricao;
    }

    public Gravidade_Alerta getNivelGravidade() {
        return nivelGravidade;
    }

    public Tipo_Alerta getTipo() {
        return tipo;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public Alerta(Tipo_Alerta tipo, String descricao, Gravidade_Alerta gravidade){
        this.tipo = tipo;
        this.descricao = descricao;
        this.nivelGravidade = gravidade;
        this.dataHora = LocalDate.now();
    }
}
