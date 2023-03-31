/*
 * 
 * 31-03-2023
 * Classe che serve a leggere i valori nel buffer
 */
public class Lettore extends Thread{

    private String nome;
    private Buffer buffer;

    public Lettore(String nome, Buffer buffer){
        this.nome = nome;
        this.buffer = buffer;
    }

    private void leggi(){
        synchronized(buffer){
            if(buffer.isEmpty()){
                try{
                    System.out.println("Buffer vuoto! In attesa...");
                    /* Mette in pausa il thread se il buffer è pieno */
                    buffer.wait();
                }catch(InterruptedException e){
                    ;
                }
            }
            System.out.println(buffer.remove());
            /* Appena il buffer ha qualche elemento, lo legge e "sveglia" gli altri Thread */
            buffer.notifyAll();
        }
    }

    @Override
    public void run(){
        while(true){
            leggi();
        }
    }
}
