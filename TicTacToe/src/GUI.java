import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GUI extends JFrame {
    private Control control;
    private boolean activePlayer;
    JButton[] buttons = new JButton[9];

    Container cp;

    JPanel gamePanel;
    char playerMark = 'x';



    public GUI(Control control) {
        this.control = control;
        setTitle("Tic Tac Toe");
        setSize(500, 500);

        cp = this.getContentPane();
        cp.setLayout(null);

        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 500, 500);
        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setBackground(Color.green);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public byte[] openGame() {
        cp.add(gamePanel);
        initializeButtons();
        revalidate();


        return new byte[0];
    }


    public void initializeButtons() {

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
                                buttonClicked.setBackground(Color.cyan);
                                playerOturn();
                            } else {
                                buttonClicked.setBackground(Color.orange);
                                playerXturn();
                            }
                            displayVictor();
                        }
                    }
                });

                gamePanel.add(buttons[i]);
            }
        }
    }
    public void playerXturn(){

            playerMark = 'x';
        setCurrentPlayer(true);
        updateActivePlayer(true);

    }

    public void playerOturn(){

        playerMark='o';
        setCurrentPlayer(true);
        updateActivePlayer(true);
    }

    public void displayVictor() {
        if (checkForWinner()) {
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

    public void resetTheButtons() {
        for (int i = 0; i < 9; i++) {
            playerMark = 'x';
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
        }
    }

    public boolean checkForWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean checkDraw() {
        boolean full = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().charAt(0) == '-') {
                full = false;
            }
        }
        return full;
    }

    public boolean checkRows() {
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

    public boolean checkColumns() {
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

    public boolean checkDiagonals() {
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) &&
                buttons[0].getText().charAt(0) != '-')
            return true;
        else
            return buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                    && buttons[2].getText().charAt(0) != '-';
    }


    public void openConnectionMenu() {
        JFrame connectIP = new JFrame("Connection Screen");
        connectIP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField textField = new JTextField("Ip-Adress:", 30);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.connectToServer(textField.getText());

            }
        });

        JFrame frameMenu = new JFrame();
        JPanel panel = new JPanel();
        frameMenu.setTitle("Connection Screen");
        panel.add(textField);
        frameMenu.add(panel, BorderLayout.CENTER);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.pack();
        frameMenu.setVisible(true);

    }

    public void hostServer() {
        control.hostGame();
    }

    public void setCurrentPlayer(boolean activePlayer) {
        System.out.println("Your turn: " + playerMark);
        this.activePlayer = activePlayer;
        updateActivePlayer(activePlayer);
    }

    public void updateActivePlayer(boolean activePlayer) {
        if (playerMark == 'x') {
            playerMark = 'o';
        }
            else{
                playerMark='x';
            }
        }


        }







