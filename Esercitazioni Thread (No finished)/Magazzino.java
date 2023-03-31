import java.util.LinkedList;

public class Magazzino {
    private LinkedList<Aereo> slotsAereo;
    private int maxSize;
    public Magazzino(int maxSize){
        this.maxSize = maxSize;
        slotsAereo = new LinkedList<>();
    }
    public Magazzino(){
        maxSize = 10;
        slotsAereo = new LinkedList<>();
    }
    public synchronized void aggiungiAereo(Aereo aereo){
        slotsAereo.add(aereo);
    }
    public synchronized Aereo getAereo(){
        return slotsAereo.getFirst();
    }
    public synchronized Aereo trasportaAereo(){
        return slotsAereo.pop();
    }
    public int getMaxSize(){
        return maxSize;
    }
    public LinkedList<Aereo> getBuffer(){
        return slotsAereo;
    }
}
