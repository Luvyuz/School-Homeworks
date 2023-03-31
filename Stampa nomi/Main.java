/*
 * 
 * 31-03-2023
 * Classe Main
 */
public class Main{
    public static void main(String[] args){
        for(int i = 0; i < 3; i++){
            new ThreadStampa(i).start();
        }
    }
}