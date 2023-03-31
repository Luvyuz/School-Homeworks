/*
 * 
 * 31-03-2023
 * Classe buffer condivisa con lo Scrittore e il Lettore
 */
import java.util.LinkedList;
import java.util.UUID;

public class Buffer {
    
    private LinkedList<UUID> buffer;
    private static final int MAX_SIZE = 5;
    
    public Buffer(){
        buffer = new LinkedList<>();
    }
    public synchronized void add(UUID uuid){
        buffer.add(uuid);
    }
    public synchronized UUID remove(){
        return buffer.removeFirst();
    }
    public boolean isFull(){
        if(buffer.size() >= MAX_SIZE)
            return true;
        return false;
    }
    public boolean isEmpty(){
        return buffer.isEmpty();
    }
}
