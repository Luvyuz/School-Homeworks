/*
 * 
 * 31-03-2023
 * Classe che serve a scrivere un id ed aggiungerlo nel buffer
 */
import java.util.UUID;

public class Scrittore extends Thread{

    private String nome;
    private Buffer buffer;

    private static final long SECONDS = 2;
    private static final long TIME_SLEEP = 1000 * SECONDS;
    
    public Scrittore(String nome, Buffer buffer){
        this.nome = nome;
        this.buffer = buffer;
    }
    
    private void scrivi(){
        synchronized(buffer){
            if(buffer.isFull()){
                try{
                    System.out.println("Buffer pieno! In attesa...");
                    /* Se il buffer è fermo mette in pausa il Thread */
                    buffer.wait();
                }catch(InterruptedException e){
                    ;
                }
            }
            buffer.add(UUID.randomUUID());
            /* Appena il buffer non è più piena, aggiunge un elemento al buffer e  "sveglia" gli altri Thread */
            buffer.notifyAll();
        }
    }

    @Override
    public void run(){
        while(true){
            scrivi();
            try{
                sleep(TIME_SLEEP);
            }catch(InterruptedException e){
                ;
            }
        }
    }
}