package Main;
import javax.swing.*;
import Utils.FileManager;
import Utils.Listener;
import Utils.NumberGenerator;
import Utils.Timer;
import java.awt.*;

public class GameGUI extends JFrame {
    public static String LISTA_PAROLE[];
    private static final int nScelte = 4;
    private static JPanel pnlSceltaAnimali;
    private static JRadioButton rbScelte[];
    private static ButtonGroup bg;
    private static JLabel lblImg;
    private static JButton generaImg,btnFine;
    private static Listener l;
    private static JLabel lblTimer;
    private static int id; // Modalità di gioco: 1 Icone, 2 Bandiere
    private static IndovinaImmagine gioco;
    private static String nomeUtente;
    private static Timer timer;
    private static JLabel lblPunti;
    private static JPanel pnlNorth,pnlSouth;
    public GameGUI(int id){
        super("GUI scelta Immagine");
        GameGUI.id = id;
        init();
        add(pnlNorth,BorderLayout.NORTH);
        add(pnlSceltaAnimali,BorderLayout.WEST);
        add(lblImg,BorderLayout.CENTER);
        add(pnlSouth,BorderLayout.SOUTH);
        add(lblTimer,BorderLayout.EAST);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init(){
        setLayout(new BorderLayout());
        LISTA_PAROLE = FileManager.loadFromFile(id);
        pnlSceltaAnimali = new JPanel(new GridLayout(4,1));
        pnlNorth = new JPanel(new GridLayout(1, 2));
        pnlSouth = new JPanel(new GridLayout(1,2));
        lblImg = new JLabel();
        lblTimer = new JLabel();
        lblPunti = new JLabel();
        bg = new ButtonGroup();
        generaImg = new JButton("Inizia");
        btnFine = new JButton("Chiudi");
        l = new Listener(this);
        generaImg.addActionListener(l);
        btnFine.addActionListener(l);
        rbScelte = new JRadioButton[nScelte];
        for(int i = 0 ; i < nScelte ; i ++)
        rbScelte[i] = new JRadioButton();
        timer = new Timer();
        timer.setLabel(lblTimer);
        
        pnlSouth.add(generaImg);
        pnlSouth.add(btnFine);
        pnlNorth.add(lblPunti);
        pnlNorth.add(lblTimer);

    }
    public void createPlayer(String nome){
        nomeUtente = nome;
    }
    public String getNomeUtente(){
        return nomeUtente;
    }
    public GameGUI getGameFrame(){
        return this;
    }
    private String[] generaParole(){
        String parole[] = new String[nScelte];
        NumberGenerator nGenerator = new NumberGenerator(0, nScelte);
        for(int i = 0; i < nScelte; i++){
            int nRand = nGenerator.randomGeneration();
            parole[i] = LISTA_PAROLE[nRand];
        }
        return parole;
    }
    public void updateButtons(){
        String[] parole = generaParole();
        for(int i = 0; i < nScelte; i++){
            rbScelte[i].setText(parole[i]);
            rbScelte[i].setActionCommand(parole[i]);
            rbScelte[i].addActionListener(l);
            bg.add(rbScelte[i]);
            pnlSceltaAnimali.add(rbScelte[i]);
        }
        int j = (int) (Math.random() * nScelte);
        rbScelte[j].setText(gioco.getNomeImg());
        rbScelte[j].setActionCommand(gioco.getNomeImg());
    }
    public JLabel getLabelImg(){
        return lblImg;
    }
    public void resetOptions(){
        bg.clearSelection();
    }
    public String getSelectedButton(){
        for(int i = 0; i < nScelte; i++){
            if(rbScelte[i].isSelected()){
                //System.out.println(rbScelte[i].getText());
                return rbScelte[i].getText();
            }   
        }
        return null;
    }
    public JButton getBtnGeneraImg(){
        return generaImg;
    }
    public IndovinaImmagine getGame(){
        return gioco;
    }
    public void startGame() {
        gioco = new IndovinaImmagine();
    }
    public Timer getTimer(){
        return timer;
    }
    public void updatePoints(){
        lblPunti.setText("Punti" + "  " + String.valueOf(gioco.getPunti()));
    }
}
