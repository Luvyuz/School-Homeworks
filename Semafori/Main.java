/*
 * 
 * 31-03-2023
 * Classe Main
 */
public class Main{
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        for(int i = 0; i < 10; i++){
            Contatore contatore = new Contatore(i, buffer);
            contatore.start();
        }
    }
}