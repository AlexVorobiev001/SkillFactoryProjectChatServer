import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSoket;

    public ChatServer() throws IOException {
        serverSoket = new ServerSocket(1234);
    }

    public void sendAll(String message) {
        for (Client client : clients) {
            for (int i = 0; i < clients.size(); i++) {
            }
            client.receive(message);
        }
    }

    public void run() {
        while (true) {
            System.out.println("Waiting...");
            try {
                Socket socket = serverSoket.accept();
                System.out.println("Client connected!");
                clients.add(new Client(socket, this));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new ChatServer().run();


    }
}