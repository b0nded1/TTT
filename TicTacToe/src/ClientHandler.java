import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler extends Communication {
private GUI gui;
    public ClientHandler(Socket socket, GUI gui) {
        super(socket);

        online = true;
    }

    @Override
    public void init() {
        System.out.println("Socket " + socket.getInetAddress().getHostName() + " connected");
        while(online){   try {
            String message = receiveMessage();
            System.out.println("Angekommene Nachricht " + message);
            switch (message){
                case "win" -> gui.displayVictor();
                case "playerX" -> gui.playerXturn();
                case "playerO" -> gui.playerOturn();
                case "Changeblock" -> gui.

            }
        }catch (IOException e){
            shutdown();
        }



        }
    }
}
