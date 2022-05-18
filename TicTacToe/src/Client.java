import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends Communication {
    private GUI gui;
    private Server server;
    public Client(String ip) throws IOException {
        super(new Socket(ip, 5050));

        online = true;
    }


    @Override
    public void init() {
        System.out.println("Socket" + socket.getInetAddress().getHostName() + "connected");


    }
}

