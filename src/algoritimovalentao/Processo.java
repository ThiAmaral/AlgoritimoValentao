package algoritimovalentao;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class Processo{
    private int id;
    private boolean status;
    private boolean lider;
    private DatagramSocket cliente;
    private InetAddress ip ;

    public Processo(int id, boolean status) throws SocketException, UnknownHostException {
        this.id = id;
        this.status = status;
        this.cliente = new DatagramSocket();
        this.lider = false;
        this.ip = InetAddress.getByName("127.0.0.1");
    }

    public void enviarProcesso( String mensagem, int porta) {

        byte[] mensagemEmBytes = mensagem.getBytes();
        DatagramPacket pacote = new DatagramPacket(mensagemEmBytes, mensagemEmBytes.length, this.ip, porta);
        try {
            this.cliente.send(pacote);
        } catch (IOException e) {
            System.out.println("Erro ao enviar pacote UDP" + e.getMessage());
        } finally {
            this.cliente.close();
        }
    }

    public boolean existeAlgumLiderAtivo(List<Processo> processos){
        boolean temLider = false;
        for(Processo p: processos) {
            if (p.lider && p.status) {
                temLider = true;
                break;
            }
        }
         return temLider;
        }
    }

