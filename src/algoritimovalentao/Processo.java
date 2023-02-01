package algoritimovalentao;

import java.io.IOException;
import java.net.*;

public class Processo{
    int id;
    boolean status;
    int porta;
    DatagramSocket cliente;
    InetAddress ip ;

    public Processo() throws SocketException, UnknownHostException {
        this.cliente = new DatagramSocket();
        this.ip = InetAddress.getByName("127.0.0.1");
    }

    public void iniciarProcesso(int id, boolean status, String mensagem, int porta) {
        this.id = id;
        this.status = status;
        this.porta = porta;
        byte[] mensagemEmBytes = mensagem.getBytes();
        DatagramPacket pacote = new DatagramPacket(mensagemEmBytes, mensagemEmBytes.length, this.ip, porta);
        try {
            this.cliente.send(pacote);
        } catch (IOException e) {
            System.out.println("Erro ao enviar pacote UDP" + e.getMessage());
        } finally {
            this.cliente.close();
        }


    }}