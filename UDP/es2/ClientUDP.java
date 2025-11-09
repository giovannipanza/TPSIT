import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//implementazione di un client (NO MULTICAST) che riceve datagrammi
public class ClientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(12345);

        //mi creo l'array di byte dove infilare tutto quello che ricevo
        byte[] buf=new byte[1024];
        DatagramPacket packet=new DatagramPacket(buf,buf.length);
        socket.receive(packet);

        //estrapolo i byte del pacchetto e li converto in stringa
        String msg=new String(packet.getData(),0,packet.getLength());
        System.out.println(msg);

    }
}
