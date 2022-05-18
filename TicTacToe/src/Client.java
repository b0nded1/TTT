import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends Communication {
    private GUI gui;

    public Client(String ip) throws IOException {
        super(new Socket(ip, 5050));

        online = true;
    }


    @Override
    public void init() {

            while(online){   try {
                String message = receiveMessage();
                System.out.println("Angekommene Nachricht " + message);
                switch (message){
                    case "win" -> gui.displayVictor();
                    

                }
            }catch (IOException e){
                shutdown();
            }
            }
        }


    }


