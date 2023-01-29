/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimovalentao;

/**
 *
 * @author Thiago
 */
import java.util.ArrayList;

public class Processo {
  int processoId;
  boolean valentao;

  public Processo(int processoId) {
    this.processoId = processoId;
    this.valentao = false;
  }

  public void elect() {
    ArrayList<Processo> processos = getProcessos();
    for (Processo p : processos) {
      if (p.processoId > this.processoId) {
        p.enviaMensagemEleicao();
      }
    }
  }

  public void recebeMensagemEleicao() {
    this.valentao = false;
    enviaMensagemValenao();
  }

  public void enviaMensagemEleicao() {
    // Code to send election message to higher-ranked process
  }

  public void enviaMensagemValenao() {
    // Code to send coordinator message to lower-ranked processes
    this.valentao = true;
  }

  public ArrayList<Processo> getProcessos() {
    // Code to retrieve a list of all processes
    return new ArrayList<Processo>();
  }
}

