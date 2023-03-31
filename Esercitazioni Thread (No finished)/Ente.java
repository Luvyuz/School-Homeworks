import java.util.LinkedList;
/*
            Richiesti   Tempistiche
Marines         3           2000 gg
US Navy         5           2300 gg
Air Force       7           1500 gg
 */
public class Ente extends Thread {
    public static final String MARINES = "Marines";
    public static final String US_NAVY = "US Navy";
    public static final String AIR_FORCE = "Air Force";
    private String nome;
    private LinkedList<Aereo> spaziAerei;
    private int maxSize;
    private int tempistiche;
    private boolean timeOut = false;
    public Ente(String nome){
        this.nome = nome;
        spaziAerei = new LinkedList<>();
        maxSize = getMaxSize(nome);
        tempistiche = getTempistiche(nome);
        start();
    }
    public synchronized void addAereo(Aereo aereo){
        spaziAerei.add(aereo);
    }
    public int getMaxSize(String nome){
        switch(nome){
            case MARINES:
                return 3;
            case US_NAVY:
                return 5;
            case AIR_FORCE:
                return 7;
            default:
                return 0;
        }
    }
    public int getTempistiche(String nome){
        switch(nome){
            case MARINES:
                return 2000;
            case US_NAVY:
                return 1300;
            case AIR_FORCE:
                return 1500;
            default:
                return 0;
        }
    }
    public boolean isFull(){
        if(spaziAerei.size() == maxSize)
            return true;
        return false;
    }
    @Override
    public void run(){
        int tempo = 0;
        while(!isFull() || !timeOut){
            try{
                Thread.sleep(tempistiche);
                tempo ++;
                if(tempo >= tempistiche){
                    timeOut = true;
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
