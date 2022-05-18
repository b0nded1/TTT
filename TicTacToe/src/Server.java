import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;

    private Socket socket;



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
                System.out.println("Client connected");
                control.addClienthandler(new ClientHandler(socket));
                new Thread(control.getClienthandler(i)::init).start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Beide clients sind da");
        }
    }

    }

