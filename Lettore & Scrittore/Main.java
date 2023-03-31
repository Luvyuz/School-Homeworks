/*
 * 
 * 31-03-2023
 * Classe Main
 */
public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Scrittore scrittore = new Scrittore("Mario", buffer);
        Lettore lettore = new Lettore("Davide", buffer);

        scrittore.start();
        lettore.start();
        
    }
}
