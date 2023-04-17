package Utils;

import javax.swing.JLabel;

public class Timer extends Thread{

    private int timer = 10; //secondi
    private JLabel lblTimer;
    private boolean timeOut = false;
    @Override
    public void run(){
        timer = 10;
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
        timeOut = true;
    }
    public boolean getTimeOut(){
        return timeOut;
    }
    public void setLabel(JLabel lblTimer){
        this.lblTimer = lblTimer;
    }
}
