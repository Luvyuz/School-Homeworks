package Utils;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.GameGUI;

public class ImageGenerator {
    public static final String PERCORSO = "Immagini/";
    public static final String ESTENSIONE = ".jpg";
    public static String setRandImg(JLabel lblImg){
        int n = (int) (Math.random() * GameGUI.LISTA_PAROLE.length);
        ImageIcon imgIcon = new ImageIcon(PERCORSO + GameGUI.LISTA_PAROLE[n] + ESTENSIONE);
        
        lblImg.setIcon(resize(imgIcon));
        /* Debugging */
        //System.out.println(n + " " + GameGUI.LISTA_PAROLE[n]);
        return GameGUI.LISTA_PAROLE[n];
    }
    //Ridimensiona l'immagine
    public static ImageIcon resize(ImageIcon imgIcon){
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(512, 512, Image.SCALE_FAST);
        return new ImageIcon(resizedImg);
    }
}
