import java.io.*;
import java.util.StringTokenizer;

public class FileManager {
    private static String info[][];
    public static final String FILENAME = "Database.csv";
    public static String[][] loadDatabase(){
        
		try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            try{
                String str;
                int riga = 0;
                do{
                    str = br.readLine();
                    StringTokenizer st = new StringTokenizer(str);
                    while(st.hasMoreTokens()){
                        //info[riga][i] = st.nextToken();
                        System.out.println(st.nextToken(";"));
                    }
                    riga ++;
                }while(str != null);
            }catch(IOException e){
                    e.printStackTrace();
			}
			    try{
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
        return info;
	}
}
