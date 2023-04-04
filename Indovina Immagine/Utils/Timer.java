package Utils;

import javax.swing.JLabel;

public class Timer extends Thread{

    private int timer = 30; //secondi
    private JLabel lblTimer;
    public Timer(JLabel lblTimer){
        this.lblTimer = lblTimer;
    }
    @Override
    public void run(){
        while(timer >= 0){
            lblTimer.setText(Integer.toString(timer));
            try{
                sleep(1000);
                timer --;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        lblTimer.setText("Time Out");
    }
}
