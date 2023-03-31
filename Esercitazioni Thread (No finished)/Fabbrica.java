import java.util.LinkedList;
/*
            T. prod.   Distanza
ALFA        500 gg        800 km
BRAVO       450 gg        400 km
CHARLIE     600 gg        300 km
DELTA       350 gg        600 km
ECHO        720 gg        200 km
t = distanza * 0,1
 */
public class Fabbrica extends Thread {
    private String nome,id;
    private double tempoProd,tempoTrasferimento;
    private int distanza;
    private Magazzino magazzino;
    private Trasportatore traportatore;
    public Fabbrica(String nome, String id, Magazzino magazzino, LinkedList<Ente> listaEnti){
        this.nome = nome;
        this.id = id;
        this.magazzino = magazzino;
        this.tempoProd = getTempoProduzione(nome);
        this.distanza = getDistanza(nome);
        tempoTrasferimento = distanza * 10;
        traportatore = new Trasportatore(magazzino, (long) tempoTrasferimento, listaEnti);
    }
    private int getDistanza(String nome){
        switch(nome){
            case "Alfa":
                return 800;
            case "Bravo" :
                return 400;
            case "Charlie":
                return 300;
            case "Delta" :
                return 600;
            case "Echo":
                return 200;
            default:
                return 0;
        }
    }
    private int getTempoProduzione(String nome){
        switch(nome){
            case "Alfa":
                return 500;
            case "Bravo" :
                return 450;
            case "Charlie":
                return 500;
            case "Delta" :
                return 450;
            case "Echo":
                return 500;
            default:
                return 0;
        }
    }
    private void produci(){
        synchronized(magazzino){
            while(magazzino.getBuffer().size() == magazzino.getMaxSize()){
                System.out.println("Buffer pieno! In attesa...");
                try{
                    magazzino.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            Aereo aereo = new Aereo();
            magazzino.aggiungiAereo(aereo);
            System.out.println(nome + id + " sta producendo aereo N " + aereo.getID() + "...");
            magazzino.notifyAll();
        }
    }
    @Override
    public void run() {
        traportatore.start();
        while(!Trasportatore.interrupted()){
            try{
                Thread.sleep((long) tempoProd * 10);
                produci();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }  
    }
    @Override
    public String toString(){
        return nome + " " + id + " " + " Tempo produzione: " + tempoProd + " gg " + "Distanza: " + distanza;
    }
}