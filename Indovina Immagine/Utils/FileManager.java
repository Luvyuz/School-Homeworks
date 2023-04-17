package Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;


public class FileManager {
    public class ImageID{
        public static final int ICONS = 0;
        public static final int FLAGS = 1;
    }
    public static final String FILE_PATH = "";
    public static final String ICONS_FILENAME = "IconImageList.txt";
    public static final String FLAGS_FILENAME = "FlagsImageList.txt";
    public static final String PLAYERS_FILENAME = "Utenti.txt";
    public static String[] loadFromFile(int n){
        LinkedList<String> listaParole = new LinkedList<>();
        switch(n){
            case ImageID.ICONS:
                try{
                    BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + ICONS_FILENAME));
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
            case ImageID.FLAGS:
                try{
                    BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + FLAGS_FILENAME));
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
        return null;
    }
    public static void salvaSuFile(String nome, int punti){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(PLAYERS_FILENAME, true));
            bw.write("Player: " + nome  + "-Punti: " + punti + "\n");
            try{
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
