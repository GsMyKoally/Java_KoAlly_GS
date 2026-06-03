package br.com.fiap.main;

import br.com.fiap.bean.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        KoAlly koally = new KoAlly();
        Missao missao = new Missao();
        String escolha = "sim", nomeMissao, destinoMissao, nome, nacionalidade, codAstronauta, funcao, sentimento, descricao;
        int opcao, duracaoDias, qtdAstronauta, idade, escolhaAstronauta, nivelHumor, escolhaTipo, escolhaGravidade, escolhaRelatorio, ultimas, sessoes;

        //Parte 1: Cadastro
        try {
            System.out.println("==== SISTEMA INICIADO ====");
            System.out.println("Informe a quantidade de astronautas que participarão da missão");
            qtdAstronauta = scan.nextInt();
            scan.nextLine();
            if (qtdAstronauta < 1){
                System.out.println("ERRO: Quantidade inválida!");
            }
            for (int i = 0; i < qtdAstronauta; i++){
                System.out.println("==== Cadastro do Astronauta " + (i + 1) + " ====");

                System.out.println("Nome: ");
                nome = scan.nextLine();

                System.out.println("Idade: ");
                idade = scan.nextInt();
                scan.nextLine();

                System.out.println("Nacionalidade: ");
                nacionalidade = scan.nextLine();

                System.out.println("CodAstronauta: ");
                codAstronauta = scan.nextLine();

                System.out.println("Função na nave:");
                funcao = scan.nextLine();
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
            System.out.println("ERRO: Informação inserida está inválida!");
            return;
        }

        //Partes 2: Menu principal
        while(escolha.equalsIgnoreCase("sim")){
            try {
                System.out.println("==== BOAS-VINDAS AO KOALLY ====");
                System.out.println("1.Realizar sessão de saúde mental" +
                        "\n2.Emitir alerta" +
                        "\n3.Painel geral da tripulação" +
                        "\n4.Analisar estado da tripulação" +
                        "\n5.Acessar histórico de um astronauta");
                opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o número do astronauta que deseja iniciar a sessão");
                        for (int i = 0; i < missao.getTripulacao().size(); i++){
                            System.out.println((i + 1) + "-" + missao.getTripulacao().get(i).getNome());
                        }
                        System.out.println("Insira: ");
                        escolhaAstronauta = scan.nextInt() - 1;
                        SessaoMental sm = koally.iniciarSessaoMental(missao.getTripulacao().get(escolhaAstronauta));

                        System.out.println("Bem vindo!\nMe diga como está seu humor no presente momento em um nível de 1-10");
                        nivelHumor = scan.nextInt();
                        scan.nextLine();

                        System.out.println("Agora, me diga qual sentimento está sentindo");
                        sentimento = scan.nextLine();
                        sm.avaliarHumor(nivelHumor, sentimento);
                        System.out.println("=== RESUMO DA SESSÃO ===\n" + sm.exibirResumoSessao());
                        for (int i = 0; i < koally.getHistoricos().size(); i++){
                            if(koally.getHistoricos().get(i).getAstronauta() == missao.getTripulacao().get(escolhaAstronauta)){
                                koally.getHistoricos().get(i).adicionarSessao(sm);
                                break;
                            }
                        }
                        System.out.println("-----------------------");
                        System.out.println("=== RECOMENDAÇÃO ===\n" + sm.gerarRecomendacao());
                        break;
                    case 2:
                        System.out.println("Escolha o tipo de alerta" +
                                "\n1.Saúde_mental" +
                                "\n2.Técnico" +
                                "\n3.Emergência" +
                                "\nInsira: ");
                        escolhaTipo = scan.nextInt();
                        Tipo_Alerta tipo = null;
                        switch (escolhaTipo){
                            case 1:
                                tipo = Tipo_Alerta.SAUDE_MENTAL;
                                break;
                            case 2:
                                tipo = Tipo_Alerta.TECNICO;
                                break;
                            case 3:
                                tipo = Tipo_Alerta.EMERGENCIA;
                                break;
                            default:
                                System.out.println("ERRO: Opção inválida");
                                break;
                        }
                        scan.nextLine();
                        System.out.println("Transcreva a descrição do alerta");
                        descricao = scan.nextLine();

                        System.out.println("Informe o nível da gravidade do problema" +
                                "\n1.Baixo" +
                                "\n2.Médio" +
                                "\n3.Crítico" +
                                "\nInsira: ");
                        escolhaGravidade = scan.nextInt();
                        Gravidade_Alerta gravidade = null;
                        switch (escolhaGravidade){
                            case 1:
                                gravidade = Gravidade_Alerta.BAIXO;
                                break;
                            case 2:
                                gravidade = Gravidade_Alerta.MEDIO;
                                break;
                            case 3:
                                gravidade = Gravidade_Alerta.CRITICO;
                                break;
                            default:
                                System.out.println("ERRO: Opção inválida");
                                break;
                        }
                        if (tipo != null && gravidade != null) {
                            Alerta alerta = koally.emitirAlerta(tipo, descricao, gravidade);
                            System.out.println(alerta.exibirAlerta());
                        }
                        break;
                    case 3:
                        System.out.println(koally.exibirPainelGeral());
                        break;
                    case 4:
                        System.out.println(koally.analisarEstadoTripulacao());
                        break;
                    case 5:
                        System.out.println("Digite o número do astronauta que deseja ver o histórico");
                        for (int i = 0; i < missao.getTripulacao().size(); i++){
                            System.out.println((i + 1) + "-" + missao.getTripulacao().get(i).getNome());
                        }
                        escolhaRelatorio = scan.nextInt() - 1;
                        HistoricoSaude hs = null;
                        for (int i = 0; i < koally.getHistoricos().size(); i++) {
                            if (koally.getHistoricos().get(i).getAstronauta() == missao.getTripulacao().get(escolhaRelatorio)) {
                                hs = koally.getHistoricos().get(i);
                            }
                        }
                        System.out.println("Qual das visualizações quer ver" +
                                "\n1.Relatório completo" +
                                "\n2.Últimas N sessões" +
                                "\nInsira: ");
                        sessoes = scan.nextInt();
                        if (sessoes == 1) {
                            if (hs != null) {
                                System.out.println(hs.exibirRelatorioCompleto() + "\n");
                            } else {
                                System.out.println("Histórico não encontrado");
                            }
                        } else if (sessoes == 2) {
                            System.out.println("Quais da ultimas sessões deseja ver?");
                            ultimas = scan.nextInt();
                            if (hs != null) {
                                System.out.println(hs.exibirRelatorioCompleto(ultimas));
                            } else {
                                System.out.println("Histórico não encontrado");
                            }
                        }
                        break;
                    default:
                        System.out.println("ERRO: opção inválida");
                        break;
                }
            } catch (Exception e) {
                scan.nextLine();
                System.out.println("ERRO: Opção inserida é inválida!");
            }
            System.out.println("Deseja continuar (Sim|Não)?");
            escolha = scan.next();
        }
        System.out.println("Encerrando sistema KoAlly... Até a próxima, astronauta" +
                "\n==== SISTEMA FINALIZADO ====");

    }
}
