import java.awt.*;
import javax.swing.*;
public class ComboBoxGUI extends JFrame{
    private JComboBox comboBox;
    private JLabel lblMessage;
    
    public ComboBoxGUI(String[] items){
        super("test");
        init(items);
        addComponets();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void init(String[] items){
        comboBox = new JComboBox<>(items);
        setLayout(new BorderLayout());
        lblMessage = new JLabel();
    }
    
    public void addComponets(){
        add(comboBox,BorderLayout.NORTH);
    }
}