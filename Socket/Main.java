import java.io.*;
import java.net.Socket;

public class Main{
    //API Application Programing Interface
    public static void main(String[] args) {
        
        String web = "www.gnu.org";//"www.isisbernocchi.edu.it";

        try(Socket server = new Socket(web, 80)){
            System.out.println(server.getLocalPort());
            InputStream is = server.getInputStream();
            OutputStream os = server.getOutputStream();
            PrintWriter out = new PrintWriter(os,true);
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            out.println("GET / HTTP/1.1");
            out.println("Host: " + web);
            out.println("Accept: text/html");
            out.println("");
            String msg = in.readLine();
            while(msg != null){
                System.out.println(msg);
                msg = in.readLine();
            }
        }catch(Exception e){
            System.err.println("Non posso collegarmi al sito web!");
        }
    }
}