import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class Server {
    Socket server = new Socket();

    public void addLenAndSendMessage(byte[] message) {

        try {
            byte[] len = ByteBuffer.allocate(4)
                    .putInt(message.length)
                    .array();
            byte[] out = ByteBuffer.allocate(len.length + message.length)
                    .put(len)
                    .put(message)
                    .array();

            server.getOutputStream().write(out);
        } catch (IOException e) {
            System.out.println("Could not send Message to " + server.getInetAddress().getHostName());
        }
    }


    }

