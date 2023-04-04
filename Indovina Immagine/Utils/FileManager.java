package Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class FileManager {
    private static final String FILENAME = "ListaImg.txt";
    public static String[] loadFromFile(){
        LinkedList<String> listaParole = new LinkedList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            String str = br.readLine();
            while(str != null){
                listaParole.add(str);
                str = br.readLine();
            }
            try{
                br.close();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("Errore durante la chiusura del File");
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Errore durante la caricamento del file! / File non trovato!");
        }
        return listaParole.toArray(new String[0]);
    }
}
