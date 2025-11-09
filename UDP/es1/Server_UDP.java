import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server_UDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9000);
        DatagramPacket packetReceived, packetToSend;

        byte[] buf=new byte[1024];
        packetReceived=new DatagramPacket(buf,buf.length);

       while(true) {
           socket.receive(packetReceived);
           //converto l'array di byte buf in una stringa
           String msg = new String(packetReceived.getData(), 0, packetReceived.getLength());

           System.out.println("Pacchetto ricevuto..." + msg);

           InetAddress ipSource = packetReceived.getAddress();
           int portSource = packetReceived.getPort();

           System.out.println("Il pacchetto è stato inviato da: " + ipSource.getHostAddress());

           String msg2 = "Contenuto del messaggio da inviare";
           buf = msg2.getBytes();
           packetToSend = new DatagramPacket(buf, buf.length, ipSource, portSource);
           socket.send(packetToSend);
       }


    }
}
