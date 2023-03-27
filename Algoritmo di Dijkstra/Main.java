public class Main {
    public static void main(String[] args) {
            Grafo grafo = new Grafo();
    
            Nodo a = new Nodo(1);
            Nodo b = new Nodo(2);
            Nodo c = new Nodo(3);
            Nodo d = new Nodo(4);
            Nodo e = new Nodo(5);
    
            grafo.addNodo(a);
            grafo.addNodo(b);
            grafo.addNodo(c);
            grafo.addNodo(d);
            grafo.addNodo(e);
    
            grafo.addLink(new Link(a, b, 5));
            grafo.addLink(new Link(a, c, 2));
            grafo.addLink(new Link(b, c, 1));
            grafo.addLink(new Link(b, d, 3));
            grafo.addLink(new Link(c, d, 4));
            grafo.addLink(new Link(c, e, 6));
            grafo.addLink(new Link(d, e, 1));
    
            Grafo.dijkstra(grafo, a);
    
            for (Nodo nodo : grafo.getNodi())
                System.out.println("Nodo " + nodo.getId() + " distanza: " + nodo.getDistanza());
    }
}
