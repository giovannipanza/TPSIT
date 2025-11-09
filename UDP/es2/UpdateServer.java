import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UpdateServer {
    public static void main(String[] args) throws IOException {
        //implemento il meccanismo di invio di un oggetto DatagramPacket su un ip di Multicast
        DatagramSocket socket = new DatagramSocket();
        //String ip = "224.0.0.10"; //scelgo un indirizzo ip di multicast
        String ip="127.0.0.1";

        //converto l'ip in un oggetto InetAddress
        InetAddress inetAddress=InetAddress.getByName(ip);

        //leggo da tastiera il messaggio da inviare
        Scanner sc = new Scanner(System.in);
        String msg=sc.nextLine();

        //preparo il pacchetto (datagramma) da inviare
        DatagramPacket packet=new DatagramPacket(msg.getBytes(),msg.length(),inetAddress,12345);

        //adesso possiamo inviare il pacchetto che abbiamo costruito
        socket.send(packet);
    }
}
