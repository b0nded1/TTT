import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends GUI implements ActionListener {



public Menu(){
JButton button = new JButton("Play");
JTextArea textArea = new JTextArea("TIC-TAC-TOE");
JFrame frameMenu = new JFrame();
JPanel panel = new JPanel();

panel.setBounds(500,500,500,500);
panel.setLayout(new BorderLayout());
panel.add(textArea, BorderLayout.CENTER);
panel.add(button, BorderLayout.CENTER);
button.setPreferredSize(new Dimension(10,10));

button.addActionListener(this);
frameMenu.add(panel,BorderLayout.CENTER);
frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frameMenu.setTitle("TIC-TAC-TOE Menu");

frameMenu.setVisible(true);



}


    @Override
    public void actionPerformed(ActionEvent e) {
        GUI.openGame();
        GUI.openConnectionMenu();

    }
}
