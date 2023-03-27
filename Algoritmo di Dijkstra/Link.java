public class Link {
    private Nodo partenza;
    private Nodo destinazione;
    private int peso;

    public Link(Nodo partenza, Nodo destinazione, int peso) {
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.peso = peso;
    }

    public Nodo getPartenza() {
        return partenza;
    }

    public Nodo getDestinazione() {
        return destinazione;
    }

    public int getPeso() {
        return peso;
    }
}
