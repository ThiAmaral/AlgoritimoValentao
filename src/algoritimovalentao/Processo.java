package algoritimovalentao;

import java.io.IOException;
import java.net.*;
import java.util.List;

public class Processo{
    public int getId() {
        return id;
    }

    private int id;

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    private boolean ativo;

    public boolean isLider() {
        return lider;
    }

    public void setLider(boolean lider) {
        this.lider = lider;
    }

    private boolean lider;
    private DatagramSocket cliente;
    private InetAddress ip ;

    public Processo(int id, boolean ativo) throws SocketException, UnknownHostException {
        this.id = id;
        this.ativo = ativo;
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
            if (p.lider && p.ativo) {
                temLider = true;
                break;
            }
        }
         return temLider;
        }

    public boolean isAtivo() {
        return ativo;
    }

}

