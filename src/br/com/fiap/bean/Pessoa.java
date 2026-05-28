package br.com.fiap.bean;

public class Pessoa {
    //Atributos Pessoa
    private String nome;
    private int idade;
    private String nacionalidade;

    //Criando construtor
    public Pessoa(){}


    //Criando getters e setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    //Criando metodos
    public String exibirDados(){
        return String.format("Nome: %s\nIdade: %d\nNacionalidade: %s", getNome(),getIdade(),getNacionalidade());
    }
}
