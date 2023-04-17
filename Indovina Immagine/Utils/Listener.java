package Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import Main.GameGUI;

public class Listener implements ActionListener {

    private GameGUI GUI;
    
    public Listener(GameGUI GUI){
        this.GUI = GUI;
        GUI.startGame();
        GUI.getGame().setLblImg(GUI.getLabelImg());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String scelta = e.getActionCommand();

        switch(scelta){ 

            case "Conferma":
                if(GUI.getGame().getNomeImg() == null)
                    GUI.getGame().reset();
                if(GUI.getGame().indovinato(GUI.getSelectedButton())){
                    System.out.println("Hai indovinato!");
                }else{
                    System.out.println("Non hai indovinato!");
                }
                GUI.getGame().reset();
                GUI.resetOptions();
                GUI.updateButtons();
                GUI.updatePoints();
                break;
            case "Inizia":
                GUI.getBtnGeneraImg().setText("Conferma");
                if(GUI.getGame().getNomeImg() == null)
                GUI.getGame().reset();
                GUI.resetOptions();
                GUI.updateButtons();
                GUI.updatePoints();
                break;
            case "Chiudi":
                JOptionPane.showMessageDialog(new JFrame() , "Punti: "  + GUI.getGame().getPunti() , "Fine Gioco", JOptionPane.CLOSED_OPTION);
                FileManager.salvaSuFile(GUI.getNomeUtente(), GUI.getGame().getPunti());
                GUI.getGameFrame().dispatchEvent(new WindowEvent(GUI.getGameFrame(), WindowEvent.WINDOW_CLOSING));
                break;
            default:
                //Da aggiungere altre features
                //System.out.println(e.getActionCommand());
                break;
        }
    }
}
