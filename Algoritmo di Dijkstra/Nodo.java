import java.util.LinkedList;

public class Nodo {
    private int id;
    private int distanza;
    private boolean visitato;
    private LinkedList<Link> links;

    public Nodo(int id) {
        this.id = id;
        this.distanza = Integer.MAX_VALUE;
        this.visitato = false;
        this.links = new LinkedList<Link>();
    }

    public int getId() {
        return id;
    }

    public void setDistanza(int distanza) {
        this.distanza = distanza;
    }

    public int getDistanza() {
        return distanza;
    }

    public void setVisitato(boolean visitato) {
        this.visitato = visitato;
    }

    public boolean isVisitato() {
        return visitato;
    }

    public LinkedList<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }
}
