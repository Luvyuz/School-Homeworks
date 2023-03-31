/*
 * 
 * 31-03-2023
 * Class thread che stampa il proprio id
 */
public class ThreadStampa extends Thread{

    private int id;
    public ThreadStampa(int id){
        this.id = id;
    }
    public String toString(){
        return "Sono il Thread con id: " + id;
    }
    @Override
    public void run(){
        for(int i = 0; i < 5; i++)
            System.out.println(toString());
    }
}