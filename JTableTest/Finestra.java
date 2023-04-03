import java.awt.*;
import javax.swing.*;
public class Finestra extends JFrame {
    
    private JTable jTable;
    private JScrollPane scrollPane;
    private String informazioni[][];
    private String[] nomiColonne = { "ID Prodotto", "Nome", "Descrizione", "Prezzo" };
    public static final int N_COLONNE = 4;
    public Finestra(){
        init();
        add(scrollPane);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init(){
        informazioni = FileManager.loadDatabase();
        jTable = new JTable(informazioni, nomiColonne);
        scrollPane = new JScrollPane(jTable);
    }
}
