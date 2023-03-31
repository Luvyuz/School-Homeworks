/*
 * 
 * 31-03-2023
 * Classe che incrementa il valore nel buffer
 */
import java.util.concurrent.Semaphore;

public class Contatore extends Thread{
    
    private int id;
    private Buffer buffer;
    private Semaphore semaphore;
    private static final int SLOTS = 1;

    public Contatore(int id, Buffer buffer){
        this.id = id;
        this.buffer = buffer;
        /* Creo il numero di thread che possono accedere al buffer utilizzando un semaforo */
        semaphore = new Semaphore(SLOTS);
    }

    private void incrementa(){
        synchronized(buffer){
            try {
                /* Il Thread acquisisce il permesso */
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            buffer.increment();
            System.out.println("Thread " + id + " " + buffer.getNumber());
            /* Il Thread lascia il permesso ad un altro Thread */
            semaphore.release();
        }
    }
    
    @Override
    public void run(){
        while(true){
            incrementa();
        }
    }
}
