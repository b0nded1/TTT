import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JPanel{
    JButton[] buttons = new JButton[9];
  char playerMark = 'x';
  static Server server = new Server();

    public GUI() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();

    }
    public static byte[] openGame(){
        TicTacToe ttt = new TicTacToe();

        JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new GUI());
        window.setBounds(500, 500, 500, 500);
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        return new byte[0];
    }
    public void initializeButtons () {
        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(new ActionListener() {


                public void actionPerformed(ActionEvent e) {
                    JButton buttonClicked = (JButton) e.getSource();

                    if (buttonClicked.getText().equals("-")) {
                        buttonClicked.setText(String.valueOf(playerMark));
                        if (playerMark == 'x') {
                            playerMark = 'o';
                            buttonClicked.setBackground(Color.cyan);


                        } else {
                            playerMark = 'x';
                            buttonClicked.setBackground(Color.ORANGE);

                        }
                        displayVictor();
                    }
                }
            });
            add(buttons[i]);
        }
    }



    public void displayVictor() {
        if (checkForWinner() == true) {
            if (playerMark == 'x') playerMark = 'o';
            else playerMark = 'x';
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over." + playerMark + " wins. Would you like to play again?", "Game Over.",
                    JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
            else System.exit(0);
        } else if (checkDraw()) {
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog(pane, "Draw. Play again?", "Game Over", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
            else System.exit(0);
        }
    }
    private void resetTheButtons () {
        for (int i = 0; i < 9; i++) {
            playerMark = 'x';
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
        }
    }
    public boolean checkForWinner () {
        if (checkRows() == true || checkColumns() == true || checkDiagonals() == true) return true;
        else return false;
    }
    public boolean checkDraw () {
        boolean full = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().charAt(0) == '-') {
                full = false;
            }
        }
        return full;
    }
    public boolean checkRows () {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) && buttons[i].getText().equals(buttons[i + 2].getText())
                    && buttons[i].getText().charAt(0) != '-') {
                return true;
            }
            i = i + 3;
        }
        return false;
    }
    public boolean checkColumns () {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText())
                    && buttons[i].getText().charAt(0) != '-') {
                return true;
            }
            i++;
        }
        return false;

    }

    public boolean checkDiagonals () {
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) &&
                buttons[0].getText().charAt(0) != '-')
            return true;
        else if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                && buttons[2].getText().charAt(0) != '-')
            return true;
        else return false;
    }



    public static void openConnectionMenu() {
        JFrame connectIP = new JFrame("Connection Screen");
        connectIP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField("IP-Adress:", 30);

        JTextArea textArea = new JTextArea();
        JFrame frameMenu = new JFrame();
        JPanel panel = new JPanel();
        frameMenu.setTitle("Connection Screen");
        panel.add(textField);
        panel.add(textArea);
        frameMenu.add(panel, BorderLayout.CENTER);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.pack();
        frameMenu.setVisible(true);

    }
}





