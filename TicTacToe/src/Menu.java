import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private GUI gui;


    public Menu(GUI gui) {
        this.gui = gui;
        JButton button = new JButton("Play");
        JTextArea textArea = new JTextArea("TIC-TAC-TOE");
        JFrame frameMenu = new JFrame();
        JPanel panel = new JPanel();

        frameMenu.setSize(500,500);

        panel.setBounds(500, 500, 500, 500);
        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.CENTER);
        button.setPreferredSize(new Dimension(500, 500));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.openGame();
                gui.openConnectionMenu();
            }
        });
        frameMenu.add(panel, BorderLayout.CENTER);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setTitle("TIC-TAC-TOE Menu");

        frameMenu.setVisible(true);


    }

}
