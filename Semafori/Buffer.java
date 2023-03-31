/*
 * 
 * 31-03-2023
 * Classe buffer che condivide una variabile con la classe Contatore (thread)
 */
public class Buffer {
    
    private int n;

    public Buffer(){
        n = 0;
    }

    public synchronized void increment(){
        n ++;
    }
    
    public int getNumber(){
        return n;
    }
}
