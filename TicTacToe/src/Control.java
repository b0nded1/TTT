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
        } catch (IOException e) {
            System.out.println("Couldn't connect to server");
        }
    }

    /**
     * Diese Funktion wird aufgerufen, wenn der Spieler das Spiel hosten möchte
     */
    public void hostGame(){
        server = new Server(this);
    }

    /**
     * Startet die Logic (erster Schritt in jedem OO projekt)
     */
    public void start() {
        gui = new GUI(this);
        menu = new Menu(gui);
    }

    public void addClienthandler(ClientHandler clientHandler) {
        clientHandlers.add(clientHandler);
    }

    public ClientHandler getClienthandler(int index) {
        return clientHandlers.get(index);
    }
}
