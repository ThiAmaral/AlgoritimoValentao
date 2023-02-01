/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimovalentao;
import java.util.*;

/**
 *
 * @author Thiago
 */
public class DeprecatedAlgoritimoValentao {
    
    //criar um novo socket, mensagem, processo/prioridade > eleito
        // initialize variables and array  
    class Process{  
    // declare variables  
    public int id;  
    public String status;  
      
    // initialize variables using constructor  
    public Process(int id){  
        this.id = id;  
        this.status = "ativo";  
    }  
}  
    Scanner sc;  
    Process[] processos;  
    int n;  
      
    // initialize Scanner class object in constructor  
    public DeprecatedAlgoritimoValentao(){  
        sc= new Scanner(System.in);  
    }  
      
    // create ring() method for initializing the ring  
    public void ring(){  
          
        // get input from the user for processos  
        System.out.println("Digite o número de processos");  
        n = sc.nextInt();  
          
        // initialize processos array  
        processos = new Process[n];  
        for(int i = 0; i< n; i++){  
            processos[i]= new Process(i);  
        }  
    }  
      
    // create election() method for electing process  
    public void performElection(List<Processo> listaProcessos){
  
        // we use the sleep() method to stop the execution of the current thread  
        try {  
            Thread.sleep(1000);  
        } catch (InterruptedException e) {  
              
            e.printStackTrace();  
        }  
          
        // show failed process  
        System.out.println("Processo de id "+ obterValorMaximo( listaProcessos) +" falhou");
          
        // change status to Inactive of the failed process  
        listaProcessos.get(obterValorMaximo(listaProcessos) ).setAtivo(false);
          
        // declare and initialize variables   
        int idInicio = 0;  
        boolean overStatus = true;  
          
        // use while loop to repeat steps   
        while(overStatus){  
              
            boolean maiorProcesso = false;  
              
            // iterate all the processos  
            for(int i = idInicio + 1; i< n; i++){  
                if(listaProcessos.get(i).isAtivo()){
                    System.out.println("Processo "+idInicio+" foi eleito("+idInicio+") para o processo " +i);  
                    maiorProcesso = true;  
  
                }  
            }  
              
            // check for higher process  
            if(maiorProcesso){  
                  
                // use for loop to again iterate processos  
                for(int i = idInicio + 1; i< n; i++){  
                    if(listaProcessos.get(i).isAtivo()){
                        System.out.println("Processo "+i+" passou Ok("+i+") para o Processo " +idInicio);  
                    }  
  
                }  
                // increment initiator id   
                idInicio++;  
            }  
  
            else{  
                // get the last process from the processos that will become coordinator  
                int coord =obterValorMaximo(listaProcessos);

                // show process that becomes the coordinator  
                System.out.println("O processo "+coord+" foi eleito");  
                  
                  
                for(int i = coord - 1; i>= 0; i--){  
                    if(listaProcessos.get(i).isAtivo()){
                        System.out.println("Processo "+coord+" cedeu a eleição ("+coord+") para o processo " +i);  
                    }  
                }  
                  
                  
                System.out.println("Fim da Eleição");  
                overStatus = false;  
                break;  
            }  
        }  
  
    }  
      
    // create getMaxValue() method that returns index of max process  
    public static int getMaxValue(List<Processo> listaProcessos){
          int mxId = -99;
        int mxIdIndex = 0;
        for(int i = 0; i<listaProcessos.size(); i++){
            if(listaProcessos.get(i).isAtivo() && listaProcessos.get(i).getId() >mxId){
                mxId = listaProcessos.get(i).getId();
                mxIdIndex = i;  
            }  
        }  
        return mxIdIndex;  
    }

    public static int obterValorMaximo(List<Processo> listaProcessos) {
        Processo processo = Collections.max(listaProcessos, Comparator.comparingInt(processo1 -> processo1.getId()));
        return processo.getId();
    }

    public Processo obterProcessoComMaiorId(List<Processo> listaProcessos) {
        Processo processo = Collections.max(listaProcessos, Comparator.comparingInt(processo1 -> processo1.getId()));
        return processo;
    }
      

}