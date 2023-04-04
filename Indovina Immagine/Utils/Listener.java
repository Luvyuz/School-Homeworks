package Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.GUIWindow;
import Main.IndovinaImmagine;

public class Listener implements ActionListener {

    private GUIWindow GUI;
    private IndovinaImmagine gioco;
    public Listener(GUIWindow GUI){
        this.GUI = GUI;
        gioco = new IndovinaImmagine();
        gioco.setLblImg(GUI.getLabelImg());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = e.getActionCommand();

        switch(scelta){

            case "Conferma":

                gioco.reset();
                /*
                if(gioco.indovinato(GUI.getSelectedButton())){
                    System.out.println("Hai indovinato!");
                }else{
                    System.out.println("Non hai indovinato!");
                }
 */
                GUI.resetOptions();
                GUI.aggiungiRadioButttons();
                break;
            default:
                //Da aggiungere altre features
                //System.out.println("Nessun ActionPerformed");
                break;
        }
    }
}
