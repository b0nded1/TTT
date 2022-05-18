import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    private Socket socket;

    private GUI gui;

    private Control control;



    public Server(Control control){
        this.control = control;
        try {

            serverSocket = new ServerSocket(5050);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Mit dieser Funktion kannst du dem Server beitreten
     */
    public void startServer(){
        for (int i = 0; i <2 ; i++) {
            try {

                System.out.println("W8ing for client");
                socket = serverSocket.accept();
                System.out.println("Client connected"+ socket.getInetAddress());
                control.addClienthandler(new ClientHandler(socket, gui));
                new Thread(control.getClienthandler(i)::init).start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Beide clients sind da");
        }
    }

    }

