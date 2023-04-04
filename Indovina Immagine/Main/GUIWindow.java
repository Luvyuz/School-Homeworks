package Main;
import javax.swing.*;
import Utils.FileManager;
import Utils.Listener;
import Utils.Timer;
import java.awt.*;

public class GUIWindow extends JFrame {
    public static String LISTA_PAROLE[];
    private final int nScelte = 4;
    private JPanel pnlSceltaAnimali;
    private JRadioButton rbScelte[];
    private ButtonGroup bg;
    private JLabel lblImg;
    private JButton generaImg;
    private Listener l;
    private JLabel lblTimer;
    //public static JLabel lblPunti;
    public static Timer timer;
    public GUIWindow(){
        super("GUI scelta Immagine");
        init();

        add(pnlSceltaAnimali,BorderLayout.WEST);
        add(lblImg,BorderLayout.CENTER);
        add(generaImg,BorderLayout.SOUTH);
        add(lblTimer,BorderLayout.EAST);

        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void init(){
        setLayout(new BorderLayout());
        LISTA_PAROLE = FileManager.loadFromFile();
        pnlSceltaAnimali = new JPanel();
        pnlSceltaAnimali.setLayout(new GridLayout(4,1));
        lblImg = new JLabel();
        bg = new ButtonGroup();
        lblTimer = new JLabel();
        l = new Listener(this);
        generaImg = new JButton("Conferma");
        generaImg.addActionListener(l);
        rbScelte = new JRadioButton[nScelte];
        timer = new Timer(lblTimer);
        for(int i = 0 ; i < nScelte ; i ++)
            rbScelte[i] = new JRadioButton();
    }
    private String[] generaParole(){
        String parole[] = new String[nScelte];
        for(int i = 0; i < nScelte; i++){
            int nRand = (int) (Math.random() * LISTA_PAROLE.length);
            parole[i] = LISTA_PAROLE[nRand];
/*
            int doppione = 0;
            for(int l = 0; l < nScelte; i ++){
                if(parole[l].equalsIgnoreCase(LISTA_PAROLE[nRand])){
                    doppione ++;
                }
                if(doppione >= 2){
                    i--;
                }
            }
            //TODO: da sistemare il check che controlla che non ci sono 2 parole uguali
 */
        }
        return parole;
    }

    public void aggiungiRadioButttons(){
        String[] parole = generaParole();
        for(int i = 0; i < nScelte; i++){
            rbScelte[i].setText(parole[i]);
            rbScelte[i].setActionCommand(parole[i]);
            rbScelte[i].addActionListener(l);
            bg.add(rbScelte[i]);
            pnlSceltaAnimali.add(rbScelte[i]);
        }
        int j = (int) (Math.random() * nScelte);
        rbScelte[j].setText(IndovinaImmagine.getNomeImg());
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
}
