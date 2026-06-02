package br.com.fiap.main;

import br.com.fiap.bean.KoAlly;
import br.com.fiap.bean.Missao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KoAlly koally = new KoAlly();
        Missao missao = new Missao();
        String escolha = "sim", nomeMissao, destinoMissao, nome, nacionalidade, codAstronauta, funcao, sentimento, sessao, descricao;
        int opcao, duracaoDias, qtdAstronauta, idade, escolhaAstronauta, nivelHumor, escolhaTipo, escolhaGravidade, escolhaRelatorio, ultimas;
        while(escolha.equalsIgnoreCase("sim")){
            try {
                System.out.println("==== BOAS-VINDAS AO KOALLY ====\nPara prosseguir informe os dados da missão");
                System.out.println("Nome da missão: ");
                nomeMissao = scan.next();
                System.out.println("Destino da missão: ");
                destinoMissao = scan.next();
                System.out.println("Duração prevista da missão: ");
                duracaoDias = scan.nextInt();
                missao.setNomeMissao(nomeMissao);
                missao.setDestino(destinoMissao);
                missao.setDuracaoPrevistaDias(duracaoDias);
                System.out.println(String.format("%s\n%s\n%d",missao.getNomeMissao(), missao.getDestino(), missao.getDuracaoPrevistaDias()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("Deseja Continuar (Sim|Não)?");
            escolha = scan.next();
        }
        System.out.println("==== SISTEMA FINALIZADO ====\n==== VOLTE SEMPRE ====");

    }
}
