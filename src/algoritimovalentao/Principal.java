package algoritimovalentao;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws SocketException, UnknownHostException {
            Servidor servidor = new Servidor(40000);
        List<Processo> processos = new ArrayList<>() ;
       DeprecatedAlgoritimoValentao algoritmoValentao = new DeprecatedAlgoritimoValentao();
            Scanner sc = new Scanner( System.in);
            int opcao;
            do {
                System.out.println(".........");
                System.out.println("1. Subir novo processo");
                System.out.println("2. Enviar Mensagem");
                System.out.println("3. Derrubar processo");
                System.out.println("4. Realizar Nova Eleicao");
                System.out.println("5. Sair");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Novo Processo");
                        System.out.println("Digite o id do processo");
                        int id = sc.nextInt();

                        Processo processo = new Processo(id,true);
                        processos.add(processo);
                        System.out.println("Digite a mensagem");
                        String mensagem = sc.nextLine();
                        if (!processo.existeAlgumLiderAtivo())
                            algoritmoValentao.performElection();
                            processo.enviarProcesso(mensagem, 40000);
                        break;
                    case 2:

                        System.out.println("Nova Mensagem");

                        //Digite a mensagem a ser enviada
                        //Verifica se possui coordenador
                        //se sim, envia mensagem
                        //se nao, inicia nova eleicao
                        //verifica novamente se possui coordenador


                        break;
                    case 3:
                        System.out.println("Derrubar processo");
                        //Digite o IdProcesso a ser derrubado
                        //Se inativo, o processo já está inativo,
                        //Se nao, o processo nao existe
                    case 4:
                        System.out.println("Nova Eleicao");
                        //Forca uma nova eleicao com os status dos processos mantidos os mesmos
                        //nao sei se e nescessario essa opcao
                }
            } while(opcao != 5);

}}
