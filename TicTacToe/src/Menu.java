import javax.accessibility.AccessibleIcon;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {

    private GUI gui;
    private Server server;



    public Menu(GUI gui) {
        this.gui = gui;
        JButton button = new JButton("Join Game");
        JFrame frameMenu = new JFrame();
        JPanel panel = new JPanel();
        JButton host = new JButton("Host Game");
        JTextField titleMenu = new JTextField("TIC-TAC-TOE");
        frameMenu.setSize(500,500);
        titleMenu.setEditable(false);
        titleMenu.setFont(new Font("Arial",Font.PLAIN,60));
        titleMenu.setBackground(Color.lightGray);
        titleMenu.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setBounds(500, 500, 500, 500);
        panel.setLayout(new GridLayout(3,1,5,5));
        panel.add(titleMenu);
        panel.add(button);
        button.setSize(100,100);

        host.setPreferredSize(new Dimension(100,100));
        panel.add(host, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.openGame();
                System.out.println("Opengame 1");
                gui.openConnectionMenu();



                frameMenu.dispose();
            }
        });
        host.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.hostServer();
                frameMenu.dispose();
            }
        });
        frameMenu.add(panel, BorderLayout.CENTER);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setTitle("TIC-TAC-TOE Menu");

        frameMenu.setVisible(true);


    }

}
