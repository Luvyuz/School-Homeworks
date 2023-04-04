package Utils;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Main.GUIWindow;

public class ImageGenerator {
    public static final String PERCORSO = "Immagini/";
    public static final String ESTENSIONE = ".jpg";
    public static String setRandImg(JLabel lblImg){
        int n = (int) (Math.random() * GUIWindow.LISTA_PAROLE.length);
        ImageIcon imgIcon = new ImageIcon(PERCORSO + GUIWindow.LISTA_PAROLE[n] + ESTENSIONE);
        
        lblImg.setIcon(resize(imgIcon));
        System.out.println(n + " " + GUIWindow.LISTA_PAROLE[n]);
        return GUIWindow.LISTA_PAROLE[n];
    }
    //Ridimensiona l'immagine
    public static ImageIcon resize(ImageIcon imgIcon){
        Image img = imgIcon.getImage();
        Image resizedImg = img.getScaledInstance(512, 512, Image.SCALE_FAST);
        return new ImageIcon(resizedImg);
    }
}
