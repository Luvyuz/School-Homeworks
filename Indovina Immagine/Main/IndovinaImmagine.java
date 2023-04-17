 package Main;
import javax.swing.JLabel;

import Utils.ImageGenerator;

public class IndovinaImmagine {
    
    private int punti;
    private String nomeImg;
    private JLabel lblImg;
    public IndovinaImmagine(){
        punti = 0;
    }
    public void setLblImg(JLabel lblImg) {
        this.lblImg = lblImg;
    }
    public void reset(){
        nomeImg = ImageGenerator.setRandImg(lblImg);
    }
    public String getNomeImg(){
        return nomeImg;
    }
    public boolean indovinato(String parolaScelta){
        if(nomeImg.equalsIgnoreCase(parolaScelta)){
            punti ++;
            System.out.println("Punti " + punti);
            return true;
        }
        System.out.println("Punti " + punti);
        return false;
    }
    public int getPunti(){
        return punti;
    }
}
