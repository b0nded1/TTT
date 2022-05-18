import java.io.IOException;
import java.util.ArrayList;

public class Control {

    private Client client;
    private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private GUI gui;
    private Menu menu;
    private Server server;


    /**
     * Das Ding hier nennt sich ein Constructor
     */
    public Control() {

    }

    /**
     * diese Funktion wird aufgerufen, wenn der Spieler dem Host betreten möchte
     * @param ip IP Adresse der beigetreten werden soll
     */
    public void connectToServer(String ip) {

        try {
            client = new Client(ip);
            System.out.println("Client Connected");
        } catch (IOException e) {
            System.out.println("Couldn't connect to server");
        }
    }

    /**
     * Diese Funktion wird aufgerufen, wenn der Spieler das Spiel hosten möchte
     */
    public void hostGame(){
        server = new Server(this);
        new Thread(server::startServer).start();
        try {
            client=new Client("127.0.0.1");
            gui.openGame();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Startet die Logic (erster Schritt in jedem OO projekt)
     */
    public void start() {
        gui = new GUI(this);
        menu = new Menu(gui);

    }
    public void GUIOpen(){
        gui.openGame();
        System.out.println("Open game 2");
    }

    public void addClienthandler(ClientHandler clientHandler) {
        clientHandlers.add(clientHandler);
    }

    public ClientHandler getClienthandler(int index) {
        return clientHandlers.get(index);
    }
}
