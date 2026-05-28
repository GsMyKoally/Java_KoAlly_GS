package br.com.fiap.bean;
//Usando extends para importar os elementos da classe pai Pessoa
public class Astronauta extends Pessoa{
    //Criando atributos
    private String codAstronauta;
    private String funcao;
    private int diasEmMissao;
    private double nivelEstresse;

    //Criando Construtores vazio e com parâmetros
    public Astronauta(){}
    public Astronauta(String codAstronauta, String funcao, int diasEmMissao, double nivelEstresse) {
        this.codAstronauta = codAstronauta;
        this.funcao = funcao;
        this.diasEmMissao = diasEmMissao;
        this.nivelEstresse = nivelEstresse;
    }

    //Criando getters e setters
    public String getCodAstronauta() {
        return codAstronauta;
    }
    public void setCodAstronauta(String codAstronauta) {
        this.codAstronauta = codAstronauta;
    }
    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public int getDiasEmMissao() {
        return diasEmMissao;
    }
    public void setDiasEmMissao(int diasEmMissao) {
        this.diasEmMissao = diasEmMissao;
    }
    public double getNivelEstresse() {
        return nivelEstresse;
    }
    public void setNivelEstresse(double nivelEstresse) {
        this.nivelEstresse = nivelEstresse;
    }

    //Criando metodos e importando metodo exirbiDados
    public String exibirDados() {
        return String.format("Nome: %s\nIdade: %d\nNacionalidade: %s\nCódigo do astronauta: %s\nFunção: %s\nDias em missão: %d\nNível de estresse: %.1f", super.getNome(),super.getIdade(),super.getNacionalidade(),getCodAstronauta(),getFuncao(),getDiasEmMissao(),getNivelEstresse());
    }

    public void registrarDiaMissao(){
        this.diasEmMissao += 1;
        if (this.nivelEstresse < 10) {
            this.nivelEstresse += 0.3;
        }
    }

    public void atualizarNivelEstresse(double valor){
        try {
            if (valor > 0 && valor < 10) {
                this.nivelEstresse = valor;
            } else {
                throw new Exception("ERRO: Valor inválido! Coloque um valor entre 0-10");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
