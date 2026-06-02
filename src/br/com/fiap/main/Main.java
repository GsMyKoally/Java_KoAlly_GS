package br.com.fiap.main;

import br.com.fiap.bean.Astronauta;
import br.com.fiap.bean.HistoricoSaude;
import br.com.fiap.bean.KoAlly;
import br.com.fiap.bean.Missao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KoAlly koally = new KoAlly();
        Missao missao = new Missao();
        String escolha = "sim", nomeMissao, destinoMissao, nome, nacionalidade, codAstronauta, funcao, sentimento, sessao, descricao;
        int opcao, duracaoDias, qtdAstronauta, idade, escolhaAstronauta, nivelHumor, escolhaTipo, escolhaGravidade, escolhaRelatorio, ultimas;

        //Parte 1: Cadastro
        try {
            System.out.println("==== SISTEMA INICIADO ====");
            System.out.println("Informe a quantidade de astronautas que participarão da missão");
            qtdAstronauta = scan.nextInt();
            if (qtdAstronauta < 1){
                System.out.println("ERRO: Quantidade inválida!");
            }
            for (int i = 0; i < qtdAstronauta; i++){
                System.out.println("==== Cadastro do Astronauta " + (i + 1) +" ====");
                System.out.println("Nome: ");
                nome = scan.next();

                System.out.println("Idade: ");
                idade = scan.nextInt();

                System.out.println("Nacionalidade: ");
                nacionalidade = scan.next();

                System.out.println("CodAstronauta: ");
                codAstronauta = scan.next();

                System.out.println("Função na nave:");
                funcao = scan.next();
                Astronauta astro = new Astronauta(nome, idade, nacionalidade, codAstronauta, funcao);
                missao.adicionarTripulante(astro);

                HistoricoSaude histor = new HistoricoSaude();
                histor.setAstronauta(astro);
                histor.setSessoes(new ArrayList<>());
                koally.getHistoricos().add(histor);
            }
            System.out.println("Para prosseguir informe os dados da missão");
            System.out.println("Nome da missão: ");
            nomeMissao = scan.nextLine();
            missao.setNomeMissao(nomeMissao);

            System.out.println("Destino da missão: ");
            destinoMissao = scan.nextLine();
            missao.setDestino(destinoMissao);

            System.out.println("Duração prevista da missão: ");
            duracaoDias = scan.nextInt();
            missao.setDuracaoPrevistaDias(duracaoDias);

            missao.iniciarMissao();
            koally.setMissaoAtual(missao);
            System.out.println("==== Missão iniciada com êxito! ====");
            System.out.println(missao.exibirDetalhesMissao());

        } catch (Exception e) {
            System.out.println("ERRO: Informação inserida está inválida!");;
        }

        //Partes 2: Menu principal
        while(escolha.equalsIgnoreCase("sim")){
            System.out.println("==== BOAS-VINDAS AO KOALLY ====");

            System.out.println("Deseja Continuar (Sim|Não)?");
            escolha = scan.next();
        }
        System.out.println("==== SISTEMA FINALIZADO ====\n==== VOLTE SEMPRE ====");

    }
}
