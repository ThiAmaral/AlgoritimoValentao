package algoritimovalentao;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {
    private DatagramSocket servidor;

    public Servidor(int porta) throws SocketException {
        this.servidor = new DatagramSocket(porta);
    }

    public void iniciaServidor() throws IOException{
        do{
            byte[] dadosRecebidos = new byte[100];
            DatagramPacket processoRecebido = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
            this.servidor.receive(processoRecebido);
            String mensagem = new String(processoRecebido.getData(), 0, processoRecebido.getLength());
            InetAddress enderecoCliente = processoRecebido.getAddress();
            int portaCliente = processoRecebido.getPort();

            exibirMensagem(mensagem, enderecoCliente, portaCliente);

            confirmarRecebimento(enderecoCliente, portaCliente);
        }while (true);
    }

    private void exibirMensagem(String mensagem, InetAddress enderecoCliente, int portaCliente) {
        System.out.println("Mensagem: " + mensagem + " IP=  " + enderecoCliente + ":" + portaCliente);
    }

    private void confirmarRecebimento(InetAddress enderecoCliente, int portaCliente) throws IOException {
        byte[] confirmacao = "Recebido".getBytes();
        DatagramPacket sendPacket = new DatagramPacket(confirmacao, confirmacao.length, enderecoCliente, portaCliente);
        this.servidor.send(sendPacket);
    }

    public void fecharServidor(){
        this.servidor.close();
    }
}
