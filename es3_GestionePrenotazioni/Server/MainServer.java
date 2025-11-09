package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    //implemento il metodo main
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(12345);
        Sala sala=new Sala();

        while(true) {
           log("In attesa di nuove connessioni");
           Socket s=server.accept();
           log("Client connesso ");

            GestoreClient gc=new GestoreClient(s,sala);
            gc.start();

        }

    }

    private static void log(String msg) {
        System.out.println(msg);
    }
}
