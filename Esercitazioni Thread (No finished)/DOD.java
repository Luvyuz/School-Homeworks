import java.util.LinkedList;

public class DOD {
    public static void main(String[] args) {
        new DOD();
    }
    private final int nFabbrica = 5;
    private final int nEnti = 3;
    private Magazzino magazzino;
    private Fabbrica fabbrica[];
    private Ente ente[];
    private LinkedList<Ente> listaEnti;
    public DOD(){
        init();
        startThread();
    }
    public void init(){
        listaEnti = new LinkedList<>();
        magazzino = new Magazzino();
        fabbrica = new Fabbrica[nFabbrica];
        ente = new Ente[nEnti];
        ente[0] = new Ente(Ente.AIR_FORCE);
        ente[1] = new Ente(Ente.US_NAVY);
        ente[2] = new Ente(Ente.MARINES);
        for(int i = 0; i < nEnti; i ++)
            listaEnti.add(ente[i]);
        fabbrica[0] = new Fabbrica("Alfa", "1", magazzino, listaEnti);
        fabbrica[1] = new Fabbrica("Bravo", "3", magazzino, listaEnti);
        fabbrica[2] = new Fabbrica("Charlie", "5", magazzino, listaEnti);
        fabbrica[3] = new Fabbrica("Delta", "6", magazzino, listaEnti);
        fabbrica[4] = new Fabbrica("Echo", "2", magazzino, listaEnti);
    }
    public void startThread(){
        for(int i = 0; i < nFabbrica; i ++)
            fabbrica[i].start();
    }
}
