import java.io.*;
import java.util.StringTokenizer;

public class FileManager {
    private static String info[][];
    public static final String FILENAME = "Database.csv";
    public static String[][] loadDatabase(){
        int nRighe = getRighe();
        //System.out.println(nRighe);
        info = new String[nRighe][Finestra.N_COLONNE];
		try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            try{
                int riga = 0;
                String str = br.readLine();
                while(str != null){
                    StringTokenizer st = new StringTokenizer(str);
                    int i = 0;
                    while(st.hasMoreTokens()){
                        info[riga][i] = st.nextToken(";");
                        System.out.println(info[riga][i]);
                        i ++;
                    }
                    riga ++;
                    str = br.readLine();
                }
            }catch(IOException e){
                ;
			}
            try{
                br.close();
            }catch(IOException e){
                ;
            }
		}catch(FileNotFoundException e){
			;
		}
        return info;
	}
    private static int getRighe(){
        int righe = 0;
		try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            try{
                String str = br.readLine();
                while(str != null){
                    righe ++;
                    str = br.readLine();
                }
            }catch(IOException e){
                ;
			}
            try{
                br.close();
            }catch(IOException e){
                ;
            }
		}catch(FileNotFoundException e){
			;
		}
        return righe;
    }
}