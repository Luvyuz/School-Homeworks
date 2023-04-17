package Main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Utils.FileManager.ImageID;

public class RegisterGUI extends JFrame {
    private JLabel lblNome,lblNomiModalita;
    private JTextField txtfldNome;
    private JPanel pnlInputUtente,pnlBottoni;
    private JButton btnIcone,btnBandiere;   //Bottoni per la scelta delle immagini
    public RegisterGUI(){
        super("Registrazione Utente");
        init();
        setLayout(new BorderLayout());

        add(pnlInputUtente,BorderLayout.NORTH);
        add(pnlBottoni,BorderLayout.SOUTH);
        add(lblNomiModalita,BorderLayout.CENTER);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init(){
        lblNome = new JLabel("Username");
        txtfldNome = new JTextField();
        btnIcone = new JButton("Icone");
        btnBandiere = new JButton("Bandiere");
        lblNomiModalita = new JLabel("Scegli il tipo di immagini per iniziare");
        pnlInputUtente = new JPanel(new GridLayout(1, 1));
        pnlBottoni = new JPanel(new GridLayout(1, 2));

        pnlBottoni.add(btnIcone);
        pnlBottoni.add(btnBandiere);

        pnlInputUtente.add(lblNome);
        pnlInputUtente.add(txtfldNome);
//
        btnIcone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(!txtfldNome.getText().isEmpty()){
                    GameGUI game = new GameGUI(ImageID.ICONS);
                    game.createPlayer(txtfldNome.getText());
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(new JFrame() , "Inserire il nome!" , "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnBandiere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(!txtfldNome.getText().isEmpty()){
                    GameGUI game = new GameGUI(ImageID.FLAGS);
                    game.createPlayer(txtfldNome.getText());
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(new JFrame() , "Inserire il nome!" , "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}