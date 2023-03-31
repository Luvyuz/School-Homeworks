import java.util.LinkedList;

public class Trasportatore extends Thread{
    private Magazzino magazzino;
    private long tempoTrasferimento;
    public static LinkedList<Ente> listaEnti;
    public Trasportatore(Magazzino magazzino, long tempoTrasferimento, LinkedList<Ente> listaEnti){
        this.magazzino = magazzino;
        this.tempoTrasferimento = tempoTrasferimento;
        Trasportatore.listaEnti = listaEnti;
    }
    private void trasporta(){
        synchronized(magazzino){
            while(magazzino.getBuffer().isEmpty()){
                System.out.println("Buffer vuoto! In attesa...");
                try{
                    magazzino.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("Trasportando aereo N: " + magazzino.getAereo().getID());
            synchronized(listaEnti){
                if(listaEnti.get((int) (Math.random() * listaEnti.size())).isFull()){
                    listaEnti.get((int) (Math.random() * listaEnti.size())).addAereo(magazzino.trasportaAereo());
                }
            }
            magazzino.notifyAll();
        }
    }
    @Override
    public void run(){
        while(!finito()){
            try{
                Thread.sleep(tempoTrasferimento);
                trasporta();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }  
    }
    public boolean finito(){
        boolean finito = false;
        for(Ente e : listaEnti){
            if(e.isFull())
                finito = true;
        }
        return finito;
    }
}
